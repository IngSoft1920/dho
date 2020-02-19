package ingsoft1920.dho.bean; 
 
import org.springframework.stereotype.Component; 
 
@Component 
public class HabitacionBean { 
 
	/*Cada Bean creado pretende ser utilizado para el paso y envio de inforrmacion 
	 * requerida, encapsulando lo enviado y recibido en el objeto para que sea mas comodo 
	 * trabajar con ellos y no haga falta trabajar con el JSON, puede que haya que modificarlos 
	 * ha medida que avanza el proyecto 
	 */ 
	 
	 
	private int id_habitacion; 
	private int id_hotel; 
	private int tipo_habitacion; 
	 
	 
	 
	public HabitacionBean() { 
		 
		 
		 
	} 
	 
	 
	 
	public HabitacionBean(int id_habitacion, int id_hotel,int tipo_habitacion) { 
		this.id_habitacion = id_habitacion; 
		this.id_hotel=id_hotel; 
		this.tipo_habitacion = tipo_habitacion; 
	} 
	 
	 
	 
	 
	public int getId_habitacion() { 
		return id_habitacion; 
	} 
	 
	 
	public void setId_habitacion(int id_habitacion) { 
		this.id_habitacion = id_habitacion; 
	} 
	 
	public int getTipo_habitacion() { 
		return tipo_habitacion; 
	} 
	 
	public void setTipo_habitacion(int tipo_habitacion) { 
		this.tipo_habitacion = tipo_habitacion; 
	} 
 
 
 
	public int getId_hotel() { 
		return id_hotel; 
	} 
 
 
 
	public void setId_hotel(int id_hotel) { 
		this.id_hotel = id_hotel; 
	} 
	 
	 
	 
	 
	 
} 
