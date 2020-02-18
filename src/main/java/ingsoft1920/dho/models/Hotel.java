package ingsoft1920.dho.models;

public class Hotel {
	private int hotel_id;
	public Hotel(int hotel_id) {
		super();
		this.hotel_id=hotel_id;
	}
	public int getHotel_id() {
		return hotel_id;
	}
	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}
	@Override
	public String toString() {
		return "Hotel [hotel_id=" + hotel_id + "]";
	}

}
