package se.kth.iv1350.POS.controller;

/**
 *
 * @author Martin Nylund
 */
public class NoSuchIdentifierException extends Exception {

    private String identifierWhichDoesNotExist;
    
    /**
     * Creates a new instance with a message specifying that there is no item with this identifier. 
     * @param identifier The item which does not exist. 
     */
    public NoSuchIdentifierException(String identifier) {
        super("There is no item with this identifier: " + identifier + ". ");

        this.identifierWhichDoesNotExist = identifier;
    }

    /**
     * 
     * @return The identifier which does not eixst. 
     */
    public String getIdentifierWhichDoesNotExist() {
        return identifierWhichDoesNotExist;
    }
}
