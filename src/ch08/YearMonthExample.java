package ch08;

import java.time.Year;
import java.time.YearMonth;

public class YearMonthExample {
	public static void main(String[] args) {
		YearMonth date = YearMonth.now();
		System.out.println(date + " : " + date.lengthOfMonth());

		YearMonth date2 = date.plusYears(1);
		System.out.println(date2 + " : " + date2.lengthOfMonth());

		YearMonth date3 = date.plusMonths(1);
		System.out.println(date3 + " : " + date3.lengthOfMonth());
	}

}
