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
	
	
	public static int ConseguirIDHotelDadoNombre(String nombre_hotel) {
		//falta hacer la consulta
		return 5;
		
	}
	
	
	
	public static String ConseguirNombreHotelDadoID(int id_hotel) {
		String res=null;
		if (conexion.getConexion()== null) 
			conexion.conectar(); 
		
		java.sql.Statement stmt = null;  
		ResultSet rs = null;
		try {
			stmt=conexion.getConexion().createStatement();
			rs=stmt.executeQuery("SELECT nombre FROM Hotel WHERE hotel_id= "+id_hotel);
			
			if(rs.next()) {
				res=rs.getString("nombre");
			}
					
		}catch (SQLException ex){ 
			System.out.println("SQLException: " + ex.getMessage());
		} finally { // it is a good idea to release resources in a finally block 
			if (rs != null) { try { rs.close(); } catch (SQLException sqlEx) { } rs = null; } 
			if (stmt != null) { try {  stmt.close(); } catch (SQLException sqlEx) { }  stmt = null; } 
		}
		conexion.desconectar();
		
		return res;
	}
	
	
	
	
//Dado un HotelBean lo mete en la base de datos
	
	public static void anadirHotel(HotelBean hotel) {
		
				
			if (conexion.getConexion()== null) 
				conexion.conectar(); 
			
			PreparedStatement stm=null; 
			try {  
				
				
					
					stm=conexion.getConexion().prepareStatement("INSERT INTO Hotel values (?,?,?,?,?,?,?)"); 
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
	
	//consulta que nos devuleve el numero de hoteles guardados
	public static int devolverElNumeroDeHoteles() {
		
		int res=0;
		if (conexion.getConexion()== null) 
			conexion.conectar(); 
		
		java.sql.Statement stmt = null;  
		ResultSet rs = null;
		try {
			stmt=conexion.getConexion().createStatement();
			rs=stmt.executeQuery("SELECT MAX(hotel_id) AS n FROM Hotel");
			if(rs.next()) {
				res=rs.getInt("n");
			}
		}catch (SQLException ex){ 
			System.out.println("SQLException: " + ex.getMessage());
		} finally { // it is a good idea to release resources in a finally block 
			if (rs != null) { try { rs.close(); } catch (SQLException sqlEx) { } rs = null; } 
			if (stmt != null) { try {  stmt.close(); } catch (SQLException sqlEx) { }  stmt = null; } 
		}
		conexion.desconectar();
		return res;
	}
	
}
