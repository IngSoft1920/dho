package ingsoft1920.dho.controller;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import ingsoft1920.dho.bean.EmpleadoBean;

public class PasarTurnos {

	/*esta clase se va a encargar de mandar un solicitud de tipo Post al servidor
	 * de EM asignandole los turnos a los empleados, vamos a utitilizar la solicitud
	 * de PedirEmpleado a EM , ya probada, para tener una lista de empleados, 
	 * asi cuando vayamos a asignar turnos, tendremos la lista actualizada de empleados.
	 * Por lo tanto este METODO COMBINARA AMBAS PETICIONES, aun asi siempre es posible realizar 
	 * la peticion de empleados sin asignarles turnos
	 */
	
	
	//Devolvera cero si ha ido todo corecto y -1 en e.o.c
	public static int  peticionPasarTurnos() {
		
		try {
			
			//pedimos la lista con los empleados
			
			List<EmpleadoBean> lista=PedirEmpleados.peticionPedirEmpleado();
			
			//construimos la peticion (cambiamos url y tipo de solicitud)
			
			HttpClient client= new HttpClient("http://localhost:7001/asignarTurnos/7","POST");
			
			
			//creo que como es una peticion de tipo POST y si pasamos parametros, hace
			//falta establecer cuerpo de la peticion, a diferencia de con la peticion GET
			
			/*tenemos que construir un string en formato JSON(como no se hacer esto)
			 * voy a construir un objeto JOSN y luego pasarlo a un string y esperar que 
			 * sirva
			 */
			
			JsonObject obj = new JsonObject();
			
			//vamos a pasarle 3 listas que tendran:los id_empleado,hora_inicio,hora_fin
			//es una forma de asignacion asi, si cogemos el primer elemento de cada lista, constituira
			//el id_empleado, horaInicio,horaFin de el primer empleado
			
			JsonArray id_empleadoLista = new JsonArray();
			JsonArray horaInicioLista = new JsonArray();
			JsonArray horaFinLista = new JsonArray();
			
			//sacamos los empleados de la lista
			//los horarios estan como ejemplo luego se pueden retocar
			for (EmpleadoBean elem: lista) {
				id_empleadoLista.add(elem.getId_empleado());
				horaInicioLista.add("9:00");
				horaFinLista.add("17:00");
				
			}
			
			obj.add("id_empleado", id_empleadoLista );
			obj.add("horarioInicio", horaInicioLista );
			obj.add("horarioFin", horaFinLista );
			
			//ya tenemos en obj las lista con todos los datos solo queda meterla
			//en el cuerpo de la solicitud como String
			
			
			client.setRequestBody(obj.toString().toString());
			
			int respCode = client.getResponseCode();
			
			if(respCode==200){
			
				//en la peticion post en este caso no nos van a devolver nada asique no nos
				//interesa el cuerpo de la respuesta
				
				return 0;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return -1;
		
	
		
	}
	
}