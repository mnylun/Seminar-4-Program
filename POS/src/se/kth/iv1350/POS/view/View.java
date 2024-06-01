package se.kth.iv1350.POS.view;

import se.kth.iv1350.POS.controller.*;
import se.kth.iv1350.POS.integration.*;
import se.kth.iv1350.POS.model.*;

/**
 *
 * @author Martin Nylund
 *
 * Placeholder for the real View class, this is not how it should be.
 */
public class View {

    private Controller controller;
    private FileLogger exceptionsLog;
    private TotalRevenueView totalRevenueView;
    private TotalRevenueFileOutput totalRevenueFileOutput;

    /**
     * Creates a new instance, uses controller for calls to all other layers.
     * Also creates the log for exceptions and creates the revenue views.
     *
     * @param controller
     */
    public View(Controller controller) {
        this.controller = controller;
        exceptionsLog = new FileLogger("ExceptionsLog.txt");
        totalRevenueView = new TotalRevenueView();
        controller.addRevenueObserver(totalRevenueView);
        totalRevenueFileOutput = new TotalRevenueFileOutput();
        controller.addRevenueObserver(totalRevenueFileOutput);
    }

    /**
     * This is a test, going through all of the system operations in the basic
     * and alternate flow of the retail store.
     */
    public void testRun() throws NoSuchIdentifierException, DatabaseCallException {
        controller.startSale();
        addItem("Apple");
        addItem("Pear");
        addItem("Banana");
        addItem("Orange");
        addItem("Citron");

        Customer customer = new Customer("Bob");
        Discount discount = controller.checkForDiscount(customer);
        Amount payment = new Amount(500, "kr");

        Receipt receipt = controller.pay(payment, discount);
        if (receipt != null) {
            System.out.println(receipt.toString());
        }
    }

    /**
     * Method to add an item with the identifier.
     *
     * @param identifier The item which will be added.
     */
    public void addItem(String identifier) {
        try {
            ItemDescriptionDTO item = controller.searchItem(identifier);
            controller.registerItem(item, 11);
        } catch (Exception e) {
            e.getCause();
            String message = "";
            if (e instanceof NoSuchIdentifierException) {
                NoSuchIdentifierException nsie = (NoSuchIdentifierException) e;
                message = "There is no item with this identifier: " + nsie.getIdentifierWhichDoesNotExist() + ". ";
            } else if (e instanceof DatabaseCallException) {
                message = "For some reason the database could not be reached. ";
            }
            System.out.println(message);
            exceptionsLog.log("There was an exception which prevented the program from fully functioning. Error: " + message);
        }
    }
}
