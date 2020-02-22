package ingsoft1920.dho.bean;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component 
public class EstanciaBean {
	
	
	private int estancia_id; 
	private int habitacion_id; 
	private int cliente_id; 
	private int hotel_id; 
	private Date fecha_inicio; 
	private Date fecha_fin; 
	//check in, check out o ninguno
	private String estado;
	
	public EstanciaBean() {
		
	}
	
	public EstanciaBean(int estancia_id, int habitacion_id, int cliente_id, int hotel_id, Date fecha_inicio, 
			Date fecha_fin,String estado) { 
		this.estancia_id = estancia_id; 
		this.habitacion_id = habitacion_id; 
		this.cliente_id = cliente_id; 
		this.hotel_id = hotel_id; 
		this.fecha_inicio = fecha_inicio; 
		this.fecha_fin = fecha_fin; 
		this.estado=estado;
	} 
	public int getEstancia_id() { 
		return estancia_id; 
	} 
	public void setEstancia_id(int estancia_id) { 
		this.estancia_id = estancia_id; 
	} 
	public int getHabitacion_id() { 
		return habitacion_id; 
	} 
	public void setHabitacion_id(int habitacion_id) { 
		this.habitacion_id = habitacion_id; 
	} 
	public int getCliente_id() { 
		return cliente_id; 
	} 
	public void setCliente_id(int cliente_id) { 
		this.cliente_id = cliente_id; 
	} 
	public int getHotel_id() { 
		return hotel_id; 
	} 
	public void setHotel_id(int hotel_id) { 
		this.hotel_id = hotel_id; 
	} 
	public Date getFecha_inicio() { 
		return fecha_inicio; 
	} 
	public void setFecha_inicio(Date fecha_inicio) { 
		this.fecha_inicio = fecha_inicio; 
	} 
	public Date getFecha_fin() { 
		return fecha_fin; 
	} 
	public void setFecha_fin(Date fecha_fin) { 
		this.fecha_fin = fecha_fin; 
	} 
	@Override 
	public String toString() { 
		return "Estancia [estancia_id=" + estancia_id + ", habitacion_id=" + habitacion_id + ", cliente_id=" 
				+ cliente_id + ", hotel_id=" + hotel_id + ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin 
				+ "]"; 
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	} 
	
	@Override 
	public String toString() { 
		return "Estancia [estancia_id=" + estancia_id + ", habitacion_id=" + habitacion_id + ", cliente_id=" 
				+ cliente_id + ", hotel_id=" + hotel_id + ", fecha_inicio=" + fecha_inicio + ", fecha_fin=" + fecha_fin 
				+ "estado="+estado+ "]"; 
	}
}
