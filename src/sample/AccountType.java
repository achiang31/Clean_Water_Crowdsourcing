package sample;

/**
 * Created by Alex on 10/1/16.
 */
public enum AccountType {

    US ("User", "US"),
    WK ("Worker", "WK"),
    MN ("Manager", "MN"),
    AD ("Administrator", "AD");

    /** the full string representation of the account type */
    private final String accountType;

    /** the representation of the account type abbreviation - always 2 characters*/
    private final String abbrType;

    /**
     * Constructor for the enumeration
     *
     * @param ptype   full name of the account type
     * @param pabbr    abbreviation for the account type
     */
    AccountType(String ptype, String pabbr) {
        accountType = ptype;
        abbrType = pabbr;
    }

    /**
     *
     * @return   the full account type
     */
    public String getAccountType() { return accountType; }


    /**
     *
     * @return the abbreviation for the account type
     */
    public String getAbbrType() { return abbrType; }

    /**
     *
     * @return the display string representation of the account type
     */
    public String toString() { return abbrType; }
}
