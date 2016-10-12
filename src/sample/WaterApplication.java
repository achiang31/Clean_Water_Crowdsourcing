package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;

/**
 * Created by Alex on 10/1/16.
 */
public class WaterApplication {
    private static ObservableMap<String, User> users = FXCollections.observableHashMap();
    private static ObservableMap<Integer, Report> reports = FXCollections.observableHashMap();
    private static ObservableList<Report> reportList = FXCollections.observableArrayList();

    /**
     * Add a new user to user list
     * @param accountType Account type of new user
     * @param username    Username of new user
     * @param password    Password of new user
     */
    public static void addUser(String accountType, String username, String password) {
        User newUser = new User(accountType, username, password);
        users.put(username,newUser);
    }

    /**
     * Add a new user to report list
     * @param location location of the report
     */
    public static Report addReport(String location) {
        Report newReport = new Report(location);
        reports.put(reportController.reportNum,newReport);
        reportList.add(newReport);
        return newReport;
    }

    /**
     * Set new profile for specific user
     * @param username User to set new profile for
     * @param profile  New profile for the user
     */
    public static void setProfile(String username, Profile profile) {
        if (users.get(username) != null){
            users.get(username).setProfile(profile);
        }
    }

    /**
     * Get user list of the application
     * @return Map of users <username, User> of application
     */
    public static ObservableMap<String, User> getUsers() {
        return users;
    }

    /**
     * Get report list of the application
     * @return Map of reports <reportNum, Report> of application
     */
    public static ObservableMap<Integer, Report> getReports() {
        return reports;
    }

    /**
     * Get report list of the application
     * @return List of reports <reportNum, Report> of application
     */
    public static ObservableList<Report> getReportsList() {
        return reportList;
    }
}
