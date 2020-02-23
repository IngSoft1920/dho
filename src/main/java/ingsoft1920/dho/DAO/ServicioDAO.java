package ingsoft1920.dho.DAO; 
 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ingsoft1920.dho.bean.HabitacionBean;
import ingsoft1920.dho.bean.ServicioBean;
import ingsoft1920.dho.controller.Conexion; 
 
public class ServicioDAO { 
	private static Conexion conexion=new Conexion(); 
	 
	public ServicioDAO(Conexion conexion) {
		this.conexion=conexion;
	}

	public static void recogerServicio(ServicioBean servicio) { 
		//añadir campos que faltan al servicio para poder añadirlo a la base de datos 
		//ellos nos van a pasar el lugar, id_servicioHotel, fecha, hora, id_cliente
		//y segun sea una cosa del restaurante o no, nos mandaran los platos y items
		
		//solo queda por añadir el id_estancia, para ello llamamos a una consulta que haga eso
		servicio.setEstancia_id(EstanciaDAO.getEstaciaId(servicio.getCliente_id()));
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
			rs1 =  stmt1.executeQuery("SELECT COUNT(servicios_id)\r\n" + 
					"FROM Servicios;"); 
			if (rs1.next()){ 
				servicio_id=rs1.getInt("COUNT(servicios_id)")+1;//id del nuevo servicio 
				stm=conexion.getConexion().prepareStatement("INSERT INTO Servicios values (?,?,?,?,?,?,?,?,?,?)"); 
				stm.setInt(1,servicio_id); 
				stm.setInt(2, servicio.getEstancia_id()); 
				stm.setInt(3, servicio.getCliente_id()); 
				stm.setString(4, servicio.getLugar()); 
				stm.setDate(5,servicio.getFecha_servicio()); 
				stm.setTime(6,servicio.getHora()); 
				stm.setString(7,servicio.getTipo_servicio()); 
				stm.setInt(8,servicio.getId_ServicoHotel()); 
				stm.setString(9,servicio.getPlatos());
				stm.setString(10,servicio.getItems());
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
	//devuelve el id del ultimo servicio
	public static int idUltimoServicio() {
		
		if (conexion==null) 
			conexion.conectar();
			
		int res=0;
		java.sql.Statement stmt= null; 
		ResultSet rs=null;
		try {
			stmt=conexion.getConexion().createStatement(); 
			rs=stmt.executeQuery("SELECT MAX(servicios_id) AS n FROM Servicios");
			if(rs.next()) {
				res=rs.getInt("n");
			}
		}catch (SQLException ex){ 
			System.out.println("SQLException: " + ex.getMessage());
		} finally { // it is a good idea to release resources in a finally block 
			if (rs != null) { try { rs.close(); } catch (SQLException sqlEx) { } rs = null; } 
			if (stmt != null) { try {  stmt.close(); } catch (SQLException sqlEx) { }  stmt = null; } 
		}
		return res;
	}
	
	//Devolver servicios reservados
	public static ArrayList<ServicioBean> getServiciosReservados (){
		if (conexion.getConexion()== null)
			conexion.conectar();
		
		ArrayList<ServicioBean> res = new ArrayList<ServicioBean>();
		
		java.sql.Statement stmt = null; 
		ResultSet rs = null; 
		try { 
			stmt = conexion.getConexion().createStatement() ;
			rs =  stmt.executeQuery("SELECT * FROM Servicios ");
			while(rs.next()){
				res.add(new ServicioBean (rs.getInt("servicios_id"), 
						rs.getInt("estancia_id"),rs.getInt("servicioHotel_id"),
						rs.getInt("cliente_id"),rs.getString("lugar"),rs.getDate("fecha_factura"),
						rs.getTime("hora"),rs.getString("tipo_servicio"),rs.getString("platos"),
						rs.getString("items"))); 
		} 
		}
		catch (SQLException ex){ 
			System.out.println("SQLException: " + ex.getMessage());
		} finally { // it is a good idea to release resources in a finally block 
			if (rs != null) { try { rs.close(); } catch (SQLException sqlEx) { } rs = null; } 
			if (stmt != null) { try {  stmt.close(); } catch (SQLException sqlEx) { }  stmt = null; } 
		}
		conexion.desconectar();

		return res;
	}
	}