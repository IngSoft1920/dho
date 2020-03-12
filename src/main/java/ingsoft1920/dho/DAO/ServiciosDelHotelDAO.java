package ingsoft1920.dho.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import ingsoft1920.dho.bean.HotelBean;
import ingsoft1920.dho.bean.ServicioBean;
import ingsoft1920.dho.bean.ServiciosDelHotelBean;
import ingsoft1920.dho.controller.Conexion;

public class ServiciosDelHotelDAO {
	private static Conexion conexion=new Conexion(); 
	
	public ServiciosDelHotelDAO(Conexion conexion) {
		this.conexion=conexion;
	}

	
	

		
	
	
	
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
						rs.getTime("horaFinServicio"),rs.getInt("disponibilidadTotal"), rs.getInt("hotel_id"), rs.getString("nombre"), rs.getInt("importe"))); 
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

	//Dado el id de un servicio del hotel, y una hora de inicio y una de fin, se asigna el horario de los servicios del hotel
	public static void asignacionHorarioServicios(int servicioHotel_id,Time hora_inicio,Time hora_fin) {
		if (conexion==null) 
			conexion.conectar();
		PreparedStatement stmt= null;
		
		try {
			stmt=conexion.getConexion().prepareStatement("UPDATE ServiciosHotel\r\n" + 
					"SET horaInicioServicio = ?, horaFinServicio=?\r\n" + 
					"WHERE servicioHotel_id=?");
			stmt.setTime(1, hora_inicio);
			stmt.setTime(2, hora_fin);
			stmt.setInt(3, servicioHotel_id);
			stmt.executeUpdate();
		}catch (SQLException ex){ 
			System.out.println("SQLException: " + ex.getMessage());
		} finally { // it is a good idea to release resources in a finally block 
			
			if (stmt != null) { try {  stmt.close(); } catch (SQLException sqlEx) { }  stmt = null; } 
		}
		
	}
	//Dado el id de un servicio del hotel, una fecha y una hora devuelve cuantas plazas libres hay de ese servicio
	public static int plazasLibresServicioHotel(int servicioHotel_id, String dia, String mes, String anio, int hora) {
		int res=0;
		int cap=0;
		ArrayList<ServiciosDelHotelBean> serviciosHotel = new ArrayList<ServiciosDelHotelBean>();
		ArrayList<ServicioBean> serv = new ArrayList<ServicioBean>();
		ArrayList<ServicioBean> aux = new ArrayList<ServicioBean>();
		
		aux= ServicioDAO.getServiciosPorFecha(dia,mes,anio, hora);
		System.out.println(aux.size());
		for(int i=0; i<aux.size(); i++) {
			if(aux.get(i).getId_ServicoHotel()== servicioHotel_id) {
				serv.add(aux.get(i));
			}
		}
			if (conexion.getConexion()== null)
				conexion.conectar();
			
						
			java.sql.Statement stmt = null; 
			ResultSet rs = null; 
			try { 
				stmt=conexion.getConexion().createStatement();
				rs=stmt.executeQuery("SELECT disponibilidadTotal FROM ServiciosHotel WHERE servicioHotel_id= "+servicioHotel_id);
				if(rs.next()) {
					cap=rs.getInt("disponibilidadTotal");
					
				}
				
				}catch (SQLException ex){ 
					System.out.println("SQLException: " + ex.getMessage());
				} finally { // it is a good idea to release resources in a finally block 
					if (rs != null) { try { rs.close(); } catch (SQLException sqlEx) { } rs = null; } 
					if (stmt != null) { try {  stmt.close(); } catch (SQLException sqlEx) { }  stmt = null; } 
				}
			if(serv.isEmpty()) {
				res=cap;
			}
			else {
			res=cap - serv.size();
			}
		
		System.out.println(cap);
		return res;
	}
	//añade un servicioHotel a la base de datos
	public static void anadirServicioDelHotel(ServiciosDelHotelBean serv) {
		
		//consulta de añadir un servicio a la tabla servicios 		
		if (conexion.getConexion()== null) 
			conexion.conectar(); 
		
		PreparedStatement stm=null; 
		try {  
			
			
				
				stm=conexion.getConexion().prepareStatement("INSERT INTO ServiciosHotel values (?,?,?,?,?,?,?)"); 
				stm.setInt(1,serv.getId_ServicioHotel());
				stm.setTime(2, serv.getHoraInicioServicio());
				stm.setTime(3, serv.getHoraFinServicio());
				stm.setInt(4, serv.getDisponibilidadTotal());
				stm.setInt(5, serv.getHotel_id());
				stm.setString(6, serv.getNombre());
				stm.setInt(7, serv.getImporte());
				stm.executeUpdate(); 
			} 
 
		
		catch (SQLException ex){  
			System.out.println("SQLException: " + ex.getMessage()); 
		} finally { // it is a good idea to release resources in a finally block  
			if (stm != null) { try {  stm.close(); } catch (SQLException sqlEx) { }  stm = null; }  
		} 
 
	
}
	//Dado el nombre de un hotel devuelve todos sus servicios
	public static ArrayList<ServiciosDelHotelBean> serviciosHotelPorNombre(String nombre){
		ArrayList<ServiciosDelHotelBean> res = new ArrayList<ServiciosDelHotelBean>();
		int hotel_id=-1;
		if (conexion.getConexion()== null) 
			conexion.conectar(); 
		java.sql.Statement stmt = null; 
		ResultSet rs = null;
		
		java.sql.Statement stmt2 = null; 
		ResultSet rs2 = null;
		try {
			stmt=conexion.getConexion().createStatement();
			rs=stmt.executeQuery("SELECT hotel_id FROM Hotel WHERE nombre = \""+nombre + "\"");
			
			if(rs.next()) {
				hotel_id= rs.getInt("hotel_id");
			}
			
			if(hotel_id != -1) {
				stmt2=conexion.getConexion().createStatement();
				rs2=stmt2.executeQuery("SELECT * FROM ServiciosHotel WHERE hotel_id= "+ hotel_id);
				
				while(rs2.next()) {
					res.add(new ServiciosDelHotelBean(rs2.getInt("servicioHotel_id"), rs2.getTime("horaInicioServicio"), 
							rs2.getTime("horaFinServicio"), rs2.getInt("disponibilidadTotal"), rs2.getInt("hotel_id"), 
							rs2.getString("nombre"), rs.getInt("importe")));
				}}}catch (SQLException ex){  
					System.out.println("SQLException: " + ex.getMessage()); 
				} finally { // it is a good idea to release resources in a finally block  
					if (rs != null) { try { rs.close(); } catch (SQLException sqlEx) { } rs = null; } 
					if (stmt != null) { try {  stmt.close(); } catch (SQLException sqlEx) { }  stmt = null; }
					if (rs2 != null) { try { rs2.close(); } catch (SQLException sqlEx) { } rs2 = null; } 
					if (stmt2 != null) { try {  stmt2.close(); } catch (SQLException sqlEx) { }  stmt2 = null; }  
				} 		
		
		
		return res;
		
	}
	
	
	//suponemos que nos pasan un id de servicio correcto ya que les hemos pasado ya cuales tenemos
	public static String[] horasServicio(int id_servicioHotel) {
		
		String[] res = new String[2];
		
		if (conexion.getConexion()== null) 
			conexion.conectar(); 
		java.sql.Statement stmt = null; 
		ResultSet rs = null;
		
		try {

				stmt=conexion.getConexion().createStatement();
				rs=stmt.executeQuery("SELECT * FROM ServiciosHotel WHERE id_ServicioHotel= "+ id_servicioHotel);
				
				while(rs.next()) {
					res[0]=rs.getTime("horaInicioServicio").toString(); 
					res[1]=rs.getTime("horaFinServicio").toString();
				}}catch (SQLException ex){  
					System.out.println("SQLException: " + ex.getMessage()); 
				} finally { // it is a good idea to release resources in a finally block  
					if (rs != null) { try { rs.close(); } catch (SQLException sqlEx) { } rs = null; } 
					if (stmt != null) { try {  stmt.close(); } catch (SQLException sqlEx) { }  stmt = null; } 
				} 		
		
		
		return res;
		
	}
	



}

	
	

