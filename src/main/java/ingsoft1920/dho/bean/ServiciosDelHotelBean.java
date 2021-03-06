package ingsoft1920.dho.bean;

import java.sql.Time;

import org.springframework.stereotype.Component;

@Component
public class ServiciosDelHotelBean {

	//TABLA A CREAR EN MYSQL
	
	
	//este campo va a ser llave foranea en la tabla servicios
	//HAY QUE AÑADIRLA
	private int id_ServicioHotel;
	
	private Time HoraInicioServicio;
	
	
	private Time HoraFinServicio;
	
	
	//en el caso del restaurante va ser un numero muy alto y para el resto de servicios 
	//fijamos una disponibilidad
	//este campo se va a ir actualiando segun nos vayan reservando(se ira decrementando segun
	//reserven servicios)
	private int DisponibilidadTotal;

	private int hotel_id;
	
	private String nombre;
	
	private Integer importe;
	
	public ServiciosDelHotelBean() {
		
	}


	public ServiciosDelHotelBean(int id_ServicioHotel, Time horaInicioServicio, Time horaFinServicio,
			int disponibilidadTotal, int hotel_id, String nombre, int importe) {
		
		this.id_ServicioHotel = id_ServicioHotel;
		HoraInicioServicio = horaInicioServicio;
		HoraFinServicio = horaFinServicio;
		this.DisponibilidadTotal = disponibilidadTotal;
		this.hotel_id=hotel_id;
		this.nombre=nombre;
		this.setImporte(importe);
	}


	public int getId_ServicioHotel() {
		return id_ServicioHotel;
	}


	public void setId_Servicio(int id_ServicioHotel) {
		this.id_ServicioHotel = id_ServicioHotel;
	}


	public Time getHoraInicioServicio() {
		return HoraInicioServicio;
	}


	public void setHoraInicioServicio(Time horaInicioServicio) {
		HoraInicioServicio = horaInicioServicio;
	}


	public Time getHoraFinServicio() {
		return HoraFinServicio;
	}


	public void setHoraFinServicio(Time horaFinServicio) {
		HoraFinServicio = horaFinServicio;
	}


	public int getDisponibilidadTotal() {
		return DisponibilidadTotal;
	}


	public void setDisponibilidadTotal(int disponibilidadTotal) {
		this.DisponibilidadTotal=disponibilidadTotal;
	}


	@Override
	public String toString() {
		return "ServiciosDelHotelBean [id_ServicioHotel=" + id_ServicioHotel + ", HoraInicioServicio="
				+ HoraInicioServicio + ", HoraFinServicio=" + HoraFinServicio + ", DisponibilidaTotal="
				+ DisponibilidadTotal +" hotel_id= "+hotel_id +" nombre= " +nombre +", "+importe + "]";
	}


	public int getHotel_id() {
		return hotel_id;
	}


	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Integer getImporte() {
		return importe;
	}


	public void setImporte(Integer importe) {
		this.importe = importe;
	}
	
	
	
	
}
