package OrderMatchingLibrary.Models;

public class FIFOAlgorithm implements MatchingAlgorithm{
    private OrderBook orderBook;

    public FIFOAlgorithm(OrderBook orderBook) {
        this.orderBook = orderBook;
    }

    public boolean matchableOrders(){
        return false;
    }

    public void matchOrders(){

    }
}
