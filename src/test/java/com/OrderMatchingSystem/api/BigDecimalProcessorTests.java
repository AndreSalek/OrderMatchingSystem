package com.OrderMatchingSystem.api;

import OrderMatchingLibrary.Models.BigDecimalProcessor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BigDecimalProcessorTests {

    @Test
    public void testProcessorRounding(){
        BigDecimal num = BigDecimal.valueOf(1);
        BigDecimal num1 = BigDecimal.valueOf(3);
        BigDecimal expectedResult = BigDecimal.valueOf(0.3334);
        int scale = 4;
        BigDecimalProcessor processor = new BigDecimalProcessor(4, scale, RoundingMode.UP);

        BigDecimal result = processor.divide(num, num1);

        assertEquals(expectedResult, result);
    }
}
