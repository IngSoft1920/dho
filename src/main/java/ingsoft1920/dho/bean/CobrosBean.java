package ingsoft1920.dho.bean;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component 
public class CobrosBean {
	private int cobros_id; 
	private int estancia_id; 
	private int cliente_id; 
	private int habitacion_id; 
	private Date fecha_cobro; 
	private int precio; 
	private boolean pagado; 
	private String tipo_cobro; 
		
	public CobrosBean() {
	}
	public CobrosBean(int cobros_id, int estancia_id, int cliente_id, int habitacion_id, Date fecha_cobro, int precio, 
			boolean pagado, String tipo_cobro) { 
		this.cobros_id = cobros_id; 
		this.estancia_id = estancia_id; 
		this.cliente_id = cliente_id; 
		this.habitacion_id = habitacion_id; 
		this.fecha_cobro = fecha_cobro; 
		this.precio = precio; 
		this.pagado = pagado; 
		this.tipo_cobro = tipo_cobro; 
	} 
 
	public int getCobros_id() { 
		return cobros_id; 
	} 
	public void setCobros_id(int cobros_id) { 
		this.cobros_id = cobros_id; 
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
	public int getHabitacion_id() { 
		return habitacion_id; 
	} 
	public void setHabitacion_id(int habitacion_id) { 
		this.habitacion_id = habitacion_id; 
	} 
	public Date getFecha_cobro() { 
		return fecha_cobro; 
	} 
	public void setFecha_cobro(Date fecha_cobro) { 
		this.fecha_cobro = fecha_cobro; 
	} 
	public int getPrecio() { 
		return precio; 
	} 
	public void setPrecio(int precio) { 
		this.precio = precio; 
	} 
	public boolean isPagado() { 
		return pagado; 
	} 
	public void setPagado(boolean pagado) { 
		this.pagado = pagado; 
	} 
	public String getTipo_cobro() { 
		return tipo_cobro; 
	} 
	public void setTipo_cobro(String tipo_cobro) { 
		this.tipo_cobro = tipo_cobro; 
	} 
	@Override 
	public String toString() { 
		return "Cobros [cobros_id=" + cobros_id + ", estancia_id=" + estancia_id + ", cliente_id=" + cliente_id 
				+ ", habitacion_id=" + habitacion_id + ", fecha_cobro=" + fecha_cobro + ", precio=" + precio 
				+ ", pagado=" + pagado + ", tipo_cobro=" + tipo_cobro + "]"; 
	} 

}
