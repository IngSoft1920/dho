package ingsoft1920.dho.DAO;

import ingsoft1920.dho.bean.HabitacionBean;

public class HabitacionDAO {

	public static HabitacionBean getHabitacionPorId(int id_cliente) {
		
		//aqui se deberia hacer la consulta en la base de datos y conseguir la respuesta
		//la respuesta es unicamente de prueba para ver si funciona
		return new HabitacionBean(1,0,1);
		
	}
	
	
}
