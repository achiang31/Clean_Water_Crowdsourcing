package Controller;

import Model.AccountType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import Model.User;
import Model.WaterApplication;

import java.io.IOException;
import java.util.Map;

/**
 * Registration Controller
 */
public class registrationController {
    @FXML
    private ComboBox<String> accountTypeBox;

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

    private final ObservableList<String> accountTypeList = FXCollections.observableArrayList(
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
    @SuppressWarnings({"FeatureEnvy", "ChainedMethodCall"})
    @FXML
    private void registerAction(ActionEvent event) throws IOException {
        if (isInputValid()) {
            profileController.setUsername(username.getText());
            SingleSelectionModel<String> acc = accountTypeBox.getSelectionModel();
            String accountType = acc.getSelectedItem();
            AccountType account = determineAccountType(accountType);
            applicationController.setAccount(account);
            WaterApplication app = WaterApplication.getInstance();
            app.addUser(account, username.getText(), password.getText());
            app.saveWaterApplication();
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Parent application = FXMLLoader.load(getClass().getResource("../View/profile.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(application);
            stage.setScene(scene);
            stage.setTitle("Profile");
            stage.show();
        }
    }

    /**
     * Method to determine which account type is active
     * @param name of the account type
     * @return the enum accoun type
     */
    public static AccountType determineAccountType(String name) {
        if ("User".equals(name)) {
            return AccountType.US;
        } else if ("Worker".equals(name)) {
            return AccountType.WK;
        } else if ("Manager".equals(name)) {
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
    @SuppressWarnings("ChainedMethodCall")
    @FXML
    private void cancelAction(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent application = FXMLLoader.load(getClass().getResource("../View/welcome.fxml"));
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
        String user = username.getText();
        String pw = password.getText();
        String cpw = confirmPassword.getText();
        Map<String, User> usList = WaterApplication.getUsers();
        if (accountTypeBox.getValue() == null) {
            errorMessage += "Empty account type!\n";
        } else if ((username.getText() == null) || user.isEmpty()) {
            errorMessage += "Not a valid username!\n";
        } else if ((WaterApplication.getUsers() != null) &&
                usList.containsKey(user)) {
            errorMessage += "Username already exists!\n";
        } else if ((password.getText() == null) || pw.isEmpty()) {
            errorMessage += "Not a valid password!\n";
        } else if (!pw.equals(cpw)) {
            errorMessage += "Passwords don't match!\n";
        }
        if (errorMessage.isEmpty()) {
            return true;
        } else {
            registerMessage.setText(errorMessage);
            return false;
        }
    }
}
