package sample;

/**
 * Created by bigjohnlin on 10/17/2016.
 */
public enum Condition {
    CLEAR("CLEAR"), DIRTY("DIRTY"), TREATABLE("TREATABLE");

    /** the full string representation of the account type */
    private final String name;

    /**
     * Constructor for the enumeration
     *
     * @param name   name of condition
     */
    Condition(final String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}