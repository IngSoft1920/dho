package ingsoft1920.dho.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import ingsoft1920.dho.controller.Conexion;
import java.util.List;

import ingsoft1920.dho.bean.HabitacionBean;
import ingsoft1920.dho.bean.IncidenciaBean;
import ingsoft1920.dho.bean.TareaBean;

public class TareaDAO {

	private static Conexion conexion;

	public static int añadirTarea(TareaBean tarea) {

		/*
		 * aqui iria la consulta sql que añade una tarea a la tabla y devolvemos el
		 * identificador de la incidencia creada unicamente para poder utilizarlo en
		 * recibirTarea() de momento a modo de simular que se van a añadiendo tareas, el
		 * unico campo que no tiene la tarea pasada como parametro es id_tarea que se
		 * consigue incrementando el numero de tareas que se tienen, y fecha se le pasa
		 * como null
		 */
		
		if (conexion.getConexion()== null) 
			conexion.conectar(); 
		 
		int tarea_id=-1; 
		 
		java.sql.Statement stmt1 = null;  
		ResultSet rs1 = null; 
		PreparedStatement stm=null; 
		try {  
			//Consulta para saber el id de la nueva incidencia a crear 
			stmt1 = conexion.getConexion().createStatement() ; 
			rs1 =  stmt1.executeQuery("SELECT COUNT(tarea_id)\\r\\n\" + \r\n" +  
					"						\"FROM Tarea;"); 
			if (rs1.next()){ 
				tarea_id=rs1.getInt("COUNT(tarea_id)")+1;//id del nuevo servicio 
				stm=conexion.getConexion().prepareStatement("INSERT INTO Tarea values (?,?,?,?,?,?,?,?)"); 
				stm.setInt(1,tarea_id); 
				stm.setInt(2, tarea.getId_incidencia()); 
				stm.setInt(3, tarea.getId_empleado()); 
				stm.setString(4, tarea.getDescripcion()); 
				stm.setString(5,tarea.getLugar()); 
				stm.setBoolean(6,tarea.isEstado()); 
				stm.setDate(7,tarea.getFecha()); 
				stm.setString(8,tarea.getTipo_tarea()); 
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
		return tarea_id;
	}

	/*
	 * este metodo solo se utiliza cuando F&B nos quiere pasar una nueva tarea.
	 * Recibe el id_empleado,tipoTrabjo,lugar
	 */

	public static int recibirTarea(TareaBean nuevaTarea) {
		nuevaTarea.setDescripcion("tarea de restaurante");

		nuevaTarea.setEstado(false);

		// antes de añadir la tarea hay que añadir la incidencia
		IncidenciaBean incidencia = new IncidenciaBean();

		// COSA SIN HACER: ha cambiado la cosa y no tenemos que crear una nueva
		// incidencia siempre
		// que nos llegue una tarea desde F&B, es un caso especial que se maneja desde
		// codigo
		// unicamente cuando el tipoDeTarea sea cocinero y sea de un restaurante que ya
		// tenemos
		// guardado no se creara una nueva incidencia, sino que se trabajara con la que
		// ya hay creada
		if (nuevaTarea.getTipo_tarea() == "COCINERO") {

			/*
			 * habra que ver si tenemos alguna incidencia con los campos:
			 * tipo_Incidencia==COCINA y el mismo lugar que la tarea pasada De ser cierto no
			 * habra que añadir una nueva incidencia, y devolvemos el id_incidencia Si no
			 * existe dicha incidencia se crea la incidencia
			 */

			int res = IncidenciaDAO.BuscarIncidenciaPor(nuevaTarea.getLugar());

			if (res != -1) {
				// existe la incidencia-> tenemos que añadir la tarea con el id_incidencia res

				nuevaTarea.setId_incidencia(res);

				// no nos pasan fecha de momento devolvemos null
				nuevaTarea.setFecha(null);
				return añadirTarea(nuevaTarea);

			} else {
				// hay que añadir la incidencia y despues la taraea

				incidencia.setDescripcion("tarea de restaurante");
				// no nos pasan fecha de momento devolvemos null
				incidencia.setFecha(null);
				incidencia.setTipo_incidencia(nuevaTarea.getTipo_tarea());
				incidencia.setLugar(nuevaTarea.getLugar());
				incidencia.setTipo_incidencia("COCINA");

				IncidenciaDAO.añadirIncidencia(incidencia);

				// no nos pasan fecha de momento devolvemos null
				nuevaTarea.setFecha(null);
				nuevaTarea.setId_incidencia(incidencia.getId_incidencia());

				return añadirTarea(nuevaTarea);

			}

		} else {

			incidencia.setDescripcion("tarea de restaurante");
			// no nos pasan fecha de momento devolvemos null
			incidencia.setFecha(null);
			incidencia.setTipo_incidencia(nuevaTarea.getTipo_tarea());
			incidencia.setLugar(nuevaTarea.getLugar());
			incidencia.setTipo_incidencia(nuevaTarea.getTipo_tarea());

			IncidenciaDAO.añadirIncidencia(incidencia);

			// no nos pasan fecha de momento devolvemos null
			nuevaTarea.setFecha(null);
			nuevaTarea.setId_incidencia(incidencia.getId_incidencia());

			return añadirTarea(nuevaTarea);

		}

	}

	public static TareaBean getTareaPorIdEmpleado(int id_empleado) {
		if (conexion.getConexion() == null)
			conexion.conectar();

		TareaBean res = null;

		java.sql.Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conexion.getConexion().createStatement();
			rs = stmt.executeQuery("SELECT Tarea.* FROM Tarea  WHERE empleado_id = " + id_empleado);
			if (rs.next()) {
				res = new TareaBean(rs.getInt("tarea_id"), rs.getInt("incidencia_id"), rs.getInt("empleado_id"),
						rs.getString("descripcion"), rs.getString("tipo_tarea"), rs.getString("lugar_tarea"),
						rs.getBoolean("estado"), rs.getDate("fecha_tarea"));

			}

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
		} finally { // it is a good idea to release resources in a finally block
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException sqlEx) {
				}
				rs = null;
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException sqlEx) {
				}
				stmt = null;
			}
		}
		return res;

	}

}
