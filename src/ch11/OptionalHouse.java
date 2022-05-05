package ch11;

import java.util.Optional;

public class OptionalHouse {
	private String country;
	private Optional<String> city = Optional.empty();
	private Optional<String> address = Optional.empty();
	private Optional<String> detailAddress = Optional.empty();

	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Optional<String> getCity() {
		return city;
	}
	public void setCity(Optional<String> city) {
		this.city = city;
	}
	public Optional<String> getAddress() {
		return address;
	}
	public void setAddress(Optional<String> address) {
		this.address = address;
	}
	public Optional<String> getDetailAddress() {
		return detailAddress;
	}
	public void setDetailAddress(Optional<String> detailAddress) {
		this.detailAddress = detailAddress;
	}
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(country).append(" ");

		city.ifPresent(entity -> sb.append(entity).append(" "));
		address.ifPresent(entity -> sb.append(entity).append(" "));
		detailAddress.ifPresent(entity -> sb.append(entity).append(" "));

		return sb.toString();
	}
}
