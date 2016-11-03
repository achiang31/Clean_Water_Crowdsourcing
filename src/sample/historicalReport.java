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
    Integer month1 = 0;
    Integer month2 = 0;
    Integer month3 = 0;
    Integer month4 = 0;
    Integer month5 = 0;
    Integer month6 = 0;
    Integer month7 = 0;
    Integer month8 = 0;
    Integer month9 = 0;
    Integer month10 = 0;
    Integer month11 = 0;
    Integer month12 = 0;

    private Integer yea;
    private Location loc;
    private String a;
    private ArrayList vir;
    private ArrayList con;

    public historicalReport (Integer yea, Location loc, String a, ArrayList vir, ArrayList con) {
        this.yea = yea;
        this.loc = loc;
        this.a = a;
        this.vir = vir;
        this.con = con;
    }

    @Override
    public void start(Stage stage) {
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
        series1.getData().add(new XYChart.Data(jan, month1));
        series1.getData().add(new XYChart.Data(feb, month2));
        series1.getData().add(new XYChart.Data(mar, month3));
        series1.getData().add(new XYChart.Data(apr, month4));
        series1.getData().add(new XYChart.Data(may, month5));
        series1.getData().add(new XYChart.Data(jun, month6));
        series1.getData().add(new XYChart.Data(jul, month7));
        series1.getData().add(new XYChart.Data(aug, month8));
        series1.getData().add(new XYChart.Data(sep, month9));
        series1.getData().add(new XYChart.Data(oct, month10));
        series1.getData().add(new XYChart.Data(nov, month11));
        series1.getData().add(new XYChart.Data(dec, month12));
        Scene scene = new Scene(bc, 800, 600);
        bc.getData().addAll(series1);
        stage.setScene(scene);
        stage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
