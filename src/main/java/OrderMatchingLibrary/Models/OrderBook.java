package OrderMatchingLibrary.Models;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Comparator;

public class OrderBook {
    public String pair;
    private Comparator<Order> comparator;
    private LinkedList<Order> askBook = new LinkedList<Order>();
    private LinkedList<Order> bidBook = new LinkedList<Order>();

    public void addToBook(BigDecimal limitPrice, BigDecimal totalPrice){
        // askBook.add()
        Collections.sort(askBook, comparator);
    }

    public void removeFromBook(Order Order){

    }
}
