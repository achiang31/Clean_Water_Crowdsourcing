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
import java.util.Date;
import java.util.Map;

/**
 * Uneditable Report Controller
 */
public class uneditableReportController {
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

    private Report report;

    /**
     * initialize the Report with automatic generated info of current user
     */
    @SuppressWarnings("FeatureEnvy")
    @FXML
    private void initialize() {
        Map<Integer, Report> reports = WaterApplication.getReports();
        int num = reportViewController.getReportNum();
        report = reports.get(num);
        Profile profile = report.getProfile();
        Location land = report.getLocation();
        loc.setText(land.getStrLoc());
        reporter.setText(profile.getFirstName() + profile.getLastName());
        reportNumber.setText(Integer.toString(num));
        Date date = report.getDateAndTime();
        dateAndTime.setText(date.toString());
        Type t = report.getType();
        type.setText(t.toString());
        Condition con = report.getCondition();
        condition.setText(con.toString());
    }

    /**
     * Handle when "goBack" button is pressed --> display report view
     * @param event Clicking "goBack" button
     * @throws IOException when corresponding .fxml file does not exist
     */
    @SuppressWarnings("ChainedMethodCall")
    @FXML
    private void goBackAction(ActionEvent event) throws IOException {
        reportViewController.setReport(report);
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent reportView = FXMLLoader.load(getClass().getResource("viewReports.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(reportView);
        stage.setScene(scene);
        stage.setTitle("Report View");
        stage.show();
    }
}




