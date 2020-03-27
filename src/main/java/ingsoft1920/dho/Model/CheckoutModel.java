package ingsoft1920.dho.Model;

import java.util.List;

import ingsoft1920.dho.DAO.EstanciaDAO;
import ingsoft1920.dho.bean.EstanciaBean;

public class CheckoutModel {

	
	private int habitacion_id; 

	public CheckoutModel() {
	

	}
	

public CheckoutModel(EstanciaBean estanciaBean) {
	this.habitacion_id=estanciaBean.getHabitacion_id();
}



public void cambiarEstadoEstancia(CheckoutModel checkout) {
	EstanciaDAO.checkOut(checkout.habitacion_id);
	
	
}
}
