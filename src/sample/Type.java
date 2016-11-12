package sample;

/**
 * Created by bigjohnlin on 10/17/2016.
 */
/**
 * Created by bigjohnlin on 9/12/2016.
 */
public enum Type {
    POTABLE("POTABLE"), BOTTLED("BOTTLED");

    private final String name;

    Type(final String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
