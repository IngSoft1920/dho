package ingsoft1920.dho.Model;

import java.time.LocalDate;
import java.util.List;

import ingsoft1920.dho.DAO.EstanciaDAO;
import ingsoft1920.dho.bean.EstanciaBean;

public class CheckinModel {

	private int habitacion_id; 
	private String fecha;
	public CheckinModel() {
	

	}
	

public CheckinModel(EstanciaBean estanciaBean) {
	this.habitacion_id=estanciaBean.getHabitacion_id();
}



public void cambiarEstadoEstancia(CheckinModel checkin) {
	EstanciaDAO.checkIn(checkin.habitacion_id);
	
	
}
public void getEstancia(CheckinModel checkin) {
	
	EstanciaDAO.getEstanciaFecha(checkin.habitacion_id, checkin.fecha);
}

}
