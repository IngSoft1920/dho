package ingsoft1920.dho.Model;

import java.util.List;

import ingsoft1920.dho.DAO.EstanciaDAO;
import ingsoft1920.dho.bean.EstanciaBean;

public class CheckinModel {

	private int estancia_id; 

	public CheckinModel() {
	

	}
	

public CheckinModel(EstanciaBean estanciaBean) {
	this.estancia_id=estanciaBean.getEstancia_id();
}


public List<EstanciaBean> getEstanciasSinHacerCheckIn(){
	
	List<EstanciaBean> lista=EstanciaDAO.getReservas();
	
	return lista;
}

public List<EstanciaBean> getEstanciasConCheckIn(){
	
	List<EstanciaBean> lista=EstanciaDAO.getCheckIn();
	
	return lista;
}
	

public void cambiarEstadoEstancia(CheckinModel checkin) {
	EstanciaDAO.checkIn(checkin.estancia_id);
	
	
}

}
