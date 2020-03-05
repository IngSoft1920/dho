package ingsoft1920.dho.bean;

import org.springframework.stereotype.Component;

@Component
public class HabitacionBean {

	/*
	 * Cada Bean creado pretende ser utilizado para el paso y envio de inforrmacion
	 * requerida, encapsulando lo enviado y recibido en el objeto para que sea mas
	 * comodo trabajar con ellos y no haga falta trabajar con el JSON, puede que
	 * haya que modificarlos ha medida que avanza el proyecto
	 */

	private int id_habitacion;
	private int id_hotel;
	private String tipo_habitacion;
	private int capacidad;

	public HabitacionBean() {
	}

	public HabitacionBean(int id_habitacion, int id_hotel, String tipo_habitacion, int capacidad) {
		this.id_habitacion = id_habitacion;
		this.id_hotel = id_hotel;
		this.tipo_habitacion = tipo_habitacion;
		this.capacidad = capacidad;
	}

	public int getId_habitacion() {
		return id_habitacion;
	}

	public void setId_habitacion(int id_habitacion) {
		this.id_habitacion = id_habitacion;
	}

	public String getTipo_habitacion() {
		return tipo_habitacion;
	}

	public void setTipo_habitacion(String tipo_habitacion) {
		this.tipo_habitacion = tipo_habitacion;
	}

	public int getId_hotel() {
		return id_hotel;
	}

	public void setId_hotel(int id_hotel) {
		this.id_hotel = id_hotel;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	@Override
	public String toString() {
		return "HabitacionBean [id_habitacion=" + id_habitacion + ", id_hotel=" + id_hotel + ", tipo_habitacion="
				+ tipo_habitacion + "]";
	}

}
