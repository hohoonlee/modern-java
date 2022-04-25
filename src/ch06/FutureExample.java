package ch06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class FutureExample {
	public Callable<Long> callSquare(long value) {
		Callable<Long> callable = new Callable<Long>() {

			@Override
			public Long call() throws Exception {
				Long returnValue = value * value;
				TimeUnit.SECONDS.sleep(1 * ((value == 1)?10:1));
				System.out.println(value + "의 제곱근은 " + returnValue);
				return returnValue;
			}

		};

		return callable;
	}

	public void executeTest() {
		List<Long> sampleData = Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L);
		List<Future<Long>> futureList = new ArrayList<>();

		ExecutorService servicePool = Executors.newFixedThreadPool(4);
		for(Long sample : sampleData) {
			Future<Long> future = servicePool.submit(callSquare(sample));
			futureList.add(future);
		}

		Long sumValue = 0L;
		for(Future<Long> future : futureList) {
			try {
				Long value = future.get();
				System.out.println(">>" + value);
				sumValue += value;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		System.out.println("최종 합:" + sumValue);
		servicePool.shutdown();
	}

	public static void main(String[] args) {
		FutureExample futureExample = new FutureExample();
		futureExample.executeTest();
	}

}
