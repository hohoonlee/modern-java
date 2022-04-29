package ch08;

import java.time.LocalDate;
import java.time.Month;

public class LocalDateExample {
	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
		//LocalDate birthday = LocalDate.of(1973, Month.NOVEMBER, 17);
		LocalDate birthday = LocalDate.of(1973, Month.of(11), 17);
		LocalDate nextBday = birthday.withYear(today.getYear());

		System.out.println(today);
		System.out.println(birthday);
		System.out.println(nextBday);
	}

}
