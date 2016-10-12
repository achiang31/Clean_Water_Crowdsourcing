package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by xingxing on 10/5/16.
 */
public class reportController {
    @FXML
    private Label reporter;

    @FXML
    private Label reportNumber;

    @FXML
   private TextField loc;

    @FXML
    private Label dateAndTime;

    @FXML
    private Button submitButton;

    @FXML
    private Button cancelButton;
    @FXML
    private Label errorMessage;

    private static String username;

    public static int reportNum;

    private Profile profile;

    private Date date;

    /**
     * initialize the Report with automoatic generated info of current user
     */
    @FXML
    private void initialize() {
        profile = WaterApplication.getUsers().get(username).getProfile();
        reporter.setText(profile.getFirstName() + profile.getLastName());
        reportNumber.setText(Integer.toString(reportNum + 1));
        date = Calendar.getInstance().getTime();
        dateAndTime.setText(date.toString());
    }
    /**
     *
     * Handle when "submitButton" button is pressed --> save changes to report --> display Water Application
     * @param event Clicking "submitButton" button
     * @throws IOException when corresponding .fxml file does not exist
     */
    @FXML
    private void submitAction(ActionEvent event) throws IOException {
        if (isInputValid()) {
            reportNum++;
            Report report = WaterApplication.addReport(loc.getText());
            report.setUserProfile(profile);
            report.setDateAndTime(dateAndTime.getText());
            report.setReportNum(reportNum);
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Parent application = FXMLLoader.load(getClass().getResource("application.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(application);
            stage.setScene(scene);
            stage.setTitle("Water Application");
            stage.show();
        }
    }
    /**
     * Test if user input for profile is valid, if not, display error message on screen
     * @return if input is valid or not
     */
    private boolean isInputValid() {
        String errorMessageStr = "";
        if (loc.getText() == null || loc.getText().length() == 0) {
            errorMessageStr += "Empty location\n";
        }
        if (errorMessageStr.length() == 0) {
            return true;
        } else {
            errorMessage.setText(errorMessageStr);
            return false;
        }
    }

    /**
     * Handle when "Cancel" button is pressed --> don't save changes to report --> display Water Application
     * @param event Clicking "cancel" button
     * @throws IOException when corresponding .fxml file does not exist
     */
    @FXML
    private void cancelAction(ActionEvent event) throws IOException {
        applicationController.setUsername(username);
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent application = FXMLLoader.load(getClass().getResource("application.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(application);
        stage.setScene(scene);
        stage.setTitle("Water Application");
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




