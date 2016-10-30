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

    /**
     * Location constructor
     * @param lat latitude of location
     * @param lg longitude of location
     * @param loc String text of location
     * @param ti title of the location
     * @param desc description of location
     */
    public Location(double lat, double lg, String loc, String ti, String desc) {
        longitude = lg;
        latitude = lat;
        strLoc = loc;
        description = desc;
        title = ti;
    }
    /**
     * Get the longitude of the location
     * @return longitude of location
     */
    public double getLongitude() { return longitude; }
    /**
     * Get the latitude of location
     * @return Latitude of location
     */
    public double getLatitude() {return latitude; }
    /**
     * Get the home address of user
     * @return Home address in profile
     */
    public String getStrLoc() {
        return strLoc;
    }
    /**
     * Get the home address of user
     * @return Home address in profile
     */
    public String getTitle() { return title; }
    /**
     * Get the home address of user
     * @return Home address in profile
     */
    public String getDescription() {return description;}

}
