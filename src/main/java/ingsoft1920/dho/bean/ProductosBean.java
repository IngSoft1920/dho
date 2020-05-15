package ingsoft1920.dho.bean;

public class ProductosBean {
	
	private int producto_id;
	private String nombre;
	private int precio;
	private int proveedor_id;
	private String unidad;
	
	public ProductosBean(int producto_id, String nombre, int precio, int proveedor_id, String unidad) {
		this.producto_id=producto_id;
		this.nombre=nombre;
		this.precio=precio;
		this.proveedor_id=proveedor_id;
		this.unidad=unidad;
		
	}


	
	@Override
	public String toString() {
		return "ProductosBean [producto_id=" + producto_id + ", nombre=" + nombre + ", precio=" + precio
				+ ", proveedor_id=" + proveedor_id + ", unidad=" + unidad + "]";
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

	public String getUnidad() {
		return unidad;
	}

	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}

}
