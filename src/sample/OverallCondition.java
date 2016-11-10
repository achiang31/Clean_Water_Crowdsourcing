package sample;

/**
 * Created by bigjohnlin on 10/17/2016.
 */
public enum OverallCondition {
    SAFE("SAFE"), UNSAFE("UNSAFE"), TREATABLE("TREATABLE");

    /** the full string representation of the account type */
    private final String name;

    /**
     * Constructor for the enumeration
     *
     * @param name   name of Overall condition
     */
    OverallCondition(final String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return name;
    }
}