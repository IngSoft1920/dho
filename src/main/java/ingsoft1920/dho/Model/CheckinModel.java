package ingsoft1920.dho.Model;

import java.util.List;

import ingsoft1920.dho.DAO.EstanciaDao;
import ingsoft1920.dho.bean.EstanciaBean;

public class CheckinModel {

	private int estancia_id; 

	public CheckinModel() {
	

	}
	

public CheckinModel(EstanciaBean estanciaBean) {
	this.estancia_id=estanciaBean.getEstancia_id();
}


public List<EstanciaBean> getEstancias(){
	
	List<EstanciaBean> lista=EstanciaDao.geEstanciaBeans();
	
	return lista;
}
	

public void cambiarEstadoEstancia(CheckinModel checkin) {
	EstanciaDao.cambiarEstadoEstancia(checkin.estancia_id);
	
	
}

}
