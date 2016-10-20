package sample;

/**
 * Created by Alex on 10/19/16.
 */
public class Location {

    private final double longitude;
    private final double latitude;
    private final String strLoc;
    private final String title;
    private final String description;

    public Location(double lat, double lg, String loc, String ti, String desc) {
        longitude = lg;
        latitude = lat;
        strLoc = loc;
        description = desc;
        title = ti;
    }

    public double getLongitude() { return longitude; }
    public double getLatitude() {return latitude; }
    public String getStrLoc() {
        return strLoc;
    }
    public String getTitle() { return title; }
    public String getDescription() {return description;}

}
