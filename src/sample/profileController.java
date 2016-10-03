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

    @FXML
    private void OKAction(ActionEvent event) throws IOException {
        try {
            applicationController.setUsername(username);
            Profile profile = new Profile(firstName.getText(), lastName.getText(), emailAddress.getText(),
                    ID.getText(), homeAddress.getText(), month.getText(), day.getText(), year.getText());
            WaterApplication.setProfile(username, profile);
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Parent application = FXMLLoader.load(getClass().getResource("application.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(application);
            stage.setScene(scene);
            stage.setTitle("Water Application");
            stage.show();
        } catch (Exception e) {
            errorMessage.setText("Invalid Birthday!");
        }
    }

    @FXML
    private void cancelAction(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent application = FXMLLoader.load(getClass().getResource("application.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(application);
        stage.setScene(scene);
        stage.setTitle("Water Application");
        stage.show();
    }

    public static void setUsername(String _username) {
        username = _username;
    }
}
