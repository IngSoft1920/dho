package ingsoft1920.dho.bean;


import java.sql.Date;

import org.springframework.stereotype.Component; 

@Component 
public class IncidenciaBean {

	
	
	//El numero de incidencias lo calculamos con una consulta
	private int id_incidencia;

	private String tipo_incidencia;
	
	private String descripcion;
	
	private String lugar;
	
	private Date fecha;
	
	private int hotel_id;
	
	
	
	
	

	public IncidenciaBean() {
		
	}

	public IncidenciaBean(int id_incidencia, String tipo_incidencia, String descripcion, String lugar, Date fecha, int hotel_id) {
		this.id_incidencia = id_incidencia;
		this.tipo_incidencia = tipo_incidencia;
		this.descripcion = descripcion;
		this.lugar = lugar;
		this.fecha = fecha;
		this.setHotel_id(hotel_id);
	}
	
	
	public int getId_incidencia() {
		return id_incidencia;
	}

	public void setId_incidencia(int id_incidencia) {
		this.id_incidencia = id_incidencia;
	}

	public String getTipo_incidencia() {
		return tipo_incidencia;
	}

	public void setTipo_incidencia(String incidencia) {
		this.tipo_incidencia = incidencia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "IncidenciaBean [id_incidencia=" + id_incidencia + ", tipo_incidencia=" + tipo_incidencia
				+ ", descripcion=" + descripcion + ", lugar=" + lugar + ", fecha=" + fecha + "]";
	}

	public int getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}
	
	
	
	
	
	
}
