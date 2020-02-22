package ingsoft1920.dho.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import ingsoft1920.dho.bean.EstanciaBean;
import ingsoft1920.dho.controller.Conexion;

public class EstanciaDAO {
	private static Conexion conexion; 
	
	public EstanciaDAO(Conexion conexion) {
		this.conexion=conexion;
	}
	
	//El cliente hace check in
	public void checkIn(int cliente_id) {
		if (conexion.getConexion()== null)
			conexion.conectar();
		PreparedStatement stm=null;
		try { 
				stm=conexion.getConexion().prepareStatement("UPDATE Estancia\r\n" + 
						"SET estado=\"check in\"\r\n" + 
						"WHERE cliente_id = ?");
				stm.setInt(1,cliente_id);
				stm.executeUpdate();
		} 
		catch (SQLException ex){ 
			System.out.println("SQLException: " + ex.getMessage());
		} finally { // it is a good idea to release resources in a finally block 
			if (stm != null) { try {  stm.close(); } catch (SQLException sqlEx) { }  stm = null; } 
		}
		conexion.desconectar();
	}
	
	//El cliente hace check out
	public void checkOut(int cliente_id) {
		if (conexion.getConexion()== null)
			conexion.conectar();
		PreparedStatement stm=null;
		try { 
				stm=conexion.getConexion().prepareStatement("UPDATE Estancia\r\n" + 
						"SET estado=\"check out\"\r\n" + 
						"WHERE cliente_id = ?");
				stm.setInt(1,cliente_id);
				stm.executeUpdate();
		} 
		catch (SQLException ex){ 
			System.out.println("SQLException: " + ex.getMessage());
		} finally { // it is a good idea to release resources in a finally block 
			if (stm != null) { try {  stm.close(); } catch (SQLException sqlEx) { }  stm = null; } 
		}
		conexion.desconectar();
	}

	public static List<EstanciaBean> geEstanciaBeans() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void cambiarEstadoEstancia(int estancia_id) {
		// TODO Auto-generated method stub
		
	}
}
