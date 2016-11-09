package sample;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.SingleSelectionModel;
import javafx.stage.Stage;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static javafx.application.Application.launch;
/**
 * Created by biggerSean on 11/1/2016.
 */

public class historicalReport extends Application {
    final static String jan = "January";
    final static String feb = "February";
    final static String mar = "March";
    final static String apr = "April";
    final static String may = "May";
    final static String jun = "June";
    final static String jul = "July";
    final static String aug = "August";
    final static String sep = "September";
    final static String oct = "October";
    final static String nov = "November";
    final static String dec = "December";
    private int[] month = new int[12];

    private Integer yea;
    private Location loc;
    private String a;
    private Map<Integer, Integer> map;

    public historicalReport (Integer yea, Location loc, String a, Map<Integer, Integer> map) {
        this.yea = yea;
        this.loc = loc;
        this.a = a;
        this.map = map;
    }

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
    @Override
    public void start(Stage stage) {
        setData();
        stage.setTitle("Historical Report of Selected Year");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String, Number> bc =
                new BarChart<String, Number>(xAxis, yAxis);
        bc.setTitle("PPM of the Selected Location by Month");
        xAxis.setLabel("Month");
        yAxis.setLabel("PPM");
        XYChart.Series series1 = new XYChart.Series();
        series1.setName(yea.toString());
        series1.getData().add(new XYChart.Data(jan, month[0]));
        series1.getData().add(new XYChart.Data(feb, month[1]));
        series1.getData().add(new XYChart.Data(mar, month[2]));
        series1.getData().add(new XYChart.Data(apr, month[3]));
        series1.getData().add(new XYChart.Data(may, month[4]));
        series1.getData().add(new XYChart.Data(jun, month[5]));
        series1.getData().add(new XYChart.Data(jul, month[6]));
        series1.getData().add(new XYChart.Data(aug, month[7]));
        series1.getData().add(new XYChart.Data(sep, month[8]));
        series1.getData().add(new XYChart.Data(oct, month[9]));
        series1.getData().add(new XYChart.Data(nov, month[10]));
        series1.getData().add(new XYChart.Data(dec, month[11]));
        Scene scene = new Scene(bc, 800, 600);
        bc.getData().addAll(series1);
        stage.setScene(scene);
        stage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
