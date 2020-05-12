package ingsoft1920.dho.DAO;

import ingsoft1920.dho.controller.Conexion;

public class ProveedoresDAO {
	private static Conexion conexion= new Conexion();
	
	public ProveedoresDAO(Conexion conexion) {
		this.conexion=conexion;
	}

}


