package ingsoft1920.dho.DAO;

import java.util.List;

import ingsoft1920.dho.bean.IncidenciaBean;
import ingsoft1920.dho.bean.TareaBean;

public class TareaDAO {
	
	
	
	
	public static int añadirTarea(TareaBean tarea) {
		
		/*aqui iria la consulta sql que añade una tarea
		 * a la tabla y devolvemos el identificador de la incidencia creada
		 * unicamente para poder utilizarlo en recibirTarea() de momento a modo de simular
		 * que se van a añadiendo tareas, el unico campo que no tiene la tarea pasada como 
		 * parametro es id_tarea que se consigue incrementando el numero de tareas que 
		 * se tienen, y fecha se le pasa como null 
		 */
		return tarea.getId_incidencia();
	}
	
	/*este metodo solo se utiliza cuando F&B nos quiere pasar una nueva tarea.
	 * Recibe el id_empleado,tipoTrabjo,lugar
	 */
	
	public static int recibirTarea(TareaBean nuevaTarea) {
		nuevaTarea.setDescripcion("tarea de restaurante");
		
		nuevaTarea.setEstado(false);
		
		//antes de añadir la tarea hay que añadir la incidencia
		IncidenciaBean incidencia= new IncidenciaBean();
		
		
		
		//COSA SIN HACER: ha cambiado la cosa y no tenemos que crear una nueva incidencia siempre
		//que nos llegue una tarea desde F&B, es un caso especial que se maneja desde codigo
		//unicamente cuando el tipoDeTarea sea cocinero y sea de un restaurante que ya tenemos
		//guardado no se creara una nueva incidencia, sino que se trabajara con la que ya hay creada
		if(nuevaTarea.getTipo_tarea()=="COCINERO") {
			
			/*habra que ver si tenemos alguna incidencia con los campos:
			 * tipo_Incidencia==COCINA
			 * y el mismo lugar que la tarea pasada
			 * De ser cierto no habra que añadir una nueva incidencia, y devolvemos
			 * el id_incidencia
			 * Si no existe dicha incidencia se crea la incidencia
			 */
			
			int res=IncidenciaDAO.BuscarIncidenciaPor(nuevaTarea.getLugar());
			
			if(res!=-1) {
				//existe la incidencia-> tenemos que añadir la tarea  con el id_incidencia res
				
				nuevaTarea.setId_incidencia(res);
				
				//no nos pasan fecha de momento devolvemos null
				nuevaTarea.setFecha(null);
				return añadirTarea(nuevaTarea);
				
			}else {
				//hay que añadir la incidencia y despues la taraea
				
				incidencia.setDescripcion("tarea de restaurante");
				//no nos pasan fecha de momento devolvemos null
				incidencia.setFecha(null);
				incidencia.setTipo_incidencia(nuevaTarea.getTipo_tarea());
				incidencia.setLugar(nuevaTarea.getLugar());
				incidencia.setTipo_incidencia("COCINA");
				
				IncidenciaDAO.añadirIncidencia(incidencia);
				
				//no nos pasan fecha de momento devolvemos null
				nuevaTarea.setFecha(null);
				nuevaTarea.setId_incidencia(incidencia.getId_incidencia());
				
				
				return añadirTarea(nuevaTarea);
				
			}
				
		}else {
			
			
			incidencia.setDescripcion("tarea de restaurante");
			//no nos pasan fecha de momento devolvemos null
			incidencia.setFecha(null);
			incidencia.setTipo_incidencia(nuevaTarea.getTipo_tarea());
			incidencia.setLugar(nuevaTarea.getLugar());
			incidencia.setTipo_incidencia(nuevaTarea.getTipo_tarea());
			
			
			IncidenciaDAO.añadirIncidencia(incidencia);
			
			//no nos pasan fecha de momento devolvemos null
			nuevaTarea.setFecha(null);
			nuevaTarea.setId_incidencia(incidencia.getId_incidencia());
			
			return añadirTarea(nuevaTarea);
			
			
		}
		
	}
	
}
