package ingsoft1920.dho.fna;

public class ClienteBean {

	private String nombre;
	private String apellidos;
	private String DNI;
	private String email;
	private String telefono;

	
	public ClienteBean(String nombre, String apellidos, String dNI, String email, String telefono) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		DNI = dNI;
		this.email = email;
		this.telefono = telefono;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getDNI() {
		return DNI;
	}


	public void setDNI(String dNI) {
		DNI = dNI;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	@Override
	public String toString() {
		return "ClienteBean [nombre=" + nombre + ", apellidos=" + apellidos + ", DNI=" + DNI + ", email=" + email
				+ ", telefono=" + telefono + "]";
	}
}
