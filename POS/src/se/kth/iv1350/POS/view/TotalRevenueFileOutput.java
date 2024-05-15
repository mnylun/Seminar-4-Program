package se.kth.iv1350.POS.view;

import se.kth.iv1350.POS.model.Amount;
import se.kth.iv1350.POS.model.FileLogger;
import se.kth.iv1350.POS.model.RevenueObserver;

/**
 *
 * @author Martin Nylund
 */
public class TotalRevenueFileOutput implements RevenueObserver {

    private FileLogger fileLogger;
    private Amount totalRevenue;

    public TotalRevenueFileOutput() {
        fileLogger = new FileLogger("totalRevenue.txt");
        totalRevenue = new Amount(0, "kr");
    }

    @Override
    public void newSale(Amount salePrice) {
        totalRevenue = new Amount(totalRevenue.getAmount() + salePrice.getAmount(), "kr");
        printCurrentState();
    }
    
    private void printCurrentState() {
        fileLogger.log("Current revenue from sales: " + totalRevenue.getAmount() + " kr. ");
    }

}
