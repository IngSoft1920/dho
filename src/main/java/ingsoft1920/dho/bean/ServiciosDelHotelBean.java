package ingsoft1920.dho.bean;

import org.springframework.stereotype.Component;

@Component
public class ServiciosDelHotelBean {

	//TABLA A CREAR EN MYSQL
	
	
	//este campo va a ser llave foranea en la tabla servicios
	//HAY QUE AÑADIRLA
	private int id_ServicioHotel;
	
	private String HoraInicioServicio;
	
	
	private String HoraFinServicio;
	
	
	//en el caso del restaurante va ser un numero muy alto y para el resto de servicios 
	//fijamos una disponibilidad
	//este campo se va a ir actualiando segun nos vayan reservando(se ira decrementando segun
	//reserven servicios)
	private int DisponibilidaTotal;

	
	
	
	
	public ServiciosDelHotelBean() {
		
	}


	public ServiciosDelHotelBean(int id_ServicioHotel, String horaInicioServicio, String horaFinServicio,
			int disponibilidadTotal) {
		
		this.id_ServicioHotel = id_ServicioHotel;
		HoraInicioServicio = horaInicioServicio;
		HoraFinServicio = horaFinServicio;
		disponibilidadTotal = disponibilidadTotal;
	}


	public int getId_ServicioHotel() {
		return id_ServicioHotel;
	}


	public void setId_Servicio(int id_ServicioHotel) {
		this.id_ServicioHotel = id_ServicioHotel;
	}


	public String getHoraInicioServicio() {
		return HoraInicioServicio;
	}


	public void setHoraInicioServicio(String horaInicioServicio) {
		HoraInicioServicio = horaInicioServicio;
	}


	public String getHoraFinServicio() {
		return HoraFinServicio;
	}


	public void setHoraFinServicio(String horaFinServicio) {
		HoraFinServicio = horaFinServicio;
	}


	public int getDisponibilidadTotal() {
		return DisponibilidaTotal;
	}


	public void setDisponibilidadTotal(int disponibilidadTotal) {
		disponibilidadTotal = DisponibilidaTotal;
	}
	
	
	
	
}
