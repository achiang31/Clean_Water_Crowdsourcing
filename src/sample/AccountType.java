package sample;

/**
 * Created by Alex on 10/1/16.
 */
public enum AccountType {

    US ("User", "US"),
    WK ("Worker", "WK"),
    MN ("Manager", "MN"),
    AD ("Administrator", "AD");

    /** the full string representation of the class standing */
    private final String accountType;

    /** the representation of the class standing abbreviation - always 2 characters*/
    private final String abbrType;

    /**
     * Constructor for the enumeration
     *
     * @param ptype   full name of the class standing
     * @param pabbr    abbreviation for the class standing
     */
    AccountType(String ptype, String pabbr) {
        accountType = ptype;
        abbrType = pabbr;
    }

    /**
     *
     * @return   the full class standing
     */
    public String getAccountType() { return accountType; }


    /**
     *
     * @return the abbreviation for the class standing
     */
    public String getAbbrType() { return abbrType; }

    /**
     *
     * @return the display string representation of the class standing
     */
    public String toString() { return abbrType; }
}
