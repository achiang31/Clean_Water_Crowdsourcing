package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;

/**
 * Created by Alex on 10/1/16.
 */
public class WaterApplication {

    private static ObservableMap<String, String> users = FXCollections.observableHashMap();

    public static void addUser(String username, String password) {
        users.put(username, password);
    }

    public static ObservableMap<String, String> getUsers() {
        return users;
    }
}
