package ch08;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DateFormatError {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		final DateFormat format = new SimpleDateFormat("yyyyMMdd");
		final String dt = "20220426";
		Callable<Date> task = () -> format.parse(dt);

		ExecutorService exec = Executors.newFixedThreadPool(5);
		List<Future<Date>> results = new ArrayList<>();

		for(int i = 0; i < 5; i++) {
			results.add(exec.submit(task));
		}
		exec.shutdown();

		for(Future<Date> result : results) {
			System.out.println(result.get());
		}
	}

}
