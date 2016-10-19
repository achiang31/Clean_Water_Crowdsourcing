package sample;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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

    @FXML
    private Button createReports;

    @FXML
    private Button viewReports;

    @FXML
    private Button availabilityButton;

    private static String username;

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

    @FXML
    private void viewAvailabilityButton(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent report = FXMLLoader.load(getClass().getResource("mapview.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(report);
        stage.setScene(scene);
        stage.setTitle("Map");
        stage.show();
    }

    /**
     * Set the username to that of current user operating the application
     * @param _username username of current user
     */
    public static void setUsername(String _username) {
        username = _username;
    }
}

