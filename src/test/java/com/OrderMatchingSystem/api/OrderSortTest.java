package com.OrderMatchingSystem.api;

import OrderMatchingLibrary.Models.*;
import OrderMatchingLibrary.Models.Order;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderSortTest {

	@Test
	void orderCollectionIsSortedLowestFirst() {
		Comparator<Order> comparator = new OrderSortFIFO();
		Order.OrderBuilder builder = new Order.OrderBuilder();
		BigDecimalProcessor processor = new BigDecimalProcessor(5,3, RoundingMode.UP);
		OrderCalculator calc = new OrderCalculator(processor);
		List<Order> list = new LinkedList<Order>();
		String pair = "USD/BTC";

		BigDecimal expectedResult = new BigDecimal("8400");
		BigDecimal o1Total = BigDecimal.valueOf(15500);
		BigDecimal o2Quantity = BigDecimal.valueOf(0.8);
		BigDecimal o1limitPrice = BigDecimal.valueOf(10600);
		BigDecimal o2limitPrice = BigDecimal.valueOf(10500);

		BigDecimal o1Quantity= calc.calculateQuantityForTotal(o1limitPrice,o1Total);
		BigDecimal o2Total = calc.calculateTotalForQuantity(o2limitPrice, o2Quantity);

		Order o1 =builder.setPair(pair).
				setLimitPrice(o1limitPrice).
				setQuantity(o1Quantity).
				setTotalPrice(o1Total)
				.createOrder();
		Order o2 = builder.setPair(pair)
				.setLimitPrice(o2limitPrice)
				.setQuantity(o2Quantity)
				.setTotalPrice(o2Total)
				.createOrder();
		list.add(o1);
		list.add(o2);
		list.sort(comparator);

		boolean lowestIsFirst = list.getFirst().getTotalPrice().stripTrailingZeros().toPlainString().equals(expectedResult.toString());
		assertTrue(lowestIsFirst);
	}
}
