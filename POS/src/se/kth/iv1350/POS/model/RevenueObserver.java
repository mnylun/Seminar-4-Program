package se.kth.iv1350.POS.model;

/**
 *
 * @author Martin Nylund
 */
public interface RevenueObserver {

    /**
     * Invoked when a sale has been concluded. 
     * @param Amount The sale which was concluded resulted in a price. 
     */
    void newSale(Amount salePrice);
}
