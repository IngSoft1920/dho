package ingsoft1920.dho.bean;

import org.springframework.stereotype.Component;

@Component
public class ClienteBean {

	private int cliente_id;
	private String nombre;
	private String apellidos;
	private String dni;
	private String email;
	private String password;
	private String nacionalidad;
	private Integer telefono;
	private String preferencias;

	public int getCliente_id() {
		return cliente_id;
	}

	public void setCliente_id(int cliente_id) {
		this.cliente_id = cliente_id;
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}
	public String getPreferencias() {
		return preferencias;
	}

	public void setPreferencias(String preferencias) {
		this.preferencias = preferencias;
	}

	public ClienteBean(int cliente_id, String nombre, String apellidos, String dni, String email,
			String password, String nacionalidad, Integer telefono, String preferencias) {
		super();
		this.cliente_id = cliente_id;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.email = email;
		this.password = password;
		this.nacionalidad = nacionalidad;
		this.telefono = telefono;
		this.preferencias=preferencias;
	}

	@Override
	public String toString() {
		return "ClienteBean [cliente_id=" + cliente_id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", dni="
				+ dni + ", email=" + email + ", password=" + password + ", nacionalidad=" + nacionalidad + ", telefono="
				+ telefono + ", preferencias= "+preferencias +"]";
	}

	public ClienteBean() {
	}

}
