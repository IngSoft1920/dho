package ingsoft1920.dho.Model;

import java.util.List;

import ingsoft1920.dho.DAO.EstanciaDAO;
import ingsoft1920.dho.bean.EstanciaBean;

public class CheckinModel {

	private int habitacion_id; 

	public CheckinModel() {
	

	}
	

public CheckinModel(EstanciaBean estanciaBean) {
	this.habitacion_id=estanciaBean.getHabitacion_id();
}



public void cambiarEstadoEstancia(CheckinModel checkin) {
	EstanciaDAO.checkIn(checkin.habitacion_id);
	
	
}

}
