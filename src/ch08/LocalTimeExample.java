package ch08;

import java.time.LocalTime;

public class LocalTimeExample {
	public static void main(String[] args) {
		LocalTime localTime = LocalTime.now();

		System.out.println("현재시간 : " + localTime);

		System.out.println("시 추가 : " + localTime.plusHours(1));
		System.out.println("분 추가 : " + localTime.plusMinutes(15));
		System.out.println("초 추가 : " + localTime.plusSeconds(30));
		System.out.println("나노 추가 : " + localTime.plusNanos(50000));

		System.out.println("시 제거 : " + localTime.minusHours(1));
		System.out.println("분 제거 : " + localTime.minusMinutes(15));
		System.out.println("초 제거 : " + localTime.minusSeconds(30));
		System.out.println("나노 제거 : " + localTime.minusNanos(50000));
	}

}
