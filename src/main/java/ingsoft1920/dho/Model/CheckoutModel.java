package ingsoft1920.dho.Model;

import java.util.List;

import ingsoft1920.dho.DAO.EstanciaDAO;
import ingsoft1920.dho.bean.EstanciaBean;

public class CheckoutModel {

	
	private int estancia_id; 

	public CheckoutModel() {
	

	}
	

public CheckoutModel(EstanciaBean estanciaBean) {
	this.estancia_id=estanciaBean.getEstancia_id();
}


public List<EstanciaBean> getEstanciasconCheckIn(){
	
	List<EstanciaBean> lista=EstanciaDAO.getCheckIn();
	
	return lista;
}
	

public List<EstanciaBean> getEstanciasconCheckOut(){
	
	List<EstanciaBean> lista=EstanciaDAO.getCheckOut();
	
	return lista;
}

public void cambiarEstadoEstancia(CheckoutModel checkout) {
	EstanciaDAO.checkOut(checkout.estancia_id);
	
	
}
}
