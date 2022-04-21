package ch05;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FirstStreamExample {
	public static void main(String[] args) {
		List<String> firstList = new ArrayList<>();
		firstList.add("1");
		firstList.add("2");
		firstList.add("3");
		firstList.add("4");
		firstList.add("5");
		firstList.add("6");
		firstList.add("7");
		firstList.add("8");
		firstList.add("9");
		firstList.add("0");

		System.out.println("First List : " + firstList);

		Stream<String> firstStream = firstList.stream();
		System.out.println("Stream  항목 개수 : " + firstStream.count());

		Stream<String> limitedStream = firstList.stream().limit(5);
		limitedStream.forEach(System.out::println);
	}

}
