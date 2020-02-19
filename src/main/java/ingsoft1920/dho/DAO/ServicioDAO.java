
package ingsoft1920.dho.DAO;

import ingsoft1920.dho.bean.IncidenciaBean;
import ingsoft1920.dho.bean.ServicioBean;
import ingsoft1920.dho.bean.TareaBean;

public class ServicioDAO {
	
	public static int añadirServicio(ServicioBean servicio) {
		return servicio.getServicios_id();
	}

	public static int recogerServicio(ServicioBean servicio) {
		
		//servicio.setServicios_id(1);
		//servicio.setEstancia_id(pedirEstancia());
		return añadirServicio(servicio);
	}

}
