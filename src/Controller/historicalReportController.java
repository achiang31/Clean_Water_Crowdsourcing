package Controller;

import Model.AccountType;
import Model.historicalReport;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import Model.Location;
import Model.PurityReport;
import Model.WaterApplication;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import static Model.AccountType.MN;

/**
 * Historical Report Controller
 */
public class historicalReportController implements Initializable {
    @FXML
    private ComboBox<String> VorC;

    @FXML
    private ComboBox<Location> loc;

    @FXML
    private ComboBox<Integer> year;

    @FXML
    private Label notMN;

    @FXML
    private Label plzSelect;

    private static final ObservableMap<Integer, List<PurityReport>> map = FXCollections.observableHashMap();
    private static final ObservableMap<Integer, Integer> virusMap = FXCollections.observableHashMap();
    private static final ObservableMap<Integer, Integer> contaminationMap = FXCollections.observableHashMap();
    private static AccountType account;

    @SuppressWarnings({"FeatureEnvy", "MagicNumber", "ChainedMethodCall"})
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //get all the valid years//
        List<PurityReport> validReport = WaterApplication.getPurityreportList();
        ObservableList<PurityReport> obsReportList = FXCollections.observableList(validReport);
        Collection<Integer> allYears = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        for (int a = 0; a < 12; a++) {
            map.put(a, new ArrayList<>());
        }
        for (PurityReport aValidReport1 : validReport) {
            cal.setTime(aValidReport1.getDateAndTime());
            int yea = cal.get(Calendar.YEAR);
            if (!allYears.contains(yea)) {
                allYears.add(yea);
            }
        }

        Collection<Location> allLocs = new ArrayList<>();
        validReport.stream().filter(aValidReport ->
                !allLocs.contains(aValidReport.getLocation())).forEach(aValidReport ->
                allLocs.add(aValidReport.getLocation())); // cannot deal with Historical report format
        //get all the valid locations//
        ObservableList<String> list = VorC.getItems();
        list.removeAll(VorC.getItems());
        ObservableList<String> paramList = VorC.getItems();
        paramList.addAll("Virus", "Contamination");
        ObservableList<Integer> time = year.getItems();
        time.removeAll(year.getItems());
        time.addAll(allYears);
        ObservableList<Location> locList =loc.getItems();
        locList.removeAll(loc.getItems());
        locList.addAll(allLocs);
    }

    /**
     * Handle when "plot" button is pressed --> display historical report of
     * selected year, location, and contamination type
     * @param event Clicking "plot" button
     */

    @SuppressWarnings("ChainedMethodCall")
    @FXML
    private void showGraph(ActionEvent event) {
        if (account == MN) {
            Stage stage = new Stage();
            int selectedYear = year.getSelectionModel().getSelectedItem();
            if((year.getValue() != null) && (loc.getValue() != null)) {
                List<PurityReport> reportList = WaterApplication.getPurityreportList();
                ObservableList<PurityReport> obsReportList = FXCollections.observableList(reportList);
                reportList.stream().filter(purityReport -> (purityReport.getDateAndTime().getYear() + 1900)
                        == selectedYear).forEach(purityReport -> {
                    map.get(purityReport.getDateAndTime().getMonth()).add(purityReport);
                    createVirusMap();
                    createContaminationMap();
                });
                if ("Virus".equals(VorC.getSelectionModel().getSelectedItem())) {
                    new historicalReport(year.getSelectionModel().getSelectedItem(),
                            loc.getSelectionModel().getSelectedItem(),
                            VorC.getSelectionModel().getSelectedItem(), virusMap).start(stage);
                } else {
                   new historicalReport(year.getSelectionModel().getSelectedItem(),
                           loc.getSelectionModel().getSelectedItem(),
                           VorC.getSelectionModel().getSelectedItem(), contaminationMap).start(stage);
                }
            } else {
                plzSelect.setText("Please select year and location");
            }
        }else{
            notMN.setText("Not a manager!");
        }
    }

    private void createVirusMap() {
        for (Map.Entry<Integer, List<PurityReport>> entry: map.entrySet()) {
            int month = entry.getKey();
            List<PurityReport> list = entry.getValue();
            if (list.size() > 1) {
                int average = averageVirus(list);
                virusMap.put(month, average);
            } else if (list.size() == 1) {
                PurityReport report = list.get(0);
                virusMap.put(month, report.getVirusPPM());
            } else {
                virusMap.put(month, 0);
            }
        }
    }

    private void createContaminationMap() {
        for (Map.Entry<Integer, List<PurityReport>> entry: map.entrySet()) {
            int month = entry.getKey();
            List<PurityReport> list = entry.getValue();
            if (list.size() > 1) {
                int average = averageContamination(list);
                contaminationMap.put(month, average);
            } else if (list.size() == 1) {
                PurityReport report = list.get(0);
                contaminationMap.put(month, report.getVirusPPM());
            } else {
                contaminationMap.put(month, 0);
            }
        }
    }

    private int averageVirus(Collection<PurityReport> reports) {
        int average = 0;
        int size = reports.size();
        for (PurityReport rep: reports) {
            average += rep.getVirusPPM();
        }
        return average/size;
    }

    private int averageContamination(Collection<PurityReport> reports) {
        int average = 0;
        int size = reports.size();
        for (PurityReport rep: reports) {
            average += rep.getContaminatePPM();
        }
        return average/size;
    }

    /**
     * Handle when "goBack" button is pressed --> display Water Application
     * @param event Clicking "goBack" button
     * @throws IOException when corresponding .fxml file does not exist
     */
    @SuppressWarnings("ChainedMethodCall")
    @FXML
    private void goBackAction(ActionEvent event) throws IOException {
        ((Node) (event.getSource())).getScene().getWindow().hide();
        Parent application = FXMLLoader.load(getClass().getResource("../View/application.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(application);
        stage.setScene(scene);
        stage.setTitle("Water Application");
        stage.show();
    }
    /**
     * Set the account type of current user operating the application
     * @param _account accountType of current user
     */
    public static void setAccount(AccountType _account){ account = _account; }
}

