package OrderMatchingLibrary.Models;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class BigDecimalProcessor {

    private MathContext mc;
    RoundingMode roundingMode;
    private int scale;

    public BigDecimalProcessor(int precision, int scale, RoundingMode roundingMode) {
        this.scale = scale;
        this.roundingMode = roundingMode;
        mc = new MathContext(precision, roundingMode);
    }

    public int getScale() {
        return scale;
    }
    
    public BigDecimal divide(BigDecimal base, BigDecimal divisor) {
        return base.divide(divisor, mc).setScale(scale, roundingMode);
    }
    
    public BigDecimal multiply(BigDecimal base, BigDecimal multiplicand) {
        return base.multiply(multiplicand, mc).setScale(scale,roundingMode);
    }
    
    public BigDecimal add(BigDecimal base, BigDecimal augend) {
        return base.add(augend, mc).setScale(scale,roundingMode);
    }
    
    public BigDecimal subtract(BigDecimal base, BigDecimal subtrahend) {
        return base.subtract(subtrahend, mc).setScale(scale,roundingMode);
    }
}
