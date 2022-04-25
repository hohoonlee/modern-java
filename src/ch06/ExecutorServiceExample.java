package ch06;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample {
	public static void main(String[] args) {
		//ExecutorService executorService = Executors.newSingleThreadExecutor();
		//ExecutorService executorService = Executors.newFixedThreadPool(2);
		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(()->System.out.println("task1"));
		executorService.execute(()->System.out.println("task2"));
		executorService.execute(new MyTask("TODO 1"));
		executorService.execute(new MyTask("TODO 2"));
		executorService.execute(new MyTask("TODO 3"));
		executorService.shutdown();
	}
}

class MyTask implements Runnable {
	private String id;

	public MyTask(String id) {
		this.id = id;
	}

	@Override
	public void run() {
		for(int i = 0; i < 5; i++) {
			System.out.println("Task ID : " + id + ", running ... " + i);

			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}