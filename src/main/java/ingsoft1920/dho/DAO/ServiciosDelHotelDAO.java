package ingsoft1920.dho.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ingsoft1920.dho.bean.ServiciosDelHotelBean;
import ingsoft1920.dho.controller.Conexion;

public class ServiciosDelHotelDAO {
	private static Conexion conexion; 
	
	//aqui iria la consulta que devuelve todas las filas de la tabla
	//como una lista con el contenido
	public static ArrayList<ServiciosDelHotelBean> darServiciosHotel() {

		
		if (conexion.getConexion()== null)
			conexion.conectar();
		
		ArrayList<ServiciosDelHotelBean> res = new ArrayList<ServiciosDelHotelBean>();
		
		java.sql.Statement stmt = null; 
		ResultSet rs = null; 
		try { 
			stmt = conexion.getConexion().createStatement() ;
			rs =  stmt.executeQuery("SELECT * FROM ServiciosHotel");
			while(rs.next()){
				res.add(new ServiciosDelHotelBean (rs.getInt("servicioHotel_id"), 
						rs.getTime("horaInicioServicio"), 
						rs.getTime("horaFinServicio"),rs.getInt("disponibilidadTotal"))); 
			}

		} 
		catch (SQLException ex){ 
			System.out.println("SQLException: " + ex.getMessage());
		} finally { // it is a good idea to release resources in a finally block 
			if (rs != null) { try { rs.close(); } catch (SQLException sqlEx) { } rs = null; } 
			if (stmt != null) { try {  stmt.close(); } catch (SQLException sqlEx) { }  stmt = null; } 
		}

		return res;
	}

	
	
	
}
