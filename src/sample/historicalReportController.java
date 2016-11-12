package sample;

import javafx.application.Application;
import javafx.beans.*;
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
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.*;

import static sample.AccountType.MN;

/**
 * Created by biggerSean on 11/1/2016.
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

    private static ObservableMap<Integer, List<PurityReport>> map = FXCollections.observableHashMap();
    private static ObservableMap<Integer, Integer> virusMap = FXCollections.observableHashMap();
    private static ObservableMap<Integer, Integer> contaminationMap = FXCollections.observableHashMap();
    private static AccountType account;

    @SuppressWarnings({"FeatureEnvy", "MagicNumber"})
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
        for (int i = 0; i < validReport.size(); i++) {
            cal.setTime(validReport.get(i).getDateAndTime());
            int yea = cal.get(Calendar.YEAR);
            if (!allYears.contains(yea)) {
                allYears.add(yea);
            }
        }

        Collection<Location> allLocs = new ArrayList<>();
        for (int i = 0; i < validReport.size(); i++) {
            if (!allLocs.contains(validReport.get(i).getLocation())) {
                allLocs.add(validReport.get(i).getLocation());
            }
        }
        //get all the valid locations//
        VorC.getItems().removeAll(VorC.getItems());
        VorC.getItems().addAll("Virus", "Contamination");
        year.getItems().removeAll(year.getItems());
        year.getItems().addAll(allYears);
        loc.getItems().removeAll(loc.getItems());
        loc.getItems().addAll(allLocs);
    }
    /**
     * Set the username to that of current user operating the application
     * @param _username username of current user
     */
    public static void setUsername(String _username) {
        String username = _username;
    }

    /**
     * Handle when "plot" button is pressed --> display historical report of
     * selected year, location, and contamination type
     * @param event Clicking "plot" button
     * @throws IOException when corresponding .fxml file does not exist
     */

    @FXML
    private void showGraph(ActionEvent event) throws IOException {
        if (account == MN) {
            Stage stage = new Stage();
            int selectedYear = year.getSelectionModel().getSelectedItem();
            if(year.getValue() != null && loc.getValue() != null) {
                List<PurityReport> reportList = WaterApplication.getPurityreportList();
                ObservableList<PurityReport> obsReportList = FXCollections.observableList(reportList);
                for (PurityReport purityReport: reportList) {
                    if ((purityReport.getDateAndTime().getYear() + 1900) == selectedYear) {
                        map.get(purityReport.getDateAndTime().getMonth()).add(purityReport);
                        createVirusMap();
                        createContaminationMap();
                    }
                }
                if (VorC.getSelectionModel().getSelectedItem().equals("Virus")) {
                    new historicalReport(year.getSelectionModel().getSelectedItem(), loc.getSelectionModel().getSelectedItem(), VorC.getSelectionModel().getSelectedItem(), virusMap).start(stage);
                } else {
                   new historicalReport(year.getSelectionModel().getSelectedItem(), loc.getSelectionModel().getSelectedItem(), VorC.getSelectionModel().getSelectedItem(), contaminationMap).start(stage);
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
                virusMap.put(month, list.get(0).getVirusPPM());
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
                contaminationMap.put(month, list.get(0).getVirusPPM());
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
     * Set the account type of current user operating the application
     * @param _account accountType of current user
     */
    public static void setAccount(AccountType _account){ account = _account; }
}

