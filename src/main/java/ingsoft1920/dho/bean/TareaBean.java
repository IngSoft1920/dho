package ingsoft1920.dho.bean;

import java.sql.Date;
import java.sql.Time;

import org.springframework.stereotype.Component;

@Component
public class TareaBean {

	private int id_tarea;
	private int id_incidencia;
	private int id_empleado;
	private String descripcion;
	private String tipo_tarea;// se puede poner o un string o asignar un numero a los tipos que hay
	private String lugar;// formato: HABITACION id_habitacion
	private boolean estado;
	private Date fecha;
	private int hotel_id;
	
	
	//AÑADIR ESTE CAMPO A LA BASE DE DATOS
	private Time hora;

	public TareaBean() {
		
	}
	
	
	public TareaBean(int id_tarea, int id_incidencia, int id_empleado, String descripcion, String tipo_tarea,
			String lugar, boolean estado, Date fecha,Time hora, int hotel_id) {
		this.id_tarea=id_tarea;

		this.id_incidencia = id_incidencia;
		this.id_empleado = id_empleado;
		this.descripcion = descripcion;
		this.tipo_tarea = tipo_tarea;
		this.lugar = lugar;
		this.estado = estado;
		this.fecha = fecha;
		this.hora=hora;
		this.hotel_id=hotel_id;
	}

	public TareaBean(int id_empleado, String tipo_tarea, String lugar) {
		this.id_empleado = id_empleado;
		this.tipo_tarea = tipo_tarea;
		this.lugar = lugar;
	}

	public boolean estaRelleno(TareaBean tarea) {
		return true;
	}

	public int getId_incidencia() {
		return id_incidencia;
	}

	public void setId_incidencia(int id_incidencia) {
		this.id_incidencia = id_incidencia;
	}

	public int getId_empleado() {
		return id_empleado;
	}

	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipo_tarea() {
		return tipo_tarea;
	}

	public void setTipo_tarea(String tipo_tarea) {
		this.tipo_tarea = tipo_tarea;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public int getId_tarea() {
		return id_tarea;
	}

	public void setId_tarea(int id_tarea) {
		this.id_tarea = id_tarea;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	@Override
	public String toString() {
		return "TareaBean [id_tarea=" + id_tarea + ", id_incidencia=" + id_incidencia + ", id_empleado=" + id_empleado
				+ ", descripcion=" + descripcion + ", tipo_tarea=" + tipo_tarea + ", lugar=" + lugar + ", estado="
				+ estado + ", fecha=" + fecha  +", hora= "+hora +", hotel_id= " +hotel_id + "]";
	}


	public Time getHora() {
		return hora;
	}


	public void setHora(Time hora) {
		this.hora = hora;
	}


	public int getHotel_id() {
		return hotel_id;
	}


	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}

}
