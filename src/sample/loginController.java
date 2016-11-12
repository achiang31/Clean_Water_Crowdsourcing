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
 * Created by bigjohnlin on 9/18/2016.
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
    @SuppressWarnings("FeatureEnvy")
    @FXML
    private void loginAction(ActionEvent event) throws IOException {
        WaterApplication persistence = WaterApplication.loadWaterApplication();
        System.out.println(persistence.getUsers());
//        if (WaterApplication.getUsers() != null && WaterApplication.getUsers().containsKey(username.getText())
//                && WaterApplication.getUsers().get(username.getText()).getPassword().equals(password.getText())) {
        if (persistence.getUsers() != null && persistence.getUsers().containsKey(username.getText())
                && persistence.getUsers().get(username.getText()).getPassword().equals(password.getText())) {
            applicationController.setUsername(username.getText());
            applicationController.setAccount(persistence.getUsers().get(username.getText()).getAccountType()); //need to fix this bad design principle
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
