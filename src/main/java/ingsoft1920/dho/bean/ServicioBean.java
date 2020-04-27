package ingsoft1920.dho.bean;

import org.springframework.stereotype.Component;

import java.sql.Date;
import java.sql.Time;

@Component
public class ServicioBean {

	private int servicios_id;

	private int estancia_id;
	/* esta va a ser la llave foranea */
	private int id_ServicioHotel;
	private int cliente_id;
	private String lugar;
	private Date fecha_servicio;
	private Time hora;
	// creo que ya no nos hace falta este campo asique hay que eliminarlo
	private String tipo_servicio;
	private int precio;

	public ServicioBean() {

	}

	public ServicioBean(int servicios_id, int estancia_id, int id_ServicioHotel, int cliente_id, String lugar,
			Date fecha_servicio, Time hora, String tipo_servicio, int precio) {
		this.servicios_id = servicios_id;
		this.estancia_id = estancia_id;
		this.id_ServicioHotel = id_ServicioHotel;
		this.cliente_id = cliente_id;
		this.lugar = lugar;
		this.fecha_servicio = fecha_servicio;
		this.hora = hora;
		this.tipo_servicio = tipo_servicio;
		this.precio = precio;

	}

	public int getId_ServicioHotel() {
		return id_ServicioHotel;
	}

	public void setId_ServicioHotel(int id_ServicioHotel) {
		this.id_ServicioHotel = id_ServicioHotel;
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

	public Date getFecha_servicio() {
		return fecha_servicio;
	}

	public void setFecha_servicio(Date fecha_servicio) {
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

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "ServicioBean [servicios_id=" + servicios_id + ", estancia_id=" + estancia_id + ", id_ServicoHotel="
				+ id_ServicioHotel + ", cliente_id=" + cliente_id + ", lugar=" + lugar + ", fecha_servicio="
				+ fecha_servicio + ", hora=" + hora + ", tipo_servicio=" + tipo_servicio + ", precio= " + precio + "]";
	}

}
