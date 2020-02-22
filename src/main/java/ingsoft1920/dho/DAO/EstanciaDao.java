package ingsoft1920.dho.DAO;

import java.util.ArrayList;
import java.util.List;

import ingsoft1920.dho.bean.EstanciaBean;

public class EstanciaDao {

	public static List<EstanciaBean> geEstanciaBeans() {
		
		/*aqui va la consultada que nos devuelve todas las estancia que tenemos
		 * guardas en la tabla en una lista de Beans de estancias
		*/
		//codigo para qque funcione de momento
		
		List<EstanciaBean> lista=new ArrayList<EstanciaBean>();
		EstanciaBean estancia=new EstanciaBean();
		estancia.setCliente_id(1);
		estancia.setHabitacion_id(1);
		//es un nuevo campo que hay que añadir a la base de datos
		//refleja si se ha hecho el checkin, el checkout, o si esta Incompleto
		estancia.setEstado("Incompleto");
		
		lista.add(estancia);
		
		return lista;
		
	}
	
	
	public static void cambiarEstadoEstancia(int estancia_id) {
		/*aqui deberia ir la consulta que te cambia el estado de la estancia a check_in
		 * dado el id_estancia
		 */
		
	}
	
	
}
