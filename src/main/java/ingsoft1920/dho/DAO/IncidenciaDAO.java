package ingsoft1920.dho.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ingsoft1920.dho.bean.IncidenciaBean;
import ingsoft1920.dho.controller.Conexion;
import ingsoft1920.dho.models.Incidencia;

public class IncidenciaDAO {

	private static Conexion conexion;

		
		
		
	
	
	
	public static void añadirIncidencia(Incidencia incidencia) {
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
			rs1 =  stmt1.executeQuery("SELECT COUNT(incidencia_id)\\r\\n\" + \r\n" + 
					"						\"FROM incidencia;");
			if (rs1.next()){
				incidencia_id=rs1.getInt("COUNT(incidencia_id)")+1;//id de la nueva tarea
				stm=conexion.getConexion().prepareStatement("INSERT INTO incidencia values (?,?,?,?,?)");
				stm.setInt(1,incidencia_id);
				stm.setString(2, incidencia.getDescripcion());
				stm.setString(3, incidencia.getLugar_incidencia());
				stm.setDate(4, incidencia.getFecha_incidencia());
				stm.setString(5, incidencia.getTipo_incidencia());
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
		IncidenciaBean.ContInc++;

	}
}