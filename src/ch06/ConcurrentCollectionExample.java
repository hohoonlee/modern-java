package ch06;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ConcurrentCollectionExample {
	private BlockingQueue<Integer> queue = new LinkedBlockingQueue<>(5);

	Runnable producer = () -> {
		Random random = new Random();
		try {
			TimeUnit.SECONDS.sleep(1);

			int num = random.nextInt(100);
			queue.put(num);
			System.out.println("> " + num + " queue size : " + queue.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	};

	Runnable consumer = () -> {
		try {
			TimeUnit.SECONDS.sleep(1);

			System.out.println("consume : " + queue.take() + " queue size : " + queue.size());
		} catch (Exception e) {
			e.printStackTrace();
		}
	};

	public void execute(int producerSize, int consumerSize) {
		for(int i = 0; i < producerSize; i++) {
			new Thread(producer, "Producer " + i).start();
		}

		for(int i = 0; i < consumerSize; i++) {
			new Thread(consumer, "Consumer" + i).start();
		}
	}

	public static void main(String[] args) {
		ConcurrentCollectionExample ex = new ConcurrentCollectionExample();
		ex.execute(7, 9);
	}

}
