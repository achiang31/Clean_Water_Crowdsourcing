package sample;

import java.util.Date;

/**
 * Created by Alex on 10/1/16.
 */
public class Profile {

    private String firstName;

    private String lastName;

    private String emailAddress;

    private String ID;

    private String homeAddress;

    private Date birthday;

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

    public Profile(String firstName, String lastName, String emailAddress, String ID,
                   String homeAddress, Date birthday) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.ID = ID;
        this.homeAddress = homeAddress;
        this.birthday = birthday;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public void setBirthday(String month, String day, String year) {
        birthday = new Date(Integer.parseInt(year) - 1900,
                Integer.parseInt(month) - 1, Integer.parseInt(day));
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getID() {
        return ID;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public Date getBirthday() {
        return birthday;
    }
}
