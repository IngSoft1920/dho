package ingsoft1920.dho.DAO; 
 
import ingsoft1920.dho.bean.HabitacionBean;
import ingsoft1920.dho.controller.Conexion;
import java.sql.ResultSet; 
import java.sql.SQLException;
 
public class HabitacionDAO { 
	
	private static Conexion conexion; 
 
	public static HabitacionBean getHabitacionPorId(int id_cliente) { 
		 
		//aqui se deberia hacer la consulta en la base de datos y conseguir la respuesta 
		//la respuesta es unicamente de prueba para ver si funciona 
		if (conexion.getConexion()== null) 
			conexion.conectar(); 
		 
		HabitacionBean res = null; 
		 
		java.sql.Statement stmt = null;  
		ResultSet rs = null;  
		try {  
			stmt = conexion.getConexion().createStatement() ; 
			rs =  stmt.executeQuery("SELECT habitacion_id\r\n" +  
					"FROM estancia\r\n" +  
					"WHERE cliente_id = "+id_cliente); 
			if (rs.next()){ 
				res = new HabitacionBean (rs.getInt("habitacion_id"),rs.getInt("hotel_id"),rs.getString("tipo_habitacion"));  
 
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