package ch06;

import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;

public class SpliteratorExample {
	public static void main(String[] args) {
		List<HelloPerson> personList = HelloPerson.getSampleDate();

		Spliterator<HelloPerson> peopleIterator = personList.spliterator();
		peopleIterator.forEachRemaining(person -> {
			System.out.printf("안녕~~ %s\n", person);
		});
	}

}
