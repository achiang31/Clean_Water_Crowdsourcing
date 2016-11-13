package sample;

/**
 * Created by Alex on 10/1/16.
 */
public class User {

    private final AccountType accountType;

    private final String username;

    private String password;

    private Profile profile;

    /**
     * Create an User object
     * @param accountType Account type of user
     * @param username    User's username
     * @param password    User's password
     */
    public User(AccountType accountType, String username, String password) {
        this.accountType = accountType;
        this.username = username;
        this.password = password;
    }

    /**
     * Get the account type of user
     * @return User's account type
     */
    public AccountType getAccountType() {
        return accountType;
    }

    /**
     * Get the username
     * @return User's username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Get the password
     * @return User's password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Get the profile of user
     * @return User's profile
     */
    public Profile getProfile() {
        return profile;
    }

    /**
     * Set the password of user
     * @param password New password for the user
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Set the profile of user
     * @param profile New profile for the user
     */
    public void setProfile(Profile profile) {
        this.profile = profile;
    }

}
