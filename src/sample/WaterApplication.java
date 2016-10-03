package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;

/**
 * Created by Alex on 10/1/16.
 */
public class WaterApplication {

    private static ObservableMap<String, User> users = FXCollections.observableHashMap();

    public static void addUser(String accountType, String username, String password) {
        User newUser = new User(accountType, username, password);
        users.put(username,newUser);
    }

    public static ObservableMap<String, User> getUsers() {
        return users;
    }
}
