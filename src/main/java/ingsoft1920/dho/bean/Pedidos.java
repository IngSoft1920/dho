package ingsoft1920.dho.bean;

import java.sql.Date;

public class Pedidos {
	private int pedido_id;
	private int producto_id;
	private int cantidad;
	private Date fecha;
	private String lugar;
	
	public Pedidos(int pedido_id, int producto_id, Date fecha, String lugar) {
		this.pedido_id=pedido_id;
		this.producto_id=producto_id;
		this.fecha=fecha;
		this.lugar=lugar;
	}

	@Override
	public String toString() {
		return "Pedidos [pedido_id=" + pedido_id + ", producto_id=" + producto_id + ", cantidad=" + cantidad
				+ ", fecha=" + fecha + ", lugar=" + lugar + "]";
	}

	public int getPedido_id() {
		return pedido_id;
	}

	public void setPedido_id(int pedido_id) {
		this.pedido_id = pedido_id;
	}

	public int getProducto_id() {
		return producto_id;
	}

	public void setProducto_id(int producto_id) {
		this.producto_id = producto_id;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}
}
