package OrderMatchingLibrary.Models;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.Comparator;

public class OrderBook {
    public String Pair;
    private Comparator<Order> Comparator;
    private LinkedList<Order> AskBook;
    private LinkedList<Order> BidBook;

    public void addToBook(BigDecimal limitPrice, BigDecimal totalPrice){

    }

    public void removeFromBook(Order Order){

    }
}
