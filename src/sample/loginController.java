package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Login Controller that gives functionality of login application
 */
public class loginController {
    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private Label loginMessage;

    @FXML
    private Button login;

    @FXML
    private Button cancel;

    /**
     * Handle when "Login" button is pressed --> display Water Application if login credentials are correct
     * Otherwise display error message
     * @param event Clicking "Login" button
     * @throws IOException when corresponding .fxml file does not exist
     */
    @SuppressWarnings({"FeatureEnvy", "ChainedMethodCall"})
    @FXML
    private void loginAction(ActionEvent event) throws IOException {
        WaterApplication persistence = WaterApplication.loadWaterApplication();
        if ((persistence.getUsers() != null) && persistence.getUsers().containsKey(username.getText()) //Need this for validation
                && persistence.getUsers().get(username.getText()).getPassword().equals(password.getText())) {
            applicationController.setUsername(username.getText());
            applicationController.setAccount(persistence.getUsers().get(username.getText()).getAccountType());
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Parent application = FXMLLoader.load(getClass().getResource("application.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(application);
            stage.setScene(scene);
            stage.setTitle("Application");
            stage.show();
        } else {
            loginMessage.setText("Invalid Login Credentials");
        }
    }

    /**
     * Handle when "Cancel" button is pressed --> display Welcome screen
     * @param event Clicking "Cancel" button
     * @throws IOException when corresponding .fxml file does not exist
     */
    @SuppressWarnings("ChainedMethodCall")
    @FXML
    private void cancelAction(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent application = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(application);
        stage.setScene(scene);
        stage.setTitle("Welcome Screen");
        stage.show();
    }
}
