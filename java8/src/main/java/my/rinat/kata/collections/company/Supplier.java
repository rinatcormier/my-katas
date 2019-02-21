package my.rinat.kata.collections.company;

/**
 * Suppliers have a name and an array of itemNames.
 */
public class Supplier {

    private final String name;
    // Refactor to an ImmutableList<String>
    private final String[] itemNames;

    public Supplier(String name, String[] itemNames) {
        this.name = name;
        this.itemNames = itemNames;
    }

    public String getName() {
        return this.name;
    }

    public String[] getItemNames() {
        return this.itemNames;
    }
}
