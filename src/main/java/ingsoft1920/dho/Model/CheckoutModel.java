package ingsoft1920.dho.Model;

import java.util.List;

import ingsoft1920.dho.DAO.EstanciaDAO;
import ingsoft1920.dho.DAO.ServicioDAO;
import ingsoft1920.dho.bean.EstanciaBean;
import ingsoft1920.dho.bean.ServicioBean;

public class CheckoutModel {

	private int habitacion_id; 
	private String fecha;
	

	public CheckoutModel() {
	

	}
	
public void cambiarEstadoEstancia(int id_estancia) { 
		EstanciaDAO.checkOutPorEstancia_id(id_estancia);
}
	

public CheckoutModel(EstanciaBean estanciaBean) {
	this.habitacion_id=estanciaBean.getHabitacion_id();
}

public void getEstancia(CheckoutModel checkout) {
	
	EstanciaDAO.getEstanciaFecha(checkout.habitacion_id, checkout.fecha);
}
public List<ServicioBean> getClienteHabitacionFecha(int habitacion_id, String fecha){
	
	List<ServicioBean> lista=ServicioDAO.getClienteHabitacionFecha(habitacion_id, fecha);

	return lista;
}
}
