package ch05;

import java.util.*;
import java.util.stream.Collectors;

public class StreamSortedExample {
	public static void main(String[] args) {
		List<Person> list = new ArrayList<>();
		list.add(new Person("장윤기", 45));
		list.add(new Person("홍길동", 18));
		list.add(new Person("전우치", 14));
		list.add(new Person("장윤기", 45));

		list.stream().sorted().forEach(System.out::println);
		System.out.println("===========================");
		list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		System.out.println("===========================");
		list.stream().sorted(Comparator.comparing(Person::getAge)).forEach(System.out::println);
		System.out.println("===========================");
		list.stream().sorted(Comparator.comparing(Person::getName)).forEach(System.out::println);
		System.out.println("===========================>");
		list.stream().map(p->p.getName()).forEach(System.out::println);
		list.stream().mapToInt(Person::getAge).forEach(System.out::println);
		System.out.println("===========================>>");
		List<Person> sortedList = list.stream().sorted().collect(Collectors.toList());
		for(Person p: sortedList) {
			System.out.println(p);
		}
		System.out.println(list.stream().map(Person::getName).collect(Collectors.joining(",")));
		Map<String, Integer> result = list.stream().collect(Collectors.groupingBy(Person::getName, Collectors.summingInt(Person::getAge)));
		System.out.println(result);
	}
}
