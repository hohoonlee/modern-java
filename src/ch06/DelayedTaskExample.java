package ch06;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DelayedTaskExample {
	public static void main(String[] args) {
		ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

		executorService.schedule(() -> System.out.println("TODO  1"), 10, TimeUnit.SECONDS);
		executorService.schedule(() -> System.out.println("TODO  2"), 20, TimeUnit.SECONDS);
		executorService.schedule(() -> System.out.println("TODO  3"), 30, TimeUnit.SECONDS);

		executorService.shutdown();
	}

}
