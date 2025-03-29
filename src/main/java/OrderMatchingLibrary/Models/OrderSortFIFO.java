package OrderMatchingLibrary.Models;
import java.util.Comparator;

public class OrderSortFIFO implements Comparator<Order> {

    @Override
    public int compare(Order o1, Order o2) {
        boolean isLower = o1.limitPrice.compareTo(o2.limitPrice) < 0;
        boolean isHigher = o1.limitPrice.compareTo(o2.limitPrice) >= 0;
        if (isLower) return -1;
        if (isHigher) return 1;

        boolean createdEarlier = o1.createdAt.compareTo(o1.createdAt) < 0;
        boolean createdLater = o1.createdAt.compareTo(o1.createdAt) >= 0;
        if(createdEarlier) return -1;
        if(createdLater) return 1;

        return 0;
    }
}
