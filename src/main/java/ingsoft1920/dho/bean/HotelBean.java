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
		this.setNombre(nombre);
		this.setDescripcion(descripcion);
		this.setEstrellas(estrellas);
		this.setContinente(continente);
		this.setPais(pais);
		this.setCiudad(ciudad);
	}

	public int getHotel_id() { 
		return hotel_id; 
	} 
	public void setHotel_id(int hotel_id) { 
		this.hotel_id = hotel_id; 
	} 
	@Override
	public String toString() {
		return "HotelBean [hotel_id=" + hotel_id + ", nombre=" + nombre + ", descripcion=" + descripcion
				+ ", estrellas=" + estrellas + ", continente=" + continente + ", pais=" + pais + ", ciudad=" + ciudad
				+ "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getEstrellas() {
		return estrellas;
	}

	public void setEstrellas(int estrellas) {
		this.estrellas = estrellas;
	}

	public String getContinente() {
		return continente;
	}

	public void setContinente(String continente) {
		this.continente = continente;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	} 
	

}
