package Controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import Model.Profile;
import Model.User;
import Model.WaterApplication;

import java.io.IOException;
import java.util.Date;
import java.util.Map;

/**
 * Profile Controller
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
    @SuppressWarnings("FeatureEnvy")
    @FXML
    private void initialize() {
        Map<String, User> prop = WaterApplication.getUsers();
        User user = prop.get(username);
        Profile profile = user.getProfile();
        if (profile != null) {
            firstName.setText(profile.getFirstName());
            lastName.setText(profile.getLastName());
            emailAddress.setText(profile.getEmailAddress());
            ID.setText(profile.getID());
            homeAddress.setText(profile.getHomeAddress());
            month.setText(Integer.toString(profile.getBirthday().getMonth() + 1)); //Alex does this
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
    @SuppressWarnings({"FeatureEnvy", "ChainedMethodCall"})
    @FXML
    private void OKAction(ActionEvent event) throws IOException {
        if (isInputValid()) {
            applicationController.setUsername(username);
            Profile profile = new Profile(firstName.getText(), lastName.getText(), emailAddress.getText(),
                    ID.getText(), homeAddress.getText(), birthday);
            WaterApplication.setProfile(username, profile);
            WaterApplication instance = WaterApplication.getInstance();
            instance.saveWaterApplication();
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Parent application = FXMLLoader.load(getClass().getResource("../View/application.fxml"));
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
    @SuppressWarnings("ChainedMethodCall")
    @FXML
    private void cancelAction(ActionEvent event) throws IOException {
        applicationController.setUsername(username);
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent application = FXMLLoader.load(getClass().getResource("../View/application.fxml"));
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
        String first = firstName.getText();
        String last = lastName.getText();
        String email = emailAddress.getText();
        String home = homeAddress.getText();
        String mon = month.getText();
        String y = year.getText();
        String d = day.getText();
        String id = ID.getText();
        if ((firstName.getText() == null) || first.isEmpty()) {
            errorMessageStr += "Empty first name!\n";
        } else if ((lastName.getText() == null) || last.isEmpty()) {
            errorMessageStr += "Empty last name!\n";
        } else if ((emailAddress.getText() == null) || email.isEmpty()) {
            errorMessageStr += "Empty email address!\n";
        } else if (!validateEmail(email)) {
            errorMessageStr += "Invalid email address!\n";
        } else if ((ID.getText() == null) || id.isEmpty()) {
            errorMessageStr += "Empty ID!\n";
        } else if ((homeAddress.getText() == null) || home.isEmpty()) {
            errorMessageStr += "Empty home address!\n";
        } else if ((month.getText() == null) || mon.isEmpty()
                || (day.getText() == null) || d.isEmpty()
                || (year.getText() == null) || y.isEmpty()) {
            errorMessageStr += "Empty birthday!\n";
        }
        try {
            birthday = new Date(Integer.parseInt(year.getText()) - 1900,
                    Integer.parseInt(month.getText()) - 1, Integer.parseInt(day.getText()));
        } catch (Exception e) {
            if (errorMessageStr.isEmpty()) {
                errorMessageStr += "Not a valid birthday!";
            }
        }
        if (errorMessageStr.isEmpty()) {
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

    /**
     * Validate the entered email
     * @param email Entered by user
     * @return If the email is valid
     */
    public static boolean validateEmail(String email) {
        if (email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Cannot have null or empty email address!\n");
        }
        return (email.contains("@") && email.charAt(0) != '@' && email.charAt(email.length() - 4) == '.');
    }
}
