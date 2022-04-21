package ch05;

import java.util.ArrayList;
import java.util.List;

public class StreamDistinctExample {
	public static void main(String[] args) {
		List<Person> list = new ArrayList<>();
		list.add(new Person("장윤기", 45));
		list.add(new Person("홍길동", 18));
		list.add(new Person("전우치", 14));
		list.add(new Person("장윤기", 45));

		list.stream().distinct().forEach(System.out::println);
	}

}
