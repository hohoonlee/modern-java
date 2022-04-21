package ch05;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamMatchExample {
	public static void main(String[] args) {
		List<Integer> numberList = Arrays.asList(1, 3, 5, 7, 9);

		boolean answer1 = numberList.stream().allMatch(n -> n < 10);
		System.out.println("all n < 10 ? : " + answer1);

		Optional<Integer> result = numberList.stream().filter(n -> n % 3 == 0).findAny();
		System.out.println(result);
	}

}
