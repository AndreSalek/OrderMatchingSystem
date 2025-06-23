package OrderMatchingLibrary.Models;

import OrderMatchingLibrary.OrderState;
import OrderMatchingLibrary.OrderType;
import jdk.jfr.Percentage;
import org.springframework.context.annotation.Lazy;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.UUID;

public class Order {
    private final UUID id = UUID.randomUUID();
    private String pair;
    private BigDecimal limitPrice;
    private BigDecimal quantity;
    private BigDecimal totalPrice;
    private OrderType type;
    private OrderState state;
    private float status;
    private final LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime filledAt;
    private BigDecimal marketMakerFeeAmount;

    public UUID getId() {
        return id;
    }
    public BigDecimal getLimitPrice() {
        return limitPrice;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public OrderType getType() {
        return type;
    }

    public OrderState getState() {
        return state;
    }

    public float getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getFilledAt() {
        return filledAt;
    }

    public BigDecimal getMarketMakerFeeAmount() {
        return marketMakerFeeAmount;
    }

    private Order(){}

    public Order(String pair,
                 BigDecimal limitPrice,
                 BigDecimal quantity,
                 BigDecimal totalPrice,
                 OrderType type,
                 OrderState state,
                 float status,
                 BigDecimal marketMakerFeeAmount) {
        this.pair = pair;
        this.limitPrice = limitPrice;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.type = type;
        this.state = state;
        this.status = status;
        this.marketMakerFeeAmount = marketMakerFeeAmount;
    }

    public static class OrderBuilder{
        private String pair;
        private BigDecimal limitPrice;
        private BigDecimal quantity;
        private BigDecimal totalPrice;
        private OrderType type;
        private OrderState state;
        private float status;
        private BigDecimal marketMakerFeeAmount;

        public OrderBuilder setPair(String pair){
            this.pair = pair;
            return this;
        }
        //region limitPrice overloads
        public OrderBuilder setLimitPrice(String limitPrice) {
            this.limitPrice = new BigDecimal(limitPrice);
            return this;
        }

        public OrderBuilder setLimitPrice(BigDecimal limitPrice) {
            this.limitPrice = limitPrice;
            return this;
        }
        public OrderBuilder setLimitPrice(int limitPrice) {
            this.limitPrice = BigDecimal.valueOf(limitPrice);
            return this;
        }
        public OrderBuilder setLimitPrice(long limitPrice) {
            this.limitPrice = BigDecimal.valueOf(limitPrice);
            return this;
        }
        public OrderBuilder setLimitPrice(float limitPrice) {
            this.limitPrice = BigDecimal.valueOf(limitPrice);
            return this;
        }
        public OrderBuilder setLimitPrice(double limitPrice) {
            this.limitPrice = BigDecimal.valueOf(limitPrice);
            return this;
        }
        //endregion
        //region quantity overloads

        public OrderBuilder setQuantity(String quantity) {
            this.quantity = new BigDecimal(quantity);
            return this;
        }
        public OrderBuilder setQuantity(BigDecimal quantity) {
            this.quantity = quantity;
            return this;
        }
        public OrderBuilder setQuantity(int quantity) {
            this.quantity = BigDecimal.valueOf(quantity);
            return this;
        }
        public OrderBuilder setQuantity(long quantity) {
            this.quantity = BigDecimal.valueOf(quantity);
            return this;
        }
        public OrderBuilder setQuantity(float quantity) {
            this.quantity = BigDecimal.valueOf(quantity);
            return this;
        }
        public OrderBuilder setQuantity(double quantity) {
            this.quantity = BigDecimal.valueOf(quantity);
            return this;
        }
        //endregion
        //region totalPrice overloads
        public OrderBuilder setTotalPrice(String totalPrice) {
            this.totalPrice = new BigDecimal(totalPrice);
            return this;
        }

        public OrderBuilder setTotalPrice(BigDecimal totalPrice) {
            this.totalPrice = totalPrice;
            return this;
        }

        public OrderBuilder setTotalPrice(long totalPrice) {
            this.totalPrice = BigDecimal.valueOf(totalPrice);
            return this;
        }

        public OrderBuilder setTotalPrice(double totalPrice) {
            this.totalPrice = BigDecimal.valueOf(totalPrice);
            return this;
        }
        //endregion
        public OrderBuilder setType(OrderType type) {
            this.type = type;
            return this;
        }

        public OrderBuilder setState(OrderState state) {
            this.state = state;
            return this;
        }

        public OrderBuilder setStatus(float status) {
            this.status = status;
            return this;
        }

        public OrderBuilder setMarketMakerFeeAmount(BigDecimal marketMakerFeeAmount) {
            this.marketMakerFeeAmount = marketMakerFeeAmount;
            return this;
        }

        // TODO: Test exception handling here
        private BigDecimal calculateFee() {
            return limitPrice.multiply(BigDecimal.valueOf(MarketMaker.MARKET_MAKER_FEE));
        }

        public Order createOrder(){
            try{
                return new Order(pair, limitPrice, quantity, totalPrice, type, state, status, calculateFee());
            }
            catch(NullPointerException nullEx)
            {
                System.out.println("Order could not be created:" +
                            nullEx.getMessage() +
                            Arrays.toString(nullEx.getStackTrace())
                        );
                return null;
            }
        }
    }
}