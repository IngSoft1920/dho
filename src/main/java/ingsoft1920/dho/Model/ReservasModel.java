package ingsoft1920.dho.Model;

import java.util.List;

import ingsoft1920.dho.DAO.ServicioDAO;
import ingsoft1920.dho.bean.ServicioBean;

public class ReservasModel {
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

}
