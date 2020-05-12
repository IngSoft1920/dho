package ingsoft1920.dho.DAO;

import ingsoft1920.dho.controller.Conexion;

public class ProductosDAO {
	public static Conexion conexion = new Conexion();
	
	public ProductosDAO(Conexion conexion) {
		this.conexion = conexion;
	}

}
