package OrderMatchingLibrary.Models;

import java.math.BigDecimal;

// TODO: Perhaps rename this class
public class OrderCalculator {
    private final BigDecimalProcessor orderCalculator;
    public OrderCalculator(BigDecimalProcessor orderCalculator){
        this.orderCalculator = orderCalculator;
    }
    public BigDecimal calculateQuantityForTotal(BigDecimal limitPrice, BigDecimal total){
        return orderCalculator.divide(total, limitPrice);
    }

    public BigDecimal calculateTotalForQuantity(BigDecimal limitPrice, BigDecimal quantity){
        return orderCalculator.multiply(limitPrice, quantity);
    }
}
