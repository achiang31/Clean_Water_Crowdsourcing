package sample;

/**
 * Created by bigjohnlin on 10/17/2016.
 */
public enum OverallCondition {
    SAFE("SAFE"), UNSAFE("UNSAFE"), TREATABLE("TREATABLE");
    private final String name;

    private OverallCondition(final String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}