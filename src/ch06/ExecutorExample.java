package ch06;

import java.util.concurrent.Executor;

public class ExecutorExample implements Executor {
	public static void main(String[] args) {
		Executor executor = new ExecutorExample();
		executor.execute(() -> System.out.println("Hello, Executor!!"));
	}

	@Override
	public void execute(Runnable command) {
		command.run();
	}
}
