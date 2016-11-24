package Controller;

import Model.AccountType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

/**
 * Application Controller
 */
@SuppressWarnings("ChainedMethodCall")
public class applicationController {
    @FXML
    private Button editProfile;

    @FXML
    private Button logoff;

    @FXML
    private Button createReports;

    @FXML
    private Button viewReports;

    @FXML
    private Button availabilityButton;


    private static String username;
    private static AccountType account;

    /**
     * Handle when "Edit Profile" button is pressed --> display Profile of the current user
     * @param event Clicking "Edit Profile" button
     * @throws IOException when corresponding .fxml file does not exist
     */
    @FXML
    private void editProfileAction(ActionEvent event) throws IOException {
        profileController.setUsername(username);
        //noinspection ChainedMethodCall
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent application = FXMLLoader.load(getClass().getResource("../View/profile.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(application);
        stage.setScene(scene);
        stage.setTitle("Profile");
        stage.show();
    }


    /**
     * Handle when "Log Off" button is pressed --> end current user session --> display Welcome screen
     * @param event Clicking "Log Off" button
     * @throws IOException when corresponding .fxml file does not exist
     */
    @FXML
    private void logoffAction(ActionEvent event) throws IOException {

        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent application = FXMLLoader.load(getClass().getResource("../View/welcome.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(application);
        stage.setScene(scene);
        stage.setTitle("Welcome");
        stage.show();
    }

    /**
     * Handle when "createReports" button is pressed --> end current user session --> display Reports screen
     * @param event Clicking "createReports" button
     * @throws IOException when corresponding .fxml file does not exist
     */
    @FXML
    private void createReportsAction(ActionEvent event) throws IOException {
        reportController.setUsername(username);
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent report = FXMLLoader.load(getClass().getResource("../View/report.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(report);
        stage.setScene(scene);
        stage.setTitle("Report");
        stage.show();
    }
    /**
     * Handle when "createPurityReport" button is pressed --> end current user session --> display Purity Reports screen
     * @param event Clicking "createPurityReports" button
     * @throws IOException when corresponding .fxml file does not exist
     */
    @FXML
    private void createPurityReport(ActionEvent event) throws IOException {
        if ((Objects.equals(account.getAbbrType(), "WK")) || (Objects.equals(account.getAbbrType(), "MN"))) {
            purityController.setUsername(username);
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Parent report = FXMLLoader.load(getClass().getResource("../View/purityReport.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(report);
            stage.setScene(scene);
            stage.setTitle("Purity Report");
            stage.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Credentials");
            alert.setHeaderText("Invalid Credentials");
            alert.setContentText("You do not have permission to perform this task!");
            alert.showAndWait();
        }
    }
    /**
     * Handle when "ViewPurityReports" button is pressed -->
     * end current user session --> display view of PurityReports screen
     * @param event Clicking "viewPurityReports" button
     * @throws IOException when corresponding .fxml file does not exist
     */
    @FXML
    private void viewPurityReport(ActionEvent event) throws IOException {
        if (Objects.equals(account.getAbbrType(), "MN")) {
        reportController.setUsername(username);
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent report = FXMLLoader.load(getClass().getResource("../View/viewPurityReports.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(report);
        stage.setScene(scene);
        stage.setTitle("Purity Report");
        stage.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Invalid Credentials");
            alert.setHeaderText("Invalid Credentials");
            alert.setContentText("You do not have permission to perform this task!");
            alert.showAndWait();
        }
    }
    /**
     * Handle when "viewReports" button is pressed --> end current user session --> display Reports screen
     * @param event Clicking "viewReports" button
     * @throws IOException when corresponding .fxml file does not exist
     */
    @FXML
    private void viewReportsAction(ActionEvent event) throws IOException {
        reportController.setUsername(username);
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent report = FXMLLoader.load(getClass().getResource("../View/viewReports.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(report);
        stage.setScene(scene);
        stage.setTitle("Report");
        stage.show();
    }

    /**
     * Handle when "viewAvailabilityReport" button is pressed -->
     * end current user session --> display view of availability Reports screen
     * @param event Clicking "createReports" button
     * @throws IOException when corresponding .fxml file does not exist
     */
    @FXML
    private void viewAvailabilityAction(ActionEvent event) throws IOException {
        Parent report = FXMLLoader.load(getClass().getResource("../View/mapview.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(report);
        stage.setScene(scene);
        stage.setTitle("Map");
        stage.show();
    }

    @FXML
    private void callHistRep(ActionEvent event) throws IOException {
        historicalReportController.setAccount(account);
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent historyReport = FXMLLoader.load((getClass().getResource("../View/historicalReport.fxml")));
        Stage stage = new Stage();
        Scene scene = new Scene(historyReport);
        stage.setScene(scene);
        stage.setTitle("LocVirOrContYear");
        stage.show();
    }

    /**
     * Set the username to that of current user operating the application
     * @param _username username of current user
     */
    public static void setUsername(String _username) {
        username = _username;
    }
    /**
     * Set the account type of current user operating the application
     * @param _account accountType of current user
     */
    public static void setAccount(AccountType _account){ account = _account; }


}

