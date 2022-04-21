package ch05;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ch03.TravelInfo;
import ch03.TravelInfoDAO;

public class StreamFilterExample {
	public static void main(String[] args) {
		List<TravelInfo> travelList = TravelInfoDAO.createTravelList();
		Stream<TravelInfo> travelStream = travelList.stream();

		travelStream.filter(t -> TravelInfoDAO.COUNTRY_PHILLIPHINE.equals(t.getCountry())).forEach(System.out::println);

		Collection<String> list = Arrays.asList("A", "B", "C", "D", "A", "B", "C");
		List<String> ele = list.stream().distinct().map(v->{
			v=v+v;
			return v;
		}).collect(Collectors.toList());
		System.out.println(ele);
		System.out.println(list);
	}

}
