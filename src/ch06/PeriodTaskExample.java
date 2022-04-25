package ch06;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class PeriodTaskExample {
	public static void main(String[] args) {
		ScheduledExecutorService service = Executors.newScheduledThreadPool(2);

		service.scheduleWithFixedDelay(() -> System.out.println("Delayed 1"), 5, 10, TimeUnit.SECONDS);
		service.scheduleAtFixedRate(() -> System.out.println("Rate 1"), 5, 10, TimeUnit.SECONDS);
		service.scheduleAtFixedRate(() -> System.out.println("Rate 2"), 5, 10, TimeUnit.SECONDS);
	}

}
