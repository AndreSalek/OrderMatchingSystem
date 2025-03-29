package OrderMatchingLibrary.Models;

import OrderMatchingLibrary.OrderState;
import OrderMatchingLibrary.OrderType;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Order {
    public UUID id = UUID.randomUUID();
    public String pair;
    public BigDecimal limitPrice;
    public BigDecimal quantity;
    public BigDecimal totalPrice;
    public OrderType type;
    public OrderState state;
    public float status;
    public LocalDateTime createdAt = LocalDateTime.now();
    public LocalDateTime filledAt;
    public BigDecimal marketMakerFeeAmount;

    public Order(String pair,
                 BigDecimal limitPrice,
                 BigDecimal quantity,
                 BigDecimal totalPrice,
                 OrderType type,
                 BigDecimal marketMakerFeeAmount
                 ) {
        this.pair = pair;
        this.limitPrice = limitPrice;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.type = type;
        this.marketMakerFeeAmount = marketMakerFeeAmount;
    }
}