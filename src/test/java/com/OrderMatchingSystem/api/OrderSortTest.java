package com.OrderMatchingSystem.api;

import OrderMatchingLibrary.Models.MarketMaker;
import OrderMatchingLibrary.Models.OrderSortFIFO;
import OrderMatchingLibrary.Models.Order;
import OrderMatchingLibrary.OrderType;
import org.junit.jupiter.api.*;
import org.springframework.aop.aspectj.annotation.PrototypeAspectInstanceFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderSortTest {

	@Test
	void orderCollectionIsSortedLowestFirst() {
		Comparator<Order> comparator = new OrderSortFIFO();
		List<Order> list = new LinkedList<Order>();
		String pair = "USD/BTC";

		BigDecimal limitPrice = new BigDecimal("10123.1");

		BigDecimal fee = limitPrice.multiply(BigDecimal.valueOf(MarketMaker.MARKET_MAKER_FEE));

		Order o1 = new Order(pair,
							new BigDecimal("10123.1"),
							new BigDecimal("1.1"),
							new BigDecimal(String.valueOf(limitPrice)).multiply(BigDecimal.valueOf(1.1)),
							OrderType.Ask,
							fee
							);
		BigDecimal fee1 = limitPrice.multiply(BigDecimal.valueOf(MarketMaker.MARKET_MAKER_FEE));
		Order o2 = new Order(pair,
				new BigDecimal("9020"),
				new BigDecimal("1.2"),
				new BigDecimal(String.valueOf(limitPrice)).multiply(BigDecimal.valueOf(1.1)),
				OrderType.Ask,
				fee1
		);
		list.add(o1);
		list.add(o2);
		list.sort(comparator);

		boolean lowestIsFirst = list.getFirst().limitPrice.equals(new BigDecimal("9020"));

		assertTrue(lowestIsFirst);
	}

}
