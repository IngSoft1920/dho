package ingsoft1920.dho.bean;

import org.springframework.stereotype.Component;


@Component
public class ReservaBean {
	
	int id;
	String nombre;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getNombre() {
		return nombre;
	}
	
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	@Override
	public String toString() {
		return "Reserva [id=" + id + ", nombre=" + nombre + "]";
	}

	
	
	
	
	
	
	
	
	
}
