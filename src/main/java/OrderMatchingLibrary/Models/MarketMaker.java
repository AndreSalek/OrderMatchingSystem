package OrderMatchingLibrary.Models;
import java.math.BigDecimal;
import java.util.UUID;
import java.util.HashMap;

public class MarketMaker {
    public UUID ID = UUID.randomUUID();
    // Percent fee;
    public static final double MARKET_MAKER_FEE = 0.2;
    public HashMap<String, BigDecimal> Balances;
}
