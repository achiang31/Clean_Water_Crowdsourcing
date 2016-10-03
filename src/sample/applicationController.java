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
 * Created by bigjohnlin on 9/18/2016.
 */
public class applicationController {
    @FXML
    private Button editProfile;

    @FXML
    private Button logoff;

    private static String username;

    @FXML
    private void editProfileAction(ActionEvent event) throws IOException {
        profileController.setUsername(username);
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent application = FXMLLoader.load(getClass().getResource("profile.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(application);
        stage.setScene(scene);
        stage.setTitle("Profile");
        stage.show();
    }

    @FXML
    private void logoffAction(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent application = FXMLLoader.load(getClass().getResource("welcome.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(application);
        stage.setScene(scene);
        stage.setTitle("Welcome");
        stage.show();
    }

    public static void setUsername(String _username) {
        username = _username;
    }
}

