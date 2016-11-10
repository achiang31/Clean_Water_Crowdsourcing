package sample;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Alex on 10/1/16.
 */
public class WaterApplication {
    private static WaterApplication instance = new WaterApplication();
    private static Map<String, User> users = new HashMap<>();
    private static Map<Integer, Report> reports = new HashMap<>();
    private static List<Report> reportList = new ArrayList<>();
    private static Map<Integer, PurityReport> purityreports = new HashMap<>();
    private static List<PurityReport> purityreportList = new ArrayList<>();

    /**
     * Add a new user to user list
     * @param accountType Account type of new user
     * @param username    Username of new user
     * @param password    Password of new user
     */
    public static void addUser(AccountType accountType, String username, String password) {
        User newUser = new User(accountType, username, password);
        users.put(username,newUser);
    }

    /**
     * Add a new user to report list
     * @param location location of the report
     */
    public static Report addReport(Location location) {
        Report newReport = new Report(location);
        reports.put(reportController.reportNum,newReport);
        reportList.add(newReport);
        return newReport;
    }

    public static PurityReport addPurityReport(Location location) {
        PurityReport purityReport = new PurityReport(location);
        purityreports.put(purityController.reportNum,purityReport);
        purityreportList.add(purityReport);
        return purityReport;
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
    public static Map<String, User> getUsers() {
        return users;
    }

    /**
     * Get report list of the application
     * @return Map of reports <reportNum, Report> of application
     */
    public static Map<Integer, Report> getReports() {
        return reports;
    }

    /**
     * Get purity report list of the application
     * @return Map of purity reports <reportNum, Report> of application
     */
    public static Map<Integer, PurityReport> getPurityreports() { return purityreports; }
    /**
     * Get report list of the application
     * @return List of reports <reportNum, Report> of application
     */
    public static List<Report> getReportsList() {
        return reportList;
    }

    /**
     * Get purity report list of the application
     * @return List of purity reports <reportNum, Report> of application
     */
    public static List<PurityReport> getPurityreportList() { return purityreportList; }

    public static WaterApplication getInstance() { return instance; }

    public void saveWaterApplication() {
        try {
            try (PrintWriter out = new PrintWriter(new File("WAdata.json"))) {
                Gson gs = new GsonBuilder().excludeFieldsWithModifiers(Modifier.TRANSIENT).create();
                String gson = gs.toJson(this);
                System.out.println(gson);
                //noinspection SuspiciousMethodCalls
                System.out.println(users.get(0));
                out.print(gson);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WaterApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static WaterApplication loadWaterApplication() {
        try {
            try (BufferedReader br = new BufferedReader(new FileReader("WAdata.json"))) {
                Gson gs = new GsonBuilder().excludeFieldsWithModifiers(Modifier.TRANSIENT).create();
                File loading = new File("WAdata.json");
                FileInputStream fis = new FileInputStream(loading);
                byte[] data = new byte[(int) loading.length()];
                //noinspection ResultOfMethodCallIgnored
                fis.read(data);
                fis.close();
                String str = new String(data, "UTF-8");
                return gs.fromJson(str, WaterApplication.class);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WaterApplication.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WaterApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
