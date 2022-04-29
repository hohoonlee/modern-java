package ch08;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ParsingDate {
	public static void main(String[] args) {
		String year = "2019";
		String month = "03";
		String day = "14";
		String input = year + " " + month + " " + day;

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy MM dd");
		LocalDate date = LocalDate.parse(input, formatter);
		System.out.println(date.toString());
	}

}
