package ingsoft1920.dho.DAO;

import ingsoft1920.dho.controller.Conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ingsoft1920.dho.bean.HotelBean;
import ingsoft1920.dho.bean.ServicioBean;

public class HotelDAO {
private static Conexion conexion=new Conexion(); 
	
	public HotelDAO(Conexion conexion) {
		this.conexion=conexion;
	}
	
//Dado un HotelBean lo mete en la base de datos
	
	public static void anadirHotel(HotelBean hotel) {
		
			//consulta de añadir un servicio a la tabla servicios 		
			if (conexion.getConexion()== null) 
				conexion.conectar(); 
			
			PreparedStatement stm=null; 
			try {  
				
				
					
					stm=conexion.getConexion().prepareStatement("INSERT INTO Servicios values (?,?,?,?,?,?,?)"); 
					stm.setInt(1,hotel.getHotel_id()); 
					stm.setString(2, hotel.getNombre()); 
					stm.setString(3, hotel.getDescripcion()); 
					stm.setInt(4, hotel.getEstrellas()); 
					stm.setString(5,hotel.getContinente()); 
					stm.setString(6,hotel.getPais()); 
					stm.setString(7,hotel.getCiudad()); 
					
					stm.executeUpdate(); 
				} 
	 
			
			catch (SQLException ex){  
				System.out.println("SQLException: " + ex.getMessage()); 
			} finally { // it is a good idea to release resources in a finally block  
				if (stm != null) { try {  stm.close(); } catch (SQLException sqlEx) { }  stm = null; }  
			} 
	 
		
	}
}
