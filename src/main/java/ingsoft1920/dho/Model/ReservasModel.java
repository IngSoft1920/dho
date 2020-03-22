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
	private int servicios_id;
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
	int precio;
	private int reserva_id;
	

	public ReservasModel() {

	}

	public ReservasModel(ServicioBean servicioBean) {
		this.reserva_id = servicioBean.getServicios_id();
	}

	public List<ServicioBean> getReservas() {

		List<ServicioBean> lista = ServicioDAO.getServiciosReservados();

		return lista;
	}
	public void nuevoServicio(ReservasModel reservasModel) {
		
		ServicioBean nuevoServicio =new ServicioBean();
		
		nuevoServicio.setCliente_id(cliente_id);
		nuevoServicio.setEstancia_id(estancia_id);
		nuevoServicio.setFecha_servicio(fecha_servicio);
		nuevoServicio.setHora_salida(hora_salida);
		nuevoServicio.setHora(hora);
		nuevoServicio.setId_ServicoHotel(id_ServicoHotel);
		nuevoServicio.setItems(items);
		nuevoServicio.setLugar(lugar);
		nuevoServicio.setPlatos(platos);
		nuevoServicio.setServicios_id(servicios_id);
		nuevoServicio.setTipo_servicio(tipo_servicio);

		
		ServicioDAO.añadirServicio(nuevoServicio);
			
		}


}
