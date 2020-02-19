package ingsoft1920.dho.DAO; 
 
import ingsoft1920.dho.bean.ServicioBean; 
 
public class ServicioDAO { 
 
	 
	public static void recogerServicio(ServicioBean servicio) { 
		//añadir campos que faltan al servicio para poder añadirlo a la base de datos 
		añadirServicio(servicio); 
	} 
	 
	public static void añadirServicio(ServicioBean servicio) { 
		//consulta de añadir un servicio a la tabla servicios 
	} 
} 