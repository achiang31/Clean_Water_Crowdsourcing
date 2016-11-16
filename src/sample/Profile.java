package sample;

import java.util.Date;

/**
 * Profile Class
 */
public class Profile {

    private String firstName;

    private String lastName;

    private String emailAddress;

    private String ID;

    private String homeAddress;

    private Date birthday;

    /**
     * Create a new Profile object for user
     * @param firstName     First name of user
     * @param lastName      Last name of user
     * @param emailAddress  Email address of user
     * @param ID            ID of user
     * @param homeAddress   Home address of user
     * @param month         Birth month of user
     * @param day           Birth date of user
     * @param year          Birth year of user
     */
    public Profile(String firstName, String lastName, String emailAddress, String ID,
                   String homeAddress, String month, String day, String year) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.ID = ID;
        this.homeAddress = homeAddress;
        birthday = new Date(Integer.parseInt(year) - 1900,
                Integer.parseInt(month) - 1, Integer.parseInt(day));
    }

    /**
     * Create a new Profile object for user
     * @param firstName     First name of user
     * @param lastName      Last name of user
     * @param emailAddress  Email address of user
     * @param ID            ID of user
     * @param homeAddress   Home address of user
     * @param birthday      Birthday of user
     */
    public Profile(String firstName, String lastName, String emailAddress, String ID,
                   String homeAddress, Date birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.ID = ID;
        this.homeAddress = homeAddress;
        this.birthday = birthday;
    }

    /**
     * Set the first name in profile
     * @param firstName First name of user
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Set the last name in profile
     * @param lastName Last name of user
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Set the email address in profile
     * @param emailAddress Email address of user
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Set the ID in profile
     * @param ID ID of user
     */
    public void setID(String ID) {
        this.ID = ID;
    }

    /**
     * Set the home address in profile
     * @param homeAddress Home address of user
     */
    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    /**
     * Set the birthday in profile
     * @param month Birth month of user
     * @param day   Birth date of user
     * @param year  Birth year of user
     */
    public void setBirthday(String month, String day, String year) {
        birthday = new Date(Integer.parseInt(year) - 1900,
                Integer.parseInt(month) - 1, Integer.parseInt(day));
    }

    /**
     * Get the first name of user
     * @return First name in profile
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Get the last name of user
     * @return Last name in profile
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Get the email address of user
     * @return Email address in profile
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Get the ID of user
     * @return ID in profile
     */
    public String getID() {
        return ID;
    }

    /**
     * Get the home address of user
     * @return Home address in profile
     */
    public String getHomeAddress() {
        return homeAddress;
    }

    /**
     * Get the birthday of user
     * @return Birthday in profile
     */
    public Date getBirthday() {
        return birthday;
    }
}
