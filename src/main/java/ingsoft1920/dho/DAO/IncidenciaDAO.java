package ingsoft1920.dho.DAO; 
 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ingsoft1920.dho.bean.HabitacionBean;
import ingsoft1920.dho.bean.IncidenciaBean;
import ingsoft1920.dho.controller.Conexion; 
 
public class IncidenciaDAO { 
 
	
	private static Conexion conexion=new Conexion();
	 
 
	public IncidenciaDAO(Conexion conexion) {
	 this.conexion=conexion;
 
	}
		 
	//metodo que nos devuelve el Bean de la incidencia dado su id_incidencia
	public static IncidenciaBean getIncidenciaDadoId(int id_incidencia) {
		return null;
		
	}
	
 
	/*metodo que nos consigue las incidencias que no han sido asigandas a ningun empleado* 
	 */
 
	public static ArrayList<IncidenciaBean> getIncidenciasSinAsignar(){
		if (conexion.getConexion()== null)
			conexion.conectar();
		
		ArrayList<IncidenciaBean>res=new ArrayList<IncidenciaBean>();
		
		java.sql.Statement stmt1 = null; 
		ResultSet rs1 = null;
		try { 
			stmt1 = conexion.getConexion().createStatement() ;
			rs1 =  stmt1.executeQuery("SELECT *\r\n" + 
					"FROM Incidencia \r\n" + 
					"WHERE incidencia_id NOT IN (SELECT incidencia_id FROM Tarea);");
			while(rs1.next()){
				res.add(new IncidenciaBean(rs1.getInt("incidencia_id"),rs1.getString("tipo_incidencia"),
						rs1.getString("descripcion"),rs1.getString("lugar_incidencia"),
						rs1.getDate("fecha_incidencia")));
				}
		} 
		catch (SQLException ex){ 
			System.out.println("SQLException: " + ex.getMessage());
		} finally { // it is a good idea to release resources in a finally block 
			if (rs1 != null) { try { rs1.close(); } catch (SQLException sqlEx) { } rs1 = null; }
			if (stmt1 != null) { try {  stmt1.close(); } catch (SQLException sqlEx) { }  stmt1 = null; }
		}
		conexion.desconectar();
		return res;
	}
 
	/*metodo que nos consigue las incidencias que han sido asigandas a algun empleado* 
	 */
	public static List<IncidenciaBean> getIncidenciasAsignadas(){
		//hay que meter la consulta
		return null;
	}
 
 
 
 
	
	
	/*El ojetivo de esta consulta es que devuelva el id_incidencia en caso de existir
	 * una con las siguientes caracteristica:
	 * tipo_Incidencia=='COCINA'
	 * y el lugar que pasa como parametro
	 * Si no existe, se devuelve -1;
	 * 
	 */
	public static int BuscarIncidenciaPor(String lugar) {
		if (conexion.getConexion()== null) 
			conexion.conectar(); 
		 
		int res = -1; 
		 
		java.sql.Statement stmt = null;  
		ResultSet rs = null;  
		try {  
			stmt = conexion.getConexion().createStatement() ; 
			rs =  stmt.executeQuery("SELECT incidencia_id\r\n" + 
					"FROM Incidencia\r\n" + 
					"WHERE tipo_incidencia = \"COCINA\" AND lugar_incidencia=\""+lugar+"\""); 
			if (rs.next()){ 
				res = rs.getInt("incidencia_id");  
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
		 
		 
	 
	 
	 
	public static void añadirIncidencia(IncidenciaBean incidencia) { 
		//insert sql que añade a la tabla incidencia la incidencia pasada por parametro 
		//y aumentamos el contador de las incidencias guardadas 		
		if (conexion.getConexion()== null) 
			conexion.conectar(); 
		 
		int incidencia_id=-1; 
		 
		java.sql.Statement stmt1 = null;  
		ResultSet rs1 = null; 
		PreparedStatement stm=null; 
		try {  
			//Consulta para saber el id de la nueva incidencia a crear 
			stmt1 = conexion.getConexion().createStatement() ; 
			rs1 =  stmt1.executeQuery("SELECT COUNT(incidencia_id)\r\n" + 
					"FROM Incidencia;"); 
			if (rs1.next()){ 
				incidencia_id=rs1.getInt("COUNT(incidencia_id)")+1;//id de la nueva tarea 
				stm=conexion.getConexion().prepareStatement("INSERT INTO Incidencia values (?,?,?,?,?)"); 
				stm.setInt(1,incidencia_id); 
				stm.setString(2, incidencia.getDescripcion()); 
				stm.setString(3, incidencia.getLugar()); 
				stm.setDate(4, incidencia.getFecha()); 
				stm.setString(5,incidencia.getTipo_incidencia()); 
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
