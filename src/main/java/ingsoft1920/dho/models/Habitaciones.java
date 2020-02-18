package ingsoft1920.dho.models;

public class Habitaciones {
	private int habitacion_id;
	private String tipo_habitacion;
	private int hotel_id;
	
	public Habitaciones(int habitacion_id, String tipo_habitacion, int hotel_id) {
		super();
		this.habitacion_id = habitacion_id;
		this.tipo_habitacion = tipo_habitacion;
		this.hotel_id = hotel_id;
	}
	public int getHabitacion_id() {
		return habitacion_id;
	}
	public void setHabitacion_id(int habitacion_id) {
		this.habitacion_id = habitacion_id;
	}
	public String getTipo_habitacion() {
		return tipo_habitacion;
	}
	public void setTipo_habitacion(String tipo_habitacion) {
		this.tipo_habitacion = tipo_habitacion;
	}
	public int getHotel_id() {
		return hotel_id;
	}
	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}
	@Override
	public String toString() {
		return "Habitaciones [habitacion_id=" + habitacion_id + ", tipo_habitacion=" + tipo_habitacion + ", hotel_id="
				+ hotel_id + "]";
	}
	


}
