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

    /**
     * Set items in Account Type ComboBox to account types
     */
    @FXML
    private void initialize() {
        accountTypeBox.setItems(accountTypeList);
    }

    /**
     * Handle when "Register" button is pressed --> save user information --> display Water Application
     * @param event Clicking "Register" button
     * @throws IOException when corresponding .fxml file does not exist
     */
    @FXML
    private void registerAction(ActionEvent event) throws IOException {
        if (isInputValid()) {
            profileController.setUsername(username.getText());
            String accountType = accountTypeBox.getSelectionModel().getSelectedItem().toString();
            AccountType account = determineAccountType(accountType);
            applicationController.setAccount(account);
            WaterApplication app = WaterApplication.getInstance();
            app.addUser(account, username.getText(), password.getText());
            app.saveWaterApplication();
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Parent application = FXMLLoader.load(getClass().getResource("profile.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(application);
            stage.setScene(scene);
            stage.setTitle("Profile");
            stage.show();
        }
    }

    public static AccountType determineAccountType(String name) {
        if (name.equals("User")) {
            return AccountType.US;
        } else if (name.equals("Worker")) {
            return AccountType.WK;
        } else if (name.equals("Manager")) {
            return AccountType.MN;
        } else {
            return AccountType.AD;
        }
    }
    /**
     * Handle when "Cancel" button is pressed --> don't save user information --> display Welcome screen
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

    /**
     * Test if user input for profile is valid, if not, display error message on screen
     * @return if input is valid or not
     */
    private boolean isInputValid() {
        String errorMessage = "";
        if (accountTypeBox.getValue() == null) {
            errorMessage += "Empty account type!\n";
        } else if (username.getText() == null || username.getText().length() == 0) {
            errorMessage += "Not a valid username!\n";
        } else if (WaterApplication.getUsers() != null && WaterApplication.getUsers().containsKey(username.getText())) {
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
