package ingsoft1920.dho.models;

import java.sql.Time;
import java.time.LocalDate;

public class Servicios {
	private int servicios_id;
	private int estancia_id;
	private int cliente_id;
	private String lugar;
	private LocalDate fecha_servicio;
	private Time hora;
	private String tipo_servicio;
	
	public Servicios(int servicios_id, int estancia_id, int cliente_id, String lugar, LocalDate fecha_servicio,
			Time hora, String tipo_servicio) {
		super();
		this.servicios_id = servicios_id;
		this.estancia_id = estancia_id;
		this.cliente_id = cliente_id;
		this.lugar = lugar;
		this.fecha_servicio = fecha_servicio;
		this.hora = hora;
		this.tipo_servicio = tipo_servicio;
	}

	public int getServicios_id() {
		return servicios_id;
	}
	public void setServicios_id(int servicios_id) {
		this.servicios_id = servicios_id;
	}
	public int getEstancia_id() {
		return estancia_id;
	}
	public void setEstancia_id(int estancia_id) {
		this.estancia_id = estancia_id;
	}
	public int getCliente_id() {
		return cliente_id;
	}
	public void setCliente_id(int cliente_id) {
		this.cliente_id = cliente_id;
	}
	public String getLugar() {
		return lugar;
	}
	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
	public LocalDate getFecha_servicio() {
		return fecha_servicio;
	}
	public void setFecha_servicio(LocalDate fecha_servicio) {
		this.fecha_servicio = fecha_servicio;
	}
	public Time getHora() {
		return hora;
	}
	public void setHora(Time hora) {
		this.hora = hora;
	}
	public String getTipo_servicio() {
		return tipo_servicio;
	}
	public void setTipo_servicio(String tipo_servicio) {
		this.tipo_servicio = tipo_servicio;
	}
	@Override
	public String toString() {
		return "Servicios [servicios_id=" + servicios_id + ", estancia_id=" + estancia_id + ", cliente_id=" + cliente_id
				+ ", lugar=" + lugar + ", fecha_servicio=" + fecha_servicio + ", hora=" + hora + ", tipo_servicio="
				+ tipo_servicio + "]";
	}

}
