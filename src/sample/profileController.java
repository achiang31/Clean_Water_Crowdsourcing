package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;

/**
 * Created by Alex on 10/2/16.
 */
public class profileController {

    @FXML
    private TextField firstName;

    @FXML
    private TextField lastName;

    @FXML
    private TextField emailAddress;

    @FXML
    private TextField ID;

    @FXML
    private TextField homeAddress;

    @FXML
    private TextField month;

    @FXML
    private TextField day;

    @FXML
    private TextField year;

    @FXML
    private Button OKButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Label errorMessage;

    private static String username;

    private Date birthday;

    /**
     * Get and display the Profile of current user
     */
    @FXML
    private void initialize() {
        Profile profile = WaterApplication.getUsers().get(username).getProfile();
        if (profile != null) {
            firstName.setText(profile.getFirstName());
            lastName.setText(profile.getLastName());
            emailAddress.setText(profile.getEmailAddress());
            ID.setText(profile.getID());
            homeAddress.setText(profile.getHomeAddress());
            month.setText(Integer.toString(profile.getBirthday().getMonth() + 1));
            day.setText(Integer.toString(profile.getBirthday().getDate()));
            year.setText(Integer.toString(profile.getBirthday().getYear() + 1900));
        }
    }

    /**
     *
     * Handle when "OK" button is pressed --> save changes to profile --> display Water Application
     * @param event Clicking "OK" button
     * @throws IOException when corresponding .fxml file does not exist
     */
    @FXML
    private void OKAction(ActionEvent event) throws IOException {
        if (isInputValid()) {
            applicationController.setUsername(username);
            Profile profile = new Profile(firstName.getText(), lastName.getText(), emailAddress.getText(),
                    ID.getText(), homeAddress.getText(), birthday);
            WaterApplication.setProfile(username, profile);
            WaterApplication.getInstance().saveWaterApplication();
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Parent application = FXMLLoader.load(getClass().getResource("application.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(application);
            stage.setScene(scene);
            stage.setTitle("Water Application");
            stage.show();
        }
    }

    /**
     * Handle when "Cancel" button is pressed --> don't save changes to profile --> display Water Application
     * @param event Clicking "Cancel" button
     * @throws IOException when corresponding .fxml file does not exist
     */
    @FXML
    private void cancelAction(ActionEvent event) throws IOException {
        applicationController.setUsername(username);
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent application = FXMLLoader.load(getClass().getResource("application.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(application);
        stage.setScene(scene);
        stage.setTitle("Water Application");
        stage.show();
    }

    /**
     * Test if user input for profile is valid, if not, display error message on screen
     * @return if input is valid or not
     */
    private boolean isInputValid() {
        String errorMessageStr = "";
        if (firstName.getText() == null || firstName.getText().length() == 0) {
            errorMessageStr += "Empty first name!\n";
        } else if (lastName.getText() == null || lastName.getText().length() == 0) {
            errorMessageStr += "Empty last name!\n";
        } else if (emailAddress.getText() == null || emailAddress.getText().length() == 0) {
            errorMessageStr += "Empty email address!\n";
        } else if (ID.getText() == null || ID.getText().length() == 0) {
            errorMessageStr += "Empty ID!\n";
        } else if (homeAddress.getText() == null || homeAddress.getText().length() == 0) {
            errorMessageStr += "Empty home address!\n";
        } else if (month.getText() == null || month.getText().length() == 0
                || day.getText() == null || day.getText().length() == 0
                || year.getText() == null || year.getText().length() == 0) {
            errorMessageStr += "Empty birthday!\n";
        }
        try {
            birthday = new Date(Integer.parseInt(year.getText()) - 1900,
                    Integer.parseInt(month.getText()) - 1, Integer.parseInt(day.getText()));
        } catch (Exception e) {
            if (errorMessageStr.length() == 0) {
                errorMessageStr += "Not a valid birthday!";
            }
        }
        if (errorMessageStr.length() == 0) {
            return true;
        } else {
            errorMessage.setText(errorMessageStr);
            return false;
        }
    }

    /**
     * Set the username to that of current user operating the application
     * @param _username username of current user
     */
    public static void setUsername(String _username) {
        username = _username;
    }
}
