package ingsoft1920.dho.models;

import java.sql.Date;
import java.time.LocalDate;

public class Incidencia {
	private int incidencia_id;
	private String descripcion;
	private String lugar_incidencia;
	private Date fecha_incidencia;
	private String tipo_incidencia;
	
	public Incidencia(int incidencia_id, String descripcion, String lugar_incidencia, Date fecha_incidencia,
			String tipo_incidencia) {
		super();
		this.incidencia_id = incidencia_id;
		this.descripcion = descripcion;
		this.lugar_incidencia = lugar_incidencia;
		this.fecha_incidencia = fecha_incidencia;
		this.tipo_incidencia = tipo_incidencia;
	}

	public int getIncidencia_id() {
		return incidencia_id;
	}
	public void setIncidencia_id(int incidencia_id) {
		this.incidencia_id = incidencia_id;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getLugar_incidencia() {
		return lugar_incidencia;
	}
	public void setLugar_incidencia(String lugar_incidencia) {
		this.lugar_incidencia = lugar_incidencia;
	}
	public Date getFecha_incidencia() {
		return fecha_incidencia;
	}
	public void setFecha_incidencia(Date fecha_incidencia) {
		this.fecha_incidencia = fecha_incidencia;
	}
	public String getTipo_incidencia() {
		return tipo_incidencia;
	}
	public void setTipo_incidencia(String tipo_incidencia) {
		this.tipo_incidencia = tipo_incidencia;
	}
	@Override
	public String toString() {
		return "Incidencia [incidencia_id=" + incidencia_id + ", descripcion=" + descripcion + ", lugar_incidencia="
				+ lugar_incidencia + ", fecha_incidencia=" + fecha_incidencia + ", tipo_incidencia=" + tipo_incidencia
				+ "]";
	}

}
