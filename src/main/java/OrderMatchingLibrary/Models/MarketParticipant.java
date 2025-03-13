package OrderMatchingLibrary.Models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;

public class MarketParticipant {
    public int ID;
    public String Username;
    public HashMap<String,BigDecimal> Balances;
    public ArrayList<Order> Orders;
}
