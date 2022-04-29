package ch08;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class DatePeriod {
	public static void main(String[] args) {
		LocalDate oldDate = LocalDate.of(2007, 10, 3);
		LocalDate newDate = LocalDate.of(2018, 4, 27);

		System.out.println(oldDate);
		System.out.println(newDate);

		Period period = Period.between(oldDate, newDate);
		System.out.printf("%s년 %s개월 %s일만에 정상회담 개최", period.getYears(), period.getMonths(), period.getDays());
		System.out.printf("%s일만에 정상회담 개최", ChronoUnit.DAYS.between(oldDate, newDate));
	}
}
