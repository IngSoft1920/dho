package ingsoft1920.dho.bean;

import java.sql.Date;

public class GruposBean {
	private int grupo_id;
	private String nombre;
	private String tipo;
	private int hotel_id;
	private int num_habitaciones;
	private int num_personas;
	private Date fecha_entrada;
	private Date fecha_salida;
	private String estado;
	

	public GruposBean(int grupo_id, String nombre, String tipo, int hotel_id, int num_habitaciones, int num_personas,
			Date fecha_entrada, Date fecha_salida, String estado) {
		super();
		this.grupo_id = grupo_id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.hotel_id = hotel_id;
		this.num_habitaciones = num_habitaciones;
		this.num_personas = num_personas;
		this.fecha_entrada = fecha_entrada;
		this.fecha_salida = fecha_salida;
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "GruposBean [grupo_id=" + grupo_id + ", nombre=" + nombre + ", tipo=" + tipo + ", hotel_id=" + hotel_id
				+ ", num_habitaciones=" + num_habitaciones + ", num_personas=" + num_personas + ", fecha_entrada="
				+ fecha_entrada + ", fecha_salida=" + fecha_salida + ", estado=" + estado + "]";
	}

	public int getGrupo_id() {
		return grupo_id;
	}

	public void setGrupo_id(int grupo_id) {
		this.grupo_id = grupo_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}

	public int getNum_habitaciones() {
		return num_habitaciones;
	}

	public void setNum_habitaciones(int num_habitaciones) {
		this.num_habitaciones = num_habitaciones;
	}

	public int getNum_personas() {
		return num_personas;
	}

	public void setNum_personas(int num_personas) {
		this.num_personas = num_personas;
	}

	public Date getFecha_entrada() {
		return fecha_entrada;
	}

	public void setFecha_entrada(Date fecha_entrada) {
		this.fecha_entrada = fecha_entrada;
	}

	public Date getFecha_salida() {
		return fecha_salida;
	}

	public void setFecha_salida(Date fecha_salida) {
		this.fecha_salida = fecha_salida;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}
