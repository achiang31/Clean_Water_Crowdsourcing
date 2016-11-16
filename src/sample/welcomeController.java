package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Controller class to manage welcome screen
 */
public class welcomeController {
    @FXML
    private Button register;

    @FXML
    private Button login;

    /**
     * Handle when "Login" button is pressed --> display Login screen
     * @param event Clicking "Login" button
     * @throws IOException when corresponding .fxml file does not exist
     */
    @FXML
    private void loginClick(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent application = FXMLLoader.load(getClass().getResource("login.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(application);
        stage.setScene(scene);
        stage.setTitle("Login Screen");
        stage.show();
    }

    /**
     * Handle when "Register" button is pressed --> display Register screen
     * @param event Clicking "Register" button
     * @throws IOException when corresponding .fxml file does not exist
     */
    @FXML
    private void registerClick(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent application = FXMLLoader.load(getClass().getResource("registration.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(application);
        stage.setScene(scene);
        stage.setTitle("Registration Screen");
        stage.show();
    }



}
