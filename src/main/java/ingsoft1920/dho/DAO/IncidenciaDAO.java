package ingsoft1920.dho.DAO;

import ingsoft1920.dho.bean.IncidenciaBean;

public class IncidenciaDAO {

	

		
		
		
	
	
	
	public static void añadirIncidencia(IncidenciaBean incidecnia) {
		//insert sql que añade a la tabla incidencia la incidencia pasada por parametro
		//y aumentamos el contador de las incidencias guardadas
		IncidenciaBean.ContInc++;
	}
}
