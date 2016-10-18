package sample;

/**
 * Created by bigjohnlin on 10/17/2016.
 */
public enum Condition {
    CLEAR("CLEAR"), DIRTY("DIRTY"), TREATABLE("TREATABLE");
    private final String name;

    private Condition(final String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}