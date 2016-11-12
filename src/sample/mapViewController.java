package sample;

import com.lynden.gmapsfx.GoogleMapView;
import com.lynden.gmapsfx.MapComponentInitializedListener;
import com.lynden.gmapsfx.javascript.event.UIEventType;
import com.lynden.gmapsfx.javascript.object.*;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import netscape.javascript.JSObject;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Created by Alex on 10/18/16.
 */
public class mapViewController implements Initializable, MapComponentInitializedListener {
    @FXML
    private GoogleMapView mapView;

    private GoogleMap map;

    private Window mainStage;


    /**
     * initialize the mapView with listener
     * @param url URL
     * @param rb Resource Bundle
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mapView.addMapInializedListener(this);
    }


    /**
     * initialize the set up of the map with reports
     */
    @SuppressWarnings({"FeatureEnvy", "MagicNumber"})
    @Override
    public void mapInitialized() {
        MapOptions options = new MapOptions();

        //set up the center location for the map
        int defaultLat = 34;
        int defaultLong = -88;
        LatLong center = new LatLong(defaultLat, defaultLong);
        if (!WaterApplication.getReportsList().isEmpty()) {
            Location firstLoc = WaterApplication.getReportsList().get(0).getLocation();
            center = new LatLong(firstLoc.getLatitude(), firstLoc.getLongitude());
        }
        options.center(center)
                .zoom(9)
                .overviewMapControl(false)
                .panControl(false)
                .rotateControl(false)
                .scaleControl(false)
                .streetViewControl(false)
                .zoomControl(false)
                .mapType(MapTypeIdEnum.TERRAIN);

        map = mapView.createMap(options);


        // now we communicate with the model to get all the locations for markers
        List<Report> reports = WaterApplication.getReportsList();

        for (int i = 0; i < reports.size(); i++) {
            Location l = reports.get(i).getLocation();
            MarkerOptions markerOptions = new MarkerOptions();
            LatLong loc = new LatLong(l.getLatitude(), l.getLongitude());

            markerOptions.position(loc)
                    .visible(Boolean.TRUE)
                    .title(l.getTitle());

            Marker marker = new Marker(markerOptions);

            map.addUIEventHandler(marker,
                    UIEventType.click,
                    (JSObject obj) -> {
                        InfoWindowOptions infoWindowOptions = new InfoWindowOptions();
                        infoWindowOptions.content(l.getTitle() + "\n");
                        infoWindowOptions.content(l.getDescription() + "\n");

                        InfoWindow window = new InfoWindow(infoWindowOptions);
                        window.open(map, marker);
                    });

            map.addMarker(marker);
        }
    }
}
