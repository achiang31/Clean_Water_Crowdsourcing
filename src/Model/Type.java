package Model;

/**
 * Enum class for Type of Water
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
