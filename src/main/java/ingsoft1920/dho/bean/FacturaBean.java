package ingsoft1920.dho.bean;

import java.sql.Date;
import java.time.LocalDate;

import org.springframework.stereotype.Component;

@Component 
public class FacturaBean {
	private int factura_id; 
	private int estancia_id; 
	private int cliente_id; 
	private int habitacion_id; 
	private Date fecha_factura; 
	private int precio; 
	private boolean pagado; 
	private String tipo_factura; 
	
	public FacturaBean() {
		
	}
	 
	public FacturaBean(int factura_id, int estancia_id, int cliente_id, int habitacion_id, Date fecha_factura, 
			int precio, boolean pagado, String tipo_factura) { 
		this.factura_id = factura_id; 
		this.estancia_id = estancia_id; 
		this.cliente_id = cliente_id; 
		this.habitacion_id = habitacion_id; 
		this.fecha_factura = fecha_factura; 
		this.precio = precio; 
		this.pagado = pagado; 
		this.tipo_factura = tipo_factura; 
	} 
 
	public int getFactura_id() { 
		return factura_id; 
	} 
	public void setFactura_id(int factura_id) { 
		this.factura_id = factura_id; 
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
	public Date getFecha_factura() { 
		return fecha_factura; 
	} 
	public void setFecha_factura(Date fecha_factura) { 
		this.fecha_factura = fecha_factura; 
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
	public String getTipo_factura() { 
		return tipo_factura; 
	} 
	public void setTipo_factura(String tipo_factura) { 
		this.tipo_factura = tipo_factura; 
	} 
	@Override 
	public String toString() { 
		return "Factura [factura_id=" + factura_id + ", estancia_id=" + estancia_id + ", cliente_id=" + cliente_id 
				+ ", habitacion_id=" + habitacion_id + ", fecha_factura=" + fecha_factura + ", precio=" + precio 
				+ ", pagado=" + pagado + ", tipo_factura=" + tipo_factura + "]"; 
	} 
}
