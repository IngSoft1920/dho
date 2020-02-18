package ingsoft1920.dho.DAO;

import ingsoft1920.dho.bean.IncidenciaBean;
import ingsoft1920.dho.bean.TareaBean;

public class TareaDAO {
	
	
	public static int añadirTarea(TareaBean tarea) {
		
		/*aqui iria la consulta sql que añade una tarea
		 * a la tabla y devolvemos el identificador de la incidencia creada
		 * unicamente para poder utilizarlo en recibirTarea() de momento a modo de simular
		 * que se van a añadiendo tareas, vamos a tener un contador estatico que se vaya incrementando
		 * cada vez que se añada una nueva incidencia
		 */
		return tarea.getId_incidencia();
	}
	
	//este metodo solo se utiliza cuando F&B nos quiere pasar una nueva tarea
	public static int recibirTarea(TareaBean nuevaTarea) {
		nuevaTarea.setDescripcion("tarea de restaurante");
		
		nuevaTarea.setEstado(false);
		
		//antes de añadir la tarea hay que añadir la incidencia
		IncidenciaBean incidencia= new IncidenciaBean();
		
		//COSA SIN HACER: ha cambiado la cosa y no tenemos que crear una nueva incidencia siempre
		//que nos llegue una tarea desde F&B, es un caso especial que se maneja desde codigo
		//unicamente cuando el tipoDeTarea sea camarero y sea de un restaurante que ya tenemos
		//guardado no se creara una nueva incidencia, sino que se trabajara con la que ya hay creada
		
		incidencia.setDescripcion("tarea de restaurante");
		incidencia.setFecha("vacio");//revisar esto
		incidencia.setId_incidencia(IncidenciaBean.ContInc);
		incidencia.setTipo_incidencia(nuevaTarea.getTipo_tarea());
		incidencia.setLugar(nuevaTarea.getLugar());
		
		//una vez relleando los campos de la nueva incidencia, llamamos a añadirIncidencia..
		//para añadirla a la tabla
		nuevaTarea.setId_incidencia(IncidenciaBean.ContInc);
		
		IncidenciaDAO.añadirIncidencia(incidencia);
		
		return añadirTarea(nuevaTarea);
		
	}
	
}
