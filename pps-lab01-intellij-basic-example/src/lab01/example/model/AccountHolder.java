package lab01.example.model;

/**
 * This class represents the account holder concept.
 * That is: a person that can subscribe a bank account.
 *
 * Each account holder has a name, a surname and an ID (unique in the bank system)
 */
public class AccountHolder {
    private final int id;
    private final String name;
    private final String surname;

    public AccountHolder(final String name, final String surname, final int id) {
        this.name = name;
        this.surname = surname;
        this.id = id;
    }

    /**
     * Retrieve the name of the person registered as possible account holder
     * @return the name of the holder
     */
    public String getName() {
        return this.name;
    }

    /**
     * Retrieve the surname of the person registered as possible account holder
     * @return the surname of the holder
     */
    public String getSurname() {
        return this.surname;
    }

    /**
     * Retrieve the ID of the person registered as possible account holder
     * @return the id of the holder
     */
    public int getId() {
        return this.id;
    }

    /**
     * Provides a string representation
     * @return the string representation for an AccountHolder instance
     */
    public String toString() {
        return String.format("[ID = %d] %s %s", this.id, this.name, this.surname);
    }
}
