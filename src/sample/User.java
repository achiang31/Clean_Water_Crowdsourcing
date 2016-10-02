package sample;

/**
 * Created by Alex on 10/1/16.
 */
public class User {

    private String accountType;

    private String username;

    private String password;

    private Profile profile;

    public User(String accountType, String username, String password) {
        this.accountType = accountType;
        this.username = username;
        this.password = password;
    }
}
