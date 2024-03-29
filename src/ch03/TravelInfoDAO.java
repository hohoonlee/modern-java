package ch03;

import java.util.ArrayList;
import java.util.List;

public class TravelInfoDAO {
	public static final String COUNTRY_VIETNAM = "vietnam";
	public static final String COUNTRY_PHILLIPHINE = "philliphine";
	public static final String COUNTRY_TAILAND = "tailand";

	public static List<TravelInfo> createTravelList() {
		List<TravelInfo> travelInfoList = new ArrayList<>();

		TravelInfo cebu = new TravelInfo();
		cebu.setName("Cebu Travel");
		cebu.setCountry(COUNTRY_PHILLIPHINE);
		cebu.setCity("cebu");
		cebu.setDays(5);
		cebu.setNights(3);
		travelInfoList.add(cebu);

		TravelInfo boracay = new TravelInfo();
		boracay.setName("Boracay Travel");
		boracay.setCountry(COUNTRY_PHILLIPHINE);
		boracay.setCity("boracay");
		boracay.setDays(5);
		boracay.setNights(3);
		travelInfoList.add(boracay);

		TravelInfo hanoi = new TravelInfo();
		hanoi.setName("Hanoi Travel");
		hanoi.setCountry(COUNTRY_VIETNAM);
		hanoi.setCity("hanoi");
		hanoi.setDays(3);
		hanoi.setNights(2);
		travelInfoList.add(hanoi);

		TravelInfo danang = new TravelInfo();
		danang.setName("Danang Travel");
		danang.setCountry(COUNTRY_VIETNAM);
		danang.setCity("danang");
		danang.setDays(6);
		danang.setNights(4);
		travelInfoList.add(danang);

		TravelInfo bankok = new TravelInfo();
		bankok.setName("Bankok Travel");
		bankok.setCountry(COUNTRY_TAILAND);
		bankok.setCity("bankok");
		bankok.setDays(5);
		bankok.setNights(3);
		travelInfoList.add(bankok);

		return travelInfoList;
	}
}
