package sample;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.Map;

import static javafx.application.Application.launch;

/**
 * Historical report class
 */
public class historicalReport extends Application {
    private final String[] names = {"January", "February", "March", "April", "May", "June", "July",
                "August", "September", "October", "November", "December"};
    private final  int months = 12;
    private final int[] month = new int[months];

    private final Integer year;
    private final Map<Integer, Integer> map;

    /**
     * Set the account type of current user operating the application
     * @param year year of report
     * @param loc location of report
     * @param a String representation of report
     * @param map of results in report
     */
    @SuppressWarnings("AssignmentToCollectionOrArrayFieldFromParameter")
    public historicalReport (Integer year, Location loc, String a, Map<Integer, Integer> map) {
        this.year = year;
        this.map = map;
    }

    /**
     * setData for the historical report
     */
    public void setData() {
        for (int a = 0; a < month.length; a++) {
            month[a] = 0;
        }
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int m = entry.getKey();
            int value = entry.getValue();
            month[m] = value;
        }
    }

    @SuppressWarnings({"MagicNumber", "unchecked"})
    @Override
    public void start(Stage stage) {
        setData();
        stage.setTitle("Historical Report of Selected Year");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String, Number> bc =
                new BarChart<>(xAxis, yAxis);
        bc.setTitle("PPM of the Selected Location by Month");
        xAxis.setLabel("Month");
        yAxis.setLabel("PPM");
        XYChart.Series series1 = new XYChart.Series<String, Integer>();
        series1.setName(year.toString());
        for (int i = 0; i < months; i++) {
            ObservableList data = series1.getData();
            data.add(new XYChart.Data(names[i], month[i]));
        }
        Scene scene = new Scene(bc, 800, 600);
        ObservableList data = bc.getData();
        data.addAll(series1);
        stage.setScene(scene);
        stage.show();
    }


    /**
     * main function to run and launch the historical report
     * @param args argument
     */
    public static void main(String[] args) {
        launch(args);
    }
}
