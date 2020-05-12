package ingsoft1920.dho.bean;

public class Proveedores {
	private int proveedor_id;
	private String empresa;
	private int hotel_id;
	
	public Proveedores(int proveedor_id, String empresa, int hotel_id) {
		this.proveedor_id = proveedor_id;
		this.empresa=empresa;
		this.hotel_id=hotel_id;
	}

	@Override
	public String toString() {
		return "Proveedores [proveedor_id=" + proveedor_id + ", empresa=" + empresa + ", hotel_id=" + hotel_id + "]";
	}

	public int getProveedor_id() {
		return proveedor_id;
	}

	public void setProveedor_id(int proveedor_id) {
		this.proveedor_id = proveedor_id;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public int getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}

}
