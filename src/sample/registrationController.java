package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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
    private Label registerMessage;

    @FXML
    private Button register;

    @FXML
    private Button cancel;

    private ObservableList<String> accountTypeList = FXCollections.observableArrayList(
            AccountType.US.getAccountType(), AccountType.WK.getAccountType(),
            AccountType.MN.getAccountType(), AccountType.AD.getAccountType());

    ObservableMap<String, String> users = FXCollections.observableHashMap();

    @FXML
    private void initialize() {
        accountTypeBox.setItems(accountTypeList);
    }

    @FXML
    private void registerAction(ActionEvent event) throws IOException {
        if (isInputValid()) {
            users.put(username.getText(), password.getText());
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Parent application = FXMLLoader.load(getClass().getResource("application.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(application);
            stage.setScene(scene);
            stage.setTitle("Application");
            stage.show();
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

    private boolean isInputValid() {
        String errorMessage = "";
        if (accountTypeBox.getValue() == null) {
            errorMessage += "Account type not selected!\n";
        } else if (username.getText() == null || username.getText().length() == 0) {
            errorMessage += "Not a valid username!\n";
        } else if (users.containsKey(username.getText())) {
            errorMessage += "Username already exists!\n";
        } else if (password.getText() == null || password.getText().length() == 0) {
            errorMessage += "Not a valid password!\n";
        } else if (!password.getText().equals(confirmPassword.getText())) {
            errorMessage += "Passwords don't match!\n";
        }
        if (errorMessage.length() == 0) {
            return true;
        } else {
            registerMessage.setText(errorMessage);
            return false;
        }
    }
}
