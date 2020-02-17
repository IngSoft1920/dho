package baseDatos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import baseDatos.entidades.Habitaciones;

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
}
