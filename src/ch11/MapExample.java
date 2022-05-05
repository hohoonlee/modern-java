package ch11;

import java.util.Optional;

public class MapExample {
	public static void main(String[] args) {
		int doubleLength = Optional.of("Hello world")
							.map(s -> s.length())
							.map(i -> i * 2)
							.get();

		System.out.println(doubleLength);
	}
}
