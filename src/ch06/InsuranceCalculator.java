package ch06;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class InsuranceCalculator {
	public int calculatePrice(Map condition) {
		int price = 10000;
		try {
			TimeUnit.SECONDS.sleep(10);
		} catch (Exception e) {
		}
		return price;
	}

	public Future<Integer> calculatePriceAsync(Map condition) {
		CompletableFuture<Integer> future = new CompletableFuture<>();
		new Thread(()->{
			int price = calculatePrice(condition);
			future.complete(price);
		}).start();
		return future;
	}

	public static void main(String[] args) {
		InsuranceCalculator cal = new InsuranceCalculator();
		List<Future<Integer>> list = new ArrayList<>();
		for(int i = 0; i < 5; i++) {
		//	System.out.printf("계산 차수 %s : %s\n", (i+1), cal.calculatePrice(null));
			list.add(cal.calculatePriceAsync(null));
		}

		for(Future<Integer> f : list) {
			try {
				System.out.println(f.get());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
