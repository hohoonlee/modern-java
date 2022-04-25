package ch06;

import java.util.Iterator;
import java.util.List;

public class IteratorExample {
	public static void main(String[] args) {
		List<HelloPerson> personList = HelloPerson.getSampleDate();

		Iterator<HelloPerson> peopleIterator = personList.iterator();
		while(peopleIterator.hasNext()) {
			HelloPerson person = peopleIterator.next();
			System.out.printf("안녕~~ %s\n", person);
		}
	}

}
