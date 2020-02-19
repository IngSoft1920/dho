package ingsoft1920.dho.bean;

import org.springframework.stereotype.Component;

@Component 
public class HotelBean {
	private int hotel_id; 
	
	public HotelBean() {
		
	}
	public HotelBean(int hotel_id) { 
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
