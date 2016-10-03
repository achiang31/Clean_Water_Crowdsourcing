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

    @FXML
    private void loginAction(ActionEvent event) throws IOException {
        if (WaterApplication.getUsers() != null && WaterApplication.getUsers().containsKey(username.getText())
                && WaterApplication.getUsers().get(username.getText()).getPassword().equals(password.getText())) {
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Parent application = FXMLLoader.load(getClass().getResource("application.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(application);
            stage.setScene(scene);
            stage.setTitle("Application");
            stage.show();
            applicationController.setUsername(username.getText());
        } else {
            loginMessage.setText("Invalid Login Credentials");
        }
    }

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
