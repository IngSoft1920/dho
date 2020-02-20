package ingsoft1920.dho.DAO; 
 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ingsoft1920.dho.bean.ServicioBean;
import ingsoft1920.dho.controller.Conexion; 
 
public class ServicioDAO { 
	private static Conexion conexion; 
	 
	public static void recogerServicio(ServicioBean servicio) { 
		//añadir campos que faltan al servicio para poder añadirlo a la base de datos 
		añadirServicio(servicio); 
	} 
	 
	public static void añadirServicio(ServicioBean servicio) { 
		//consulta de añadir un servicio a la tabla servicios 		
		if (conexion.getConexion()== null) 
			conexion.conectar(); 
		 
		int servicio_id=-1; 
		 
		java.sql.Statement stmt1 = null;  
		ResultSet rs1 = null; 
		PreparedStatement stm=null; 
		try {  
			//Consulta para saber el id de la nueva incidencia a crear 
			stmt1 = conexion.getConexion().createStatement() ; 
			rs1 =  stmt1.executeQuery("SELECT COUNT(servicio_id)\\r\\n\" + \r\n" +  
					"						\"FROM Servicios;"); 
			if (rs1.next()){ 
				servicio_id=rs1.getInt("COUNT(incidencia_id)")+1;//id del nuevo servicio 
				stm=conexion.getConexion().prepareStatement("INSERT INTO incidencia values (?,?,?,?,?,?,?,?)"); 
				stm.setInt(1,servicio_id); 
				stm.setInt(2, servicio.getEstancia_id()); 
				stm.setInt(3, servicio.getCliente_id()); 
				stm.setString(4, servicio.getLugar()); 
				stm.setDate(5,servicio.getFecha_servicio()); 
				stm.setTime(6,servicio.getHora()); 
				stm.setString(7,servicio.getTipo_servicio()); 
				stm.setInt(8,servicio.getId_ServicoHotel()); 
				stm.executeUpdate(); 
			} 
 
		}  
		catch (SQLException ex){  
			System.out.println("SQLException: " + ex.getMessage()); 
		} finally { // it is a good idea to release resources in a finally block  
			if (rs1 != null) { try { rs1.close(); } catch (SQLException sqlEx) { } rs1 = null; } 
			if (stmt1 != null) { try {  stmt1.close(); } catch (SQLException sqlEx) { }  stmt1 = null; } 
			if (stm != null) { try {  stm.close(); } catch (SQLException sqlEx) { }  stm = null; }  
		} 
 
	} 
} 