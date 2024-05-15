package se.kth.iv1350.POS.integration;

/**
 *
 * @author Martin Nylund
 */
public class DatabaseCallException extends Exception {

    /**
     * The database could not be called for some reason. 
     */
    public DatabaseCallException() {
        super("The database could not be called. ");
    }

}
