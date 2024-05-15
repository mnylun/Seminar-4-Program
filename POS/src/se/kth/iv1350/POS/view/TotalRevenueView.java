package se.kth.iv1350.POS.view;

import se.kth.iv1350.POS.model.Amount;
import se.kth.iv1350.POS.model.RevenueObserver;

/**
 *
 * @author Martin Nylund
 */
public class TotalRevenueView implements RevenueObserver {

    private Amount totalRevenue;

    /**
     * When the view is created, the total revenue earned from sales should be
     * 0. In this program, every currency has been set to "kr".
     */
    public TotalRevenueView() {
        totalRevenue = new Amount(0, "kr");
    }

    @Override
    public void newSale(Amount salePrice) {
        totalRevenue = new Amount(totalRevenue.getAmount() + salePrice.getAmount(), "kr");
        printCurrentState();
    }

    private void printCurrentState() {
        System.out.println("-------------------------------------\n"
                + "Total revenue from all sales: " + totalRevenue.getAmount() + " kr. "
                + "\n-------------------------------------\n");
    }

}
