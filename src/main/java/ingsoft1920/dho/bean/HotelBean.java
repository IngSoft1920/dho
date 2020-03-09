package ingsoft1920.dho.bean;

import org.springframework.stereotype.Component;

@Component 
public class HotelBean {
	private int hotel_id; 
	private String nombre;
	private String descripcion;
	private int estrellas;
	private String continente;
	private String pais;
	private String ciudad;
	
	
	public HotelBean() {
		// TODO Auto-generated constructor stub
	} 
		
	public HotelBean(int hotel_id) { 
		this.hotel_id=hotel_id; 
	}
	
	public HotelBean(int hotel_id, String nombre, String descripcion, int estrellas, String continente, String pais,
			String ciudad) {
		super();
		this.hotel_id = hotel_id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.estrellas = estrellas;
		this.continente = continente;
		this.pais = pais;
		this.ciudad = ciudad;
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
