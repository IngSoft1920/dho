package ingsoft1920.dho.bean;

public class Productos {
	
	private int producto_id;
	private String nombre;
	private int precio;
	private int proveedor_id;
	
	public Productos(int producto_id, String nombre, int precio, int proveedor_id) {
		this.producto_id=producto_id;
		this.nombre=nombre;
		this.precio=precio;
		this.proveedor_id=proveedor_id;
	}

	@Override
	public String toString() {
		return "Productos [producto_id=" + producto_id + ", nombre=" + nombre + ", precio=" + precio + ", proveedor_id="
				+ proveedor_id + "]";
	}

	public int getProducto_id() {
		return producto_id;
	}

	public void setProducto_id(int producto_id) {
		this.producto_id = producto_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public int getProveedor_id() {
		return proveedor_id;
	}

	public void setProveedor_id(int proveedor_id) {
		this.proveedor_id = proveedor_id;
	}

}
