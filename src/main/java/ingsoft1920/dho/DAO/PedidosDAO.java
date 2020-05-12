package ingsoft1920.dho.DAO;

import ingsoft1920.dho.controller.Conexion;

public class PedidosDAO {
	private static Conexion conexion = new Conexion();
	
	public PedidosDAO(Conexion conexion) {
		this.conexion=conexion;
	}

}


