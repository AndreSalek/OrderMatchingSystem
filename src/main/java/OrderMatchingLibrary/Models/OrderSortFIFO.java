package OrderMatchingLibrary.Models;
import java.util.Comparator;

public class OrderSortFIFO implements Comparator<Order> {

    @Override
    public int compare(Order o1, Order o2) {
        boolean isLower = o1.getLimitPrice().compareTo(o2.getLimitPrice()) < 0;
        boolean isHigher = o1.getLimitPrice().compareTo(o2.getLimitPrice()) > 0;
        if (isLower) return -1;
        if (isHigher) return 1;

        boolean createdEarlier = o1.getCreatedAt().isBefore(o2.getCreatedAt());
        boolean createdLater = !o1.getCreatedAt().isAfter(o2.getCreatedAt());
        if(createdEarlier) return -1;
        if(createdLater) return 1;

        return 0;
    }
}
