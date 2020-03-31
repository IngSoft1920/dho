package ingsoft1920.dho.fna;

import java.sql.Date;

public class FacturaBean {
	private Date fecha_factura;
	private String tipo_factura;
	private int precio;
	
	public FacturaBean(Date fecha_factura, String tipo_factura, int precio) {
		this.fecha_factura = fecha_factura;
		this.tipo_factura = tipo_factura;
		this.precio = precio;
	}

	public Date getFecha_factura() {
		return fecha_factura;
	}

	public void setFecha_factura(Date fecha_factura) {
		this.fecha_factura = fecha_factura;
	}

	public String getTipo_factura() {
		return tipo_factura;
	}

	public void setTipo_factura(String tipo_factura) {
		this.tipo_factura = tipo_factura;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String toString() {
		return "[fecha_factura=" + fecha_factura + ", tipo_factura=" + tipo_factura + ", precio=" + precio
				+ "]";
	}
	
	

}
