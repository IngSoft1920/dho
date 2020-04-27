package ingsoft1920.dho.Model;

import java.time.LocalDate;
import java.util.List;

import ingsoft1920.dho.DAO.EstanciaDAO;
import ingsoft1920.dho.DAO.IncidenciaDAO;
import ingsoft1920.dho.DAO.ServicioDAO;
import ingsoft1920.dho.bean.EstanciaBean;
import ingsoft1920.dho.bean.IncidenciaBean;
import ingsoft1920.dho.bean.ServicioBean;

public class CheckinModel {

	private int habitacion_id; 
	private String fecha;
	public CheckinModel() {
	

	}
	

public CheckinModel(EstanciaBean estanciaBean) {
	this.habitacion_id=estanciaBean.getHabitacion_id();
}



public void cambiarEstadoEstancia(int id_estancia) {
	EstanciaDAO.checkInPorEstancia_id(id_estancia);
	
}
public void getEstancia(CheckinModel checkin) {
	
	EstanciaDAO.getEstanciaFecha(checkin.habitacion_id, checkin.fecha);
}
public List<ServicioBean> getClienteHabitacionFecha(int habitacion_id, String fecha){
	
	List<ServicioBean> lista=ServicioDAO.getClienteHabitacionFecha(habitacion_id, fecha);

	return lista;
}


}
