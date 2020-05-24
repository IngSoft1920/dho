package ingsoft1920.dho.Model;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import ingsoft1920.dho.DAO.EstanciaDAO;
import ingsoft1920.dho.DAO.GruposDAO;
import ingsoft1920.dho.DAO.IncidenciaDAO;
import ingsoft1920.dho.DAO.ServicioDAO;
import ingsoft1920.dho.DAO.TareaDAO;
import ingsoft1920.dho.bean.GruposBean;
import ingsoft1920.dho.bean.IncidenciaBean;
import ingsoft1920.dho.bean.ServicioBean;
import ingsoft1920.dho.bean.TareaBean;

public class GruposModel {
	
	private static int grupo_id;
	private String nombre;
	private String tipo;
	private String email;
	private int hotel_id;
	private int num_habitaciones;
	private int num_personas;
	private Date fecha_entrada;
	private Date fecha_salida;
	private static String estado;
	
	

	public GruposModel() {

	}

	
	//FALTA METER EL PRECIO 
	
	public GruposModel(GruposBean gruposBean) {
		this.setGrupo_id(gruposBean.getGrupo_id());
	    this.setNombre(gruposBean.getNombre());
	    this.setTipo(gruposBean.getTipo());
	    this.setEmail(gruposBean.getEmail());
	    this.setHotel_id(gruposBean.getHotel_id());
	    this.setNum_habitaciones(gruposBean.getNum_habitaciones());
		this.setNum_personas(gruposBean.getNum_personas());
		this.setFecha_entrada(gruposBean.getFecha_entrada());
		this.setFecha_salida(gruposBean.getFecha_salida());
		this.setEstado(gruposBean.getEstado());
		
		
	}

	public List<GruposBean> getGrupos() {

		List<GruposBean> listaGrupos = GruposDAO.getReservasGrupo();

		return listaGrupos;
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
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


	public int getHotel_id() {
		return hotel_id;
	}


	public void setHotel_id(int hotel_id) {
		this.hotel_id = hotel_id;
	}
	public void aceptarReservaGrupo(int grupo_id) {
		GruposDAO.aceptarReservaGrupo(grupo_id);
	}
	public void denegarReservaGrupo(int grupo_id) {
		GruposDAO.denegarReservaGrupo(grupo_id);
	}
	public void pendienteReservaGrupo(int grupo_id) {
		GruposDAO.pendienteReservaGrupo(grupo_id);
	}
	public String cambiarEstado(GruposModel grupoModel) {
		GruposBean grupo=GruposDAO.reservasPorGrupoID(GruposModel.grupo_id);
		grupo.setEstado(GruposModel.estado);
	    GruposDAO.cambiarEstado(GruposModel.grupo_id, GruposModel.estado);
		return GruposModel.estado;
	}


	

}
