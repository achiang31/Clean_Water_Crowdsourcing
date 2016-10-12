package sample;
/**
 * Created by xingxing on 10/5/16.
 */
public class Report {
    private Profile userProfile;
    private String reporter;
    private int reportNum;
    private String location;
    private String dateAndTime;

    /**
     * Create a new Report object for user
     * @param location location where u examine the water
     */

    public Report(String location) {
        this.location = location;
    }

    /**
     * Get the userProfile of the report
     * @return userProfile in the report
     */
    public Profile getProfile() { return userProfile;}

    /**
     * Set the userProfile for the report
     * @param userProfile userProfile for the report
     */
    public void setUserProfile(Profile userProfile) {
        this.userProfile = userProfile;
    }

    /**
     * Get the dateAndTime of the report
     * @return dateAndTime in the report
     */
    public String getDateAndTime() {
        return dateAndTime;
    }

    /**
     * Set the dateAndTime for the report
     * @param dateAndTime dateAndTime for the report
     */
    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    /**
     * Get the location of the report
     * @return location in the report
     */
    public String getLocation() {
        return location;
    }

    /**
     * Set the location for the report
     * @param location location for the report
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Get the report of the report
     * @return report in the report
     */
    public String getReporter() { return reporter;}

    /**
     * Get the report number of the report
     * @return report number in the report
     */
    public int getReportNum() {
        return reportNum;
    }

    /**
     * Set the report number for the report
     * @param reportNum report number for the report
     */
    public void setReportNum(int reportNum) {
        this.reportNum = reportNum;
    }

    /**
     * over write the toString for report class to
     * return the report number of a report
     * @return report number
     */
    @Override
    public String toString() {
        return "Report " + reportNum;
    }
}
