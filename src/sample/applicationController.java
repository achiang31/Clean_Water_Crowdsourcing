package sample;


import com.google.gson.Gson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by bigjohnlin on 9/18/2016.
 */
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

    @FXML
    private Button createPurityReport;

    @FXML
    private Button viewPurityReport;

    @FXML
    private Button callHistoricalReport;

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
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent application = FXMLLoader.load(getClass().getResource("profile.fxml"));
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
        Parent application = FXMLLoader.load(getClass().getResource("welcome.fxml"));
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
        Parent report = FXMLLoader.load(getClass().getResource("report.fxml"));
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
        if (Objects.equals(account.getAbbrType(), "WK") || Objects.equals(account.getAbbrType(), "MN")) {
            purityController.setUsername(username);
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Parent report = FXMLLoader.load(getClass().getResource("purityReport.fxml"));
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
     * Handle when "ViewPurityReports" button is pressed --> end current user session --> display view of PurityReports screen
     * @param event Clicking "viewPurityReports" button
     * @throws IOException when corresponding .fxml file does not exist
     */
    @FXML
    private void viewPurityReport(ActionEvent event) throws IOException {
        if (Objects.equals(account.getAbbrType(), "MN")) {
        reportController.setUsername(username);
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent report = FXMLLoader.load(getClass().getResource("viewPurityReports.fxml"));
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
        Parent report = FXMLLoader.load(getClass().getResource("viewReports.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(report);
        stage.setScene(scene);
        stage.setTitle("Report");
        stage.show();
    }

    /**
     * Handle when "viewAvailabilityReport" button is pressed --> end current user session --> display view of availability Reports screen
     * @param event Clicking "createReports" button
     * @throws IOException when corresponding .fxml file does not exist
     */
    @FXML
    private void viewAvailabilityAction(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent report = FXMLLoader.load(getClass().getResource("mapview.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(report);
        stage.setScene(scene);
        stage.setTitle("Map");
        stage.show();
    }

    @FXML
    private void callHistRep(ActionEvent event) throws IOException {
        historicalReportController.setUsername(username);
        historicalReportController.setAccount(account);
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent historyReport = FXMLLoader.load(getClass().getResource("historicalReport.fxml"));
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



    public void saveApplicationController() {
        try {
            try (PrintWriter out = new PrintWriter(new File("ACdata.json"))) {
                Gson gs = new Gson();
                String gson = gs.toJson(this);
                out.println(gson);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WaterApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static applicationController loadApplicationController() {
        try {
            try (BufferedReader br = new BufferedReader(new FileReader("ACdata.json"))) {
                Gson gs = new Gson();
                File loading = new File("ACdata.json");
                FileInputStream fis = new FileInputStream(loading);
                byte[] data = new byte[(int) loading.length()];
                //noinspection ResultOfMethodCallIgnored
                fis.read(data);
                fis.close();
                String str = new String(data, "UTF-8");
                return gs.fromJson(str, applicationController.class);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(applicationController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(applicationController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

