package Controller;

import Model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Controller to manage purity application
 */
public class purityController {
    @FXML
    private Label reporter;

    @FXML
    private Label reportNumber;

    @FXML
    private TextField lat;

    @FXML
    private TextField lon;

    @FXML
    private Label dateAndTime;

    @FXML
    private Button submitButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Label errorMessage;

    @FXML
    private ToggleGroup OverallConditionGroup;

    private static String username;

    private static int reportNum;

    private Profile profile;

    private Date date;

    private double latitude;

    private double longitude;

    @FXML
    private TextField virusPPM;

    @FXML
    private TextField contPPM;

    /**
     * initialize the Purity Report with automatic generated info of current user
     */
    @SuppressWarnings("FeatureEnvy")
    @FXML
    private void initialize() {
        WaterApplication persist = WaterApplication.loadWaterApplication();
        List<PurityReport> list = persist.getPurityreportList();
        reportNum = list.size();
        Map<String, User> map = WaterApplication.getUsers();
        User user = map.get(username);
        profile = user.getProfile();
        reporter.setText(profile.getFirstName() + " " + profile.getLastName());
        reportNumber.setText(Integer.toString(reportNum + 1));
        Calendar instance = Calendar.getInstance();
        date = instance.getTime();
        dateAndTime.setText(date.toString());
    }
    /**
     *
     * Handle when "submitAction" button is pressed --> save changes to report --> display Water Application
     * @param event Clicking "submitAction" button
     * @throws IOException when corresponding .fxml file does not exist
     */
    @SuppressWarnings({"FeatureEnvy", "AssignmentToStaticFieldFromInstanceMethod", "ChainedMethodCall"})
    @FXML
    private void submitAction(ActionEvent event) throws IOException {
        if (isInputValid()) {
            reportNum++;
            String title = "Report " + reportNum;
            String description = descriptionFormatter();
            Location location = new Location(latitude, longitude, lat.getText() + ","
                    + lon.getText(), title, description);
            PurityReport pureReport = new PurityReport(location);
            pureReport.setUserProfile(profile);
            pureReport.setDateAndTime(date);
            pureReport.setReportNum(reportNum);
            RadioButton conditionButton = (RadioButton) OverallConditionGroup.getSelectedToggle();
            String cond = conditionButton.getText();
            pureReport.setOverallCondition((cond.toUpperCase()));
            pureReport.setConditionPPM(Integer.parseInt(contPPM.getText()));
            pureReport.setVirusPPM(Integer.parseInt(virusPPM.getText()));
            WaterApplication app = WaterApplication.getInstance();
            app.addPurityReport(pureReport);
            app.saveWaterApplication();
            ((Node) (event.getSource())).getScene().getWindow().hide();
            Parent application = FXMLLoader.load(getClass().getResource("../View/application.fxml"));
            Stage stage = new Stage();
            Scene scene = new Scene(application);
            stage.setScene(scene);
            stage.setTitle("Water Application");
            stage.show();
        }
    }
    /**
     * Test if user input for purity report is valid, if not, display error message on screen
     * @return if input is valid or not
     */
    @SuppressWarnings("MagicNumber")
    private boolean isInputValid() {
        String errorMessageStr = "";
        String la = lat.getText();
        String lo = lon.getText();
        if ((lat.getText() == null) || la.isEmpty()) {
            errorMessageStr += "Empty latitude!\n";
        } else {
            try {
                double latitude = Double.parseDouble(lat.getText());
                if ((latitude < -90.0) || (latitude > 90.0)) {
                    errorMessageStr += "Invalid latitude!\n";
                } else {
                    this.latitude = latitude;
                }
            } catch (NumberFormatException e) {
                errorMessageStr += "Invalid latitude!\n";
            }
        }
        if (errorMessageStr.isEmpty()) {
            if ((lon.getText() == null) || lo.isEmpty()) {
                errorMessageStr += "Empty longitude!\n";
            } else {
                try {
                    double longitude = Double.parseDouble(lon.getText());
                    if ((longitude < -180.0) || (longitude > 180.0)) {
                        errorMessageStr += "Invalid longitude!\n";
                    } else {
                        this.longitude = longitude;
                    }
                } catch (NumberFormatException e) {
                    errorMessageStr += "Invalid longitude!\n";
                }
            }
        }
        if (errorMessageStr.isEmpty()) {
            String virusS = virusPPM.getText();
            if ((virusPPM.getText() == null) || virusS.isEmpty()) {
                errorMessageStr += "Empty virus PPM!\n";
            } else {
                try {
                    int virus = Integer.parseInt(virusPPM.getText());
                    if (virus < 0) {
                        errorMessageStr += "Invalid virus PPM!\n";
                    }
                } catch (NumberFormatException e) {
                    errorMessageStr += "Invalid virus PPM!\n";
                }
            }
        }
        if (errorMessageStr.isEmpty()) {
            String contS = contPPM.getText();
            if ((contPPM.getText() == null) || contS.isEmpty()) {
                errorMessageStr += "Empty contaminant PPM!\n";
            } else {
                try {
                    int cont = Integer.parseInt(contPPM.getText());
                    if (cont < 0) {
                        errorMessageStr += "Invalid contaminant PPM!\n";
                    }
                } catch (NumberFormatException e) {
                    errorMessageStr += "Invalid contaminant PPM!\n";
                }
            }
        }
        if (errorMessageStr.isEmpty()) {
            RadioButton overall = (RadioButton) OverallConditionGroup.getSelectedToggle();
            if (overall == null) {
                errorMessageStr += "Must select an overall condition!\n";
            }
        }
        if (errorMessageStr.isEmpty()) {
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
    @SuppressWarnings("ChainedMethodCall")
    @FXML
    private void cancelAction(ActionEvent event) throws IOException {
        applicationController.setUsername(username);
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent application = FXMLLoader.load(getClass().getResource("../View/application.fxml"));
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

    /**
     * Format for printing out the report and date
     * @return description
     */
    private String descriptionFormatter() {
        String reporter = profile.getFirstName() + " " + profile.getLastName();
        return reporter + " submitted this report on: " + date;
    }
}
