package ingsoft1920.dho.Model;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

import ingsoft1920.dho.bean.EstanciaBean;
import ingsoft1920.dho.bean.ServicioBean;
import ingsoft1920.dho.DAO.EstanciaDAO;
import ingsoft1920.dho.DAO.ServicioDAO;

public class EstanciasModel {
	private int estancia_id; 
	private int habitacion_id; 
	private int cliente_id; 
	private int hotel_id; 
	private Date fecha_inicio; 
	private Date fecha_fin; 
	//check in, check out o ninguno
	private String estado;
	private int importe;
	private int tipo_hab_id;
	public EstanciasModel() {
		
	}
	
public EstanciasModel(EstanciaBean estanciaBean) {
		
		this.cliente_id=estanciaBean.getCliente_id();
		this.estancia_id=estanciaBean.getEstancia_id();
		this.habitacion_id=estanciaBean.getHabitacion_id();
		this.hotel_id=estanciaBean.getHotel_id();
		this.fecha_inicio=estanciaBean.getFecha_inicio();
		this.fecha_fin=estanciaBean.getFecha_fin();
		this.estado=estanciaBean.getEstado();
		this.importe=estanciaBean.getImporte();
		this.tipo_hab_id=estanciaBean.getTipo_hab_id();
		
		
	}

public void nuevoEstancia(EstanciasModel estanciasModel) {
	
	EstanciaDAO.anadirEstancia(new EstanciaBean(estancia_id, habitacion_id, cliente_id, hotel_id, fecha_inicio, 
			fecha_fin, estado, importe, tipo_hab_id));
	
		
	}


}


