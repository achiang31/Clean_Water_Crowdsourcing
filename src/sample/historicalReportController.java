package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
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

    private static String username;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //get all the valid years//
        ObservableList<Report> validReport = WaterApplication.getReportsList();
        Collection<Integer> allYears = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        for (int i = 0; i < validReport.size(); i++) {
            cal.setTime(validReport.get(i).getDateAndTime());
            int yea = cal.get(Calendar.YEAR);
            allYears.add(yea);
        }



        ArrayList<Location> allLocs = new ArrayList<>();
        for (int i = 0; i < validReport.size(); i++) {
            allLocs.add(validReport.get(i).getLocation());
        }



        //get all the valid locations//



        VorC.getItems().removeAll(VorC.getItems());
        VorC.getItems().addAll("Virus", "Contamination");
        VorC.getSelectionModel().select("Virus");
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
        username = _username;
    }

    /**
     * Handle when "plot" button is pressed --> display historical report of
     * selected year, location, and contamination type
     * @param event Clicking "plot" button
     * @throws IOException when corresponding .fxml file does not exist
     */
    @FXML
    private void showGraph(ActionEvent event) throws IOException {
        if (WaterApplication.getAccountType2(username) == MN) {
            Stage stage = new Stage();
            if(year.getValue() != null && loc.getValue() != null) {
//                ArrayList virus = WaterApplication.getVirusOfTheReport(WaterApplication.getPurityreportList());
//                ArrayList contamination = WaterApplication.getContaminationOfTheReport();
//                new historicalReport(year.getValue(), loc.getValue(), VorC.getValue(), ArrayList virus, ArrayList contamination).start(stage);
            } else {
                plzSelect.setText("Please select year and location");
            }
        }else{
            notMN.setText("Not a manager!");
        }
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
}

