package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class purityReportViewController {
    @FXML
    private ListView<PurityReport> listPurityReports;
    @FXML
    private Button goBack;

    private static PurityReport report;
    private static int reportNum;


    /**
     * initialize the Purity Report List View
     */
    @FXML
    private void initialize() {
        List<PurityReport> reportList = WaterApplication.getPurityreportList();
        ObservableList<PurityReport> obsReportList = FXCollections.observableList(reportList);
        listPurityReports.setItems(obsReportList);
        listPurityReports.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                try {
                    report = listPurityReports.getSelectionModel().getSelectedItem();
                    reportNum = report.getReportNum();
                    ((Node) (mouseEvent.getSource())).getScene().getWindow().hide();
                    Parent uneditablePurityReport = FXMLLoader.load(getClass().getResource("uneditablePurityReport.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(uneditablePurityReport);
                    stage.setScene(scene);
                    stage.setTitle("Purity Report");
                    stage.show();
                }
                catch (IOException e) {
                    e.printStackTrace();
                    System.out.println(e.getMessage());
                }
            }
        });

    }

    /**
     * Handle when "goBack" button is pressed --> display Water Application
     * @param event Clicking "goBack" button
     * @throws IOException when corresponding .fxml file does not exist
     */
    @FXML
    private void goBackAction(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent application = FXMLLoader.load(getClass().getResource("application.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(application);
        stage.setScene(scene);
        stage.setTitle("Water Application");
        stage.show();
    }

    /**
     * Set the report for the reportViewController
     * @param _report report number for the report
     */
    public static void setReport(PurityReport _report) {
        report = _report;
    }

    /**
     * Get the report number of the report
     * @return report number in the report
     */
    public static int getReportNum() {
        return reportNum;
    }
}





