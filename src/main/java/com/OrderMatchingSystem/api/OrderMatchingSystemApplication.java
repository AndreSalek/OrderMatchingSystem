package com.OrderMatchingSystem.api;

import OrderMatchingLibrary.Models.FIFOAlgorithm;
import OrderMatchingLibrary.Models.MatchingAlgorithm;
import OrderMatchingLibrary.Models.OrderBook;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class OrderMatchingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrderMatchingSystemApplication.class, args);

		Runnable runnable = () -> {
			OrderBook btcUsd = new OrderBook();
			short matchingStatus = runOrderMatching(btcUsd);
		};
		Thread thread = new Thread(runnable);
		thread.start();

		for(int i = 0; i < 10; i++){
			System.out.println("Main Thread" + i);
		}
	}

	private static short runOrderMatching(OrderBook orderBook){
		try {
			MatchingAlgorithm algorithm = new FIFOAlgorithm(orderBook);
			// Loop here later
			//algorithm.matchOrders();
			for(int i = 0; i < 100; i++){
				System.out.println("Secondary Thread" + i);
			}
		}
		catch(Exception exception){
			System.out.println(exception.getMessage());
			// Finished with error(s)
			return 1;
		}
		return 0;
	}

	@GetMapping("/")
	public String index() {
		return "Index page";
	}

}
