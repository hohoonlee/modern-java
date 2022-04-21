package ch05;

import java.util.Arrays;
import java.util.List;

public class Basic {
	public static void main(String[] args) {
		Integer[] intArray = new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		List<Integer> numList = Arrays.asList(intArray);

		for(Integer i : numList) {
			System.out.println(i);
		}

		numList.stream().forEach(System.out::println);
	}
}