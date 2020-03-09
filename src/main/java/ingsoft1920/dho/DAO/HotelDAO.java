package ingsoft1920.dho.DAO;

import ingsoft1920.dho.controller.Conexion;

public class HotelDAO {
private static Conexion conexion=new Conexion(); 
	
	public HotelDAO(Conexion conexion) {
		this.conexion=conexion;
	}
	

}
