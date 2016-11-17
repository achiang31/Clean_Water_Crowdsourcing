package Model;

import java.util.Objects;

/**
 * Enum class for Account Type
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
     */
    AccountType(String ptype) {
        accountType = ptype;
        if (Objects.equals(ptype, "User")) {
            abbrType = "US";
        } else if (Objects.equals(ptype, "Worker")) {
            abbrType = "WK";
        } else if (Objects.equals(ptype, "Manager")) {
            abbrType = "MN";
        } else {
            abbrType = "AD";
        }
    }
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
