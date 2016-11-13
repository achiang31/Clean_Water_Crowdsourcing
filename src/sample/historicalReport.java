package sample;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.Map;

import static javafx.application.Application.launch;
/**
 * Created by biggerSean on 11/1/2016.
 */

public class historicalReport extends Application {
    private final String[] names = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    final int months = 12;
    private final int[] month = new int[months];

    private final Integer yea;
    private final Map<Integer, Integer> map;

    @SuppressWarnings("AssignmentToCollectionOrArrayFieldFromParameter")
    public historicalReport (Integer yea, Location loc, String a, Map<Integer, Integer> map) {
        this.yea = yea;
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
        series1.setName(yea.toString());
        for (int i = 0; i < months; i++) {
            series1.getData().add(new XYChart.Data(names[i], month[i]));
        }
        Scene scene = new Scene(bc, 800, 600);
        bc.getData().addAll(series1);
        stage.setScene(scene);
        stage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
