package sample;
import com.google.gson.Gson;
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
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Alex on 10/1/16.
 */
public class WaterApplication {
    private static ObservableMap<String, User> users = FXCollections.observableHashMap();
    private static ObservableMap<Integer, Report> reports = FXCollections.observableHashMap();
    private static ObservableList<Report> reportList = FXCollections.observableArrayList();
    private  static ObservableMap<Integer, PurityReport> purityreports = FXCollections.observableHashMap();
    private static ObservableList<PurityReport> purityreportList = FXCollections.observableArrayList();

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
     * Get purity report list of the application
     * @return Map of purity reports <reportNum, Report> of application
     */
    public static ObservableMap<Integer, PurityReport> getPurityreports() { return purityreports; }
    /**
     * Get report list of the application
     * @return List of reports <reportNum, Report> of application
     */
    public static ObservableList<Report> getReportsList() {
        return reportList;
    }

    /**
     * Get purity report list of the application
     * @return List of purity reports <reportNum, Report> of application
     */
    public static ObservableList<PurityReport> getPurityreportList() { return purityreportList; }



    public void saveWaterApplication() {
        try {
            try (PrintWriter out = new PrintWriter(new File("WAdata.json"))) {
                Gson gs = new Gson();
                String gson = gs.toJson(this);
                out.print(gson);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WaterApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static WaterApplication loadWaterApplication() {
        try {
            try (BufferedReader br = new BufferedReader(new FileReader("WAdata.json"))) {
                Gson gs = new Gson();
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
