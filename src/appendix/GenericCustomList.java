package appendix;

import java.util.ArrayList;
import java.util.List;

public class GenericCustomList<E> {
	private final List<E> list = new ArrayList<>();

	public void add(E element) {
		list.add(element);
	}

	public E get(int index) {
		return list.get(index);
	}

	public static void main(String[] args) {
		GenericCustomList<String> list = new GenericCustomList<>();
		list.add("TEST");
		list.add("123");

		System.out.println(list.get(0));
	}
}
