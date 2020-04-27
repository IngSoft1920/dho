package ingsoft1920.dho.fna;

public class HotelBean {

	private String nombre;
	private String pais;
	private String ciudad;
	
	public HotelBean(String nombre, String pais, String ciudad) {
		super();
		this.nombre = nombre;
		this.pais = pais;
		this.ciudad = ciudad;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
