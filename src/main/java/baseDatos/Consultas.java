package baseDatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ingsoft1920.dho.Model.Cobros;
import ingsoft1920.dho.Model.Habitaciones;
import ingsoft1920.dho.controller.Conexion;

public class Consultas {
	private static Conexion conexion=new Conexion();
	public Conexion getConexion() {
		return this.conexion;
	}
	
	//Devolver una habitacion por su id
	public static Habitaciones getHabitacionById (int habitacion_id){
		if (conexion.getConexion()== null)
			conexion.conectar();
		
		Habitaciones res = null;
		
		java.sql.Statement stmt = null; 
		ResultSet rs = null; 
		try { 
			stmt = conexion.getConexion().createStatement() ;
			rs =  stmt.executeQuery("SELECT * FROM habitaciones WHERE habitacion_id = "+habitacion_id);
			if (rs.next()){
				res = new Habitaciones (rs.getInt("habitacion_id"), 
						rs.getString("tipo_habitacion"), 
						rs.getInt("hotel_id")); 

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

	//Devolver las habitaciones de un hotel
	public static ArrayList<Habitaciones> getHabitacionByHotel (int hotel_id){
		if (conexion.getConexion()== null)
			conexion.conectar();
		
		ArrayList<Habitaciones> res = new ArrayList<Habitaciones>();
		
		java.sql.Statement stmt = null; 
		ResultSet rs = null; 
		try { 
			stmt = conexion.getConexion().createStatement() ;
			rs =  stmt.executeQuery("SELECT * FROM habitaciones WHERE hotel_id = "+hotel_id);
			while(rs.next()){
				res.add(new Habitaciones (rs.getInt("habitacion_id"), 
						rs.getString("tipo_habitacion"), 
						rs.getInt("hotel_id"))); 

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
	
	//Numero de habitacion dado el id del cliente
	public static int getHabitacionByCliente (int cliente_id){
		if (conexion.getConexion()== null)
			conexion.conectar();
		
		int res = -1;
		
		java.sql.Statement stmt = null; 
		ResultSet rs = null; 
		try { 
			stmt = conexion.getConexion().createStatement() ;
			rs =  stmt.executeQuery("SELECT (habitacion_id) FROM estancia WHERE cliente_id = "+cliente_id);
			if (rs.next()){
				res = rs.getInt("habitacion_id");

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
	
//Dado un empleado_id asignarle una tarea y enviar el id de la tarea
//Devuelve el id de la tarea creada o -1 si no se puede crer una tarea
//De momento asigna empleados sin tener en cuenta su trabajo
	public static int asignarTarea(int empleado_id) {
		if (conexion.getConexion()== null)
			conexion.conectar();
		
		int tarea_id=-1;
		
		java.sql.Statement stmt1 = null; 
		java.sql.Statement stmt2 = null; 
		ResultSet rs1 = null;
		ResultSet rs2=null;
		PreparedStatement stm=null;
		//Ver si hay incidencias sin asignar.Si la hay creamos una nueva tarea y se la asignamos al empleado
		//Sino, no hacemos nada
		try { 
			stmt1 = conexion.getConexion().createStatement() ;
			rs1 =  stmt1.executeQuery("SELECT *\r\n" + 
					"FROM incidencia \r\n" + 
					"WHERE incidencia_id NOT IN (SELECT incidencia_id FROM tarea);");
			if (rs1.next()){//Creamos tarea
				stmt2 = conexion.getConexion().createStatement() ;;
				rs2 =  stmt2.executeQuery("SELECT COUNT(tarea_id)\r\n" + 
						"FROM tarea;");
				if(rs2.next()) {
				tarea_id=rs2.getInt("COUNT(tarea_id)")+1;//id de la nueva tarea
				stm=conexion.getConexion().prepareStatement("INSERT INTO tarea values (?,?,?,?,?,?,?,?)");
				stm.setInt(1,tarea_id);
				stm.setInt(2, rs1.getInt("incidencia_id"));
				stm.setInt(3, empleado_id);
				stm.setString(4, rs1.getString("descripcion"));
				stm.setString(5, rs1.getString("lugar_incidencia"));
				stm.setBoolean(6, false);
				stm.setDate(7, rs1.getDate("fecha_incidencia"));
				stm.setString(8, rs1.getString("tipo_incidencia"));
				stm.executeUpdate();
				}
				else
					System.out.println("ha ocurrido un error");
			}

		} 
		catch (SQLException ex){ 
			System.out.println("SQLException: " + ex.getMessage());
		} finally { // it is a good idea to release resources in a finally block 
			if (rs1 != null) { try { rs1.close(); } catch (SQLException sqlEx) { } rs1 = null; }
			if (rs2 != null) { try { rs2.close(); } catch (SQLException sqlEx) { } rs2 = null; } 
			if (stmt1 != null) { try {  stmt1.close(); } catch (SQLException sqlEx) { }  stmt1 = null; }
			if (stmt2 != null) { try {  stmt2.close(); } catch (SQLException sqlEx) { }  stmt2 = null; }
			if (stm != null) { try {  stm.close(); } catch (SQLException sqlEx) { }  stm = null; } 
		}

		return tarea_id;
	}
	//Dado habitacion_id devolver el tipo de la habitacion
	// Si la habitacion no existe devuelve null
	public static String getTipoHabitacion(int habitacion_id) {
		String res=null;
		if (conexion==null) {
			conexion.conectar();
		}
		java.sql.Statement stmt = null; 
		ResultSet rs = null; 
		try { 
			stmt = conexion.getConexion().createStatement() ;
			rs =  stmt.executeQuery("SELECT tipo_habitacion FROM habitaciones WHERE habitacion_id = "+habitacion_id);
			if (rs.next()){
				res = rs.getString("tipo_habitacion");

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
	//Dado el id de un cobro ver si esta pagado o no
		//Devuelve false si no esta pagado y true si lo esta
		
		public static boolean estaCobroPagado(int cobros_id) {
			boolean res=false;
			
			if (conexion==null) 
				conexion.conectar();
			
			java.sql.Statement stmt = null; 
			ResultSet rs = null; 
			try {
				stmt=conexion.getConexion().createStatement();
				rs= stmt.executeQuery("SELECT pagado FROM Cobros WHERE cobros_id= "+cobros_id);
				if(rs.next()) {
					res=rs.getBoolean("pagado");
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
		//Dado el id de una factura ver si esta pagada o no
			//Devuelve false si no esta pagado y true si lo esta
			
			public static boolean estaFacturaPagada(int factura_id) {
				boolean res=false;
				
				if (conexion==null) 
					conexion.conectar();
				
				java.sql.Statement stmt = null; 
				ResultSet rs = null; 
				try {
					stmt=conexion.getConexion().createStatement();
					rs= stmt.executeQuery("SELECT pagado FROM Factura WHERE factura_id= "+factura_id);
					if(rs.next()) {
						res=rs.getBoolean("pagado");
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
			//Dado el id de un cliente ver todos los cobros a su nombre y crear la factura 
			//tambien incluye el precio de la estancia
			//Devuelve el id de la factura generada
			
			public static int generarFactura(int cliente_id) {
				int res= -1;
				int precio=0;
				int factura_id=0;
				ArrayList<Cobros> cobros= new ArrayList<Cobros>();
				if (conexion==null) 
					conexion.conectar();
				
				java.sql.Statement stmt= null;
				ResultSet rs= null;
				java.sql.Statement stmt2= null;
				ResultSet rs2= null;
				PreparedStatement stmt3= null;
				ResultSet rs3= null;
				java.sql.Statement stmt4= null;
				ResultSet rs4= null;
				try {
					stmt=conexion.getConexion().createStatement();
					rs=stmt.executeQuery("SELECT * FROM Cobros WHERE cliente_id = "+cliente_id);
					if(rs.next()) {
						if (!estaCobroPagado(rs.getInt("cobros_id"))) {
							precio=precio+ rs.getInt("precio");
						}
					}
					stmt2=conexion.getConexion().createStatement();
					rs2=stmt2.executeQuery("SELECT factura_id, COUNT(factura_id) as n FROM factura");
					if(rs2.next()) {
						factura_id=rs.getInt("n");
					}
					stmt4=conexion.getConexion().createStatement();
					rs4=stmt4.executeQuery("SELECT * FROM estancia WHERE cliente_id="+cliente_id);
					if(rs4.next()) {
						
						
					}
					stmt3=conexion.getConexion().prepareStatement("INSERT INTO factura values (?,?,?,?,?,?,?,?)");
					stmt3.setInt(1,factura_id);
					stmt3.setInt(2, rs1.getInt("incidencia_id"));
					stm.setInt(3, cliente_id);
					stm.setString(4, rs1.getString("descripcion"));
					stm.setString(5, rs1.getString("lugar_incidencia"));
					stmt3.setInt(6, precio);
					stmt3.setBoolean(7, false);
					stmt.setString(8, rs1.getString("tipo_incidencia"));
					stmt3.executeUpdate();
				}
				return res;
			}
}
