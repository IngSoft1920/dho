package ingsoft1920.dho.Model;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

import ingsoft1920.dho.DAO.IncidenciaDAO;
import ingsoft1920.dho.DAO.ServicioDAO;
import ingsoft1920.dho.DAO.TareaDAO;
import ingsoft1920.dho.bean.IncidenciaBean;
import ingsoft1920.dho.bean.ServicioBean;
import ingsoft1920.dho.bean.TareaBean;

public class ReservasModel {
	
	private int estancia_id;
	private int id_ServicoHotel;
	private int cliente_id;
	private String lugar;
	private Date fecha_servicio;
	private Time hora;
	private String tipo_servicio;
	private String platos;
	private String items;
	private Time hora_salida;
	private int precio;
	
	

	public ReservasModel() {

	}

	
	//FALTA METER EL PRECIO 
	
	public ReservasModel(ServicioBean servicioBean) {
		
		this.cliente_id=servicioBean.getCliente_id();
		this.estancia_id=servicioBean.getEstancia_id();
		this.fecha_servicio=servicioBean.getFecha_servicio();
		this.hora=servicioBean.getHora();
		this.hora_salida=servicioBean.getHora_salida();
		this.id_ServicoHotel=servicioBean.getId_ServicoHotel();
		this.items=servicioBean.getItems();
		this.lugar=servicioBean.getLugar();
		this.platos=servicioBean.getPlatos();
		this.tipo_servicio=servicioBean.getTipo_servicio();
		
		
	}

	public List<ServicioBean> getReservas() {

		List<ServicioBean> lista = ServicioDAO.getServiciosReservados();

		return lista;
	}
	public void nuevoServicio(ReservasModel reservasModel) {
		
		
		ServicioDAO.añadirServicio(new ServicioBean(0, estancia_id, id_ServicoHotel,
				cliente_id, lugar, fecha_servicio, hora, tipo_servicio, platos, items, hora_salida, precio));
			
		}


}
