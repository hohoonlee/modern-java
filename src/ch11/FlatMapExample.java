package ch11;

import java.nio.charset.MalformedInputException;
import java.util.Optional;

public class FlatMapExample {
	private String name;
	private Optional<String> age;

	public FlatMapExample(String name, String age) {
		this.name = name;
		this.age = Optional.ofNullable(age);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Optional<String> getAge() {
		return age;
	}

	public void setAge(Optional<String> age) {
		this.age = age;
	}

	public static void main(String[] args) {
		FlatMapExample example = new FlatMapExample("YK Chang", "45");
		Optional<FlatMapExample> optExample = Optional.of(example);

		Optional<Optional<String>> age = optExample.map(v -> v.getAge());
		System.out.println("map : " + age.get().get());

		Optional<String> flatAge = optExample.flatMap(v -> v.getAge());
		System.out.println("flat map : " + flatAge.get());
	}

}
