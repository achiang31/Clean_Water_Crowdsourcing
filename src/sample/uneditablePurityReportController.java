package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;


public class uneditablePurityReportController {
    @FXML
    private Label reporter;

    @FXML
    private Label reportNumber;

    @FXML
    private Label loc;

    @FXML
    private Label dateAndTime;

    @FXML
    private Button goBack;

    @FXML
    private Label date;

    @FXML
    private Label type;

    @FXML
    private Label condition;

    @FXML
    private Label virus;

    @FXML
    private Label conditionPPM;

    private PurityReport report;

    /**
     * initialize the Purity Report with automatic generated info of current user
     */
    @SuppressWarnings("FeatureEnvy")
    @FXML
    private void initialize() {
        report = WaterApplication.getPurityreports().get(purityReportViewController.getReportNum());
        Profile profile = report.getProfile();
        loc.setText(report.getLocation().getStrLoc());
        reporter.setText(profile.getFirstName() + profile.getLastName());
        reportNumber.setText(Integer.toString(report.getReportNum()));
        dateAndTime.setText(report.getDateAndTime().toString());
        condition.setText(report.getOverallCondition().toString());
        virus.setText(Integer.toString(report.getVirusPPM()));
        conditionPPM.setText(Integer.toString(report.getContaminatePPM()));
    }

    /**
     * Handle when "goBack" button is pressed --> display report view
     * @param event Clicking "goBack" button
     * @throws IOException when corresponding .fxml file does not exist
     */
    @FXML
    private void goBackAction(ActionEvent event) throws IOException {
        reportViewController.setReport(report);
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent reportView = FXMLLoader.load(getClass().getResource("viewPurityReports.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(reportView);
        stage.setScene(scene);
        stage.setTitle("Purity Report View");
        stage.show();
    }
}




