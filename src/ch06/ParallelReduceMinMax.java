package ch06;

import java.util.Arrays;
import java.util.List;

public class ParallelReduceMinMax {
	public static void main(String[] args) {
		List<Integer> intList = Arrays.asList(4, 2, 8, 1, 9, 6, 7, 3, 5);

		int max = intList.parallelStream().reduce(-1, Integer::max);
		System.out.printf("최댓값 : %s\n", max);

		int min = intList.parallelStream().reduce(10000, Integer::min);
		System.out.printf("최솟값 : %s\n", min);
	}

}
