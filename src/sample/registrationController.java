package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Created by Zihan Xu on 10/1/16.
 */
public class registrationController {
    @FXML
    private ComboBox accountTypeBox;

    @FXML
    private TextField username;

    @FXML
    private PasswordField password;

    @FXML
    private PasswordField confirmPassword;

    @FXML
    private Button register;

    @FXML
    private Button cancel;

    private ObservableList<String> accountTypeList = FXCollections.observableArrayList(
            "User", "Worker", "Manager", "Administrator");

    @FXML
    private void initialize() {
        accountTypeBox.setItems(accountTypeList);
    }

    @FXML
    private void registerAction(ActionEvent event) throws IOException {

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
