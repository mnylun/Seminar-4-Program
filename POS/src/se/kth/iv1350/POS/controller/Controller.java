package se.kth.iv1350.POS.controller;

import java.util.ArrayList;
import se.kth.iv1350.POS.integration.*;
import se.kth.iv1350.POS.model.*;
import se.kth.iv1350.POS.view.TotalRevenueView;

/**
 *
 * @author Martin Nylund
 */
public class Controller {

    private Sale sale;
    private ArrayList<RevenueObserver> revenueObservers = new ArrayList<>();

    /**
     * Starts a new sale. Must be called before that happens, also creates a
     * customer.
     */
    public void startSale() {
        sale = new Sale();
        sale.addRevenueObservers(revenueObservers);
    }

    /**
     * Searches for the item in the inventory by communication with the
     * inventorys system, then creates a cartItem.
     *
     * @param identifier
     * @return
     * @throws NoSuchIdentifierException if the specified identifier does not
     * exist in the system.
     */
    public ItemDescriptionDTO searchItem(String identifier) throws NoSuchIdentifierException, DatabaseCallException {
        ItemDescriptionDTO item = InventorySystem.checkIfItemExists(identifier);

        return item;
    }

    /**
     * Registers however many of the item searched for in the instance of the
     * sale, if it exists in the inventory.
     */
    public void registerItem(ItemDescriptionDTO item, int quantity) {
        sale.addItem(item, quantity);
    }

    /**
     * Searches in the discount database for any elegible discount the current
     * customer has.
     */
    public Discount checkForDiscount(Customer customer) {
        return DiscountSystem.searchForElegibleDiscount(customer);
    }

    /**
     * When the customer wants to complete the transaction, they must pay an
     * amount, and if they have a discount, it can be applied.
     *
     * @param amount
     * @param discount
     */
    public Receipt pay(Amount amount, Discount discount) {
        return sale.pay(amount, discount);
    }

    public void addRevenueObserver(RevenueObserver revenueObserver) {
        revenueObservers.add(revenueObserver);
    }

}
