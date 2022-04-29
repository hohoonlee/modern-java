package ch08;

import java.rmi.StubNotFoundException;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class DateAdjusters {
	public static void main(String[] args) {
		LocalDate localDate = LocalDate.now();

		DayOfWeek dayOfWeek = localDate.getDayOfWeek();

		System.out.printf("%s 일의 요일은 %s 입니다.\n", localDate, dayOfWeek);
		System.out.printf("이번 달의 첫 번째 일 : %s\n", localDate.with(TemporalAdjusters.firstDayOfMonth()));
		System.out.printf("이번 달의 첫 번째 월요일 : %s\n", localDate.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)));
		System.out.printf("이번 달의 마지막 일 : %s\n", localDate.with(TemporalAdjusters.lastDayOfMonth()));
		System.out.printf("다음 달의 첫 번째 일 : %s\n", localDate.with(TemporalAdjusters.firstDayOfNextMonth()));
		System.out.printf("다음 달의 첫 번째 요일 : %s\n", localDate.with(TemporalAdjusters.firstDayOfNextMonth()).getDayOfWeek());
		System.out.printf("내년 첫 번째 일 : %s\n", localDate.with(TemporalAdjusters.firstDayOfNextYear()));
		System.out.printf("올해 첫 번째 일 : %s\n", localDate.with(TemporalAdjusters.firstDayOfYear()));
	}

}
