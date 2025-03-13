package OrderMatchingLibrary.Services;

import java.math.BigDecimal;
import java.util.UUID;

public class OrderService {
    private BalanceService balanceService;

    public OrderService(BalanceService balanceService) {
        this.balanceService = balanceService;
    }

    public boolean canCreateOrder(UUID userID, BigDecimal totalPrice, String pair){
        return false;
    }
}
