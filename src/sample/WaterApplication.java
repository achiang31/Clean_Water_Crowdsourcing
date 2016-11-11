package sample;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
    private static Map<String, User> users = new HashMap<String, User>();
    private static Map<Integer, Report> reports = new HashMap<Integer, Report>();
    private static List<Report> reportList = new ArrayList<Report>();
    private static Map<Integer, PurityReport> purityreports = new HashMap<Integer, PurityReport>();
    private static List<PurityReport> purityreportList = new ArrayList<PurityReport>();

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
     * Add a new report to report list
     * @param report  report to be added
     */
    public static void addReport(Report report) {
        reports.put(report.getReportNum(), report);
        reportList.add(report);
    }

    /**
     * Add a new purity report to purity report list
     * @param report  report to be added
     */
    public static void addPurityReport(PurityReport report) {
        purityreports.put(report.getReportNum(),report);
        purityreportList.add(report);
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
                fis.read(data);
                fis.close();
                String str = new String(data, "UTF-8");
                WaterApplication instance = gs.fromJson(str, WaterApplication.class);
                return instance;
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WaterApplication.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WaterApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
