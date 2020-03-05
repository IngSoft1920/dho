package ingsoft1920.dho.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import ingsoft1920.dho.bean.EmpleadoBean;

public class PedirEmpleados {

	/*Esta pretende ser un peticion de tipo GET:
	 * EM nos deberia devolver una lista de Empleados
	 */
	
	public static List<EmpleadoBean> peticionPedirEmpleado() {
		
		
		try {
			//construimos la peticion 
			HttpClient client= new HttpClient("http://localhost:7001/getHabitacio/7","GET");
			
			
			//creo que como es una peticion de tipo GET y no pasamos parametros, no hace
			//falta establecer cuerpo de la peticion
			
			int respCode = client.getResponseCode();
			
			if(respCode==200){
				String resp=client.getResponseBody();
				/*en resp vamos a tener un string en formato JSON, lo acordado
				 * es que EM nos envien los 'id_empleado' con su 'rol'.
				 * El tratamiento del JSON recibido va a ser como se hace en 
				 * el proyecto de ejemplo en la clase API en el metodo procesaDatos1
				 */
				
				JsonObject obj = (JsonObject) JsonParser.parseString(resp);
				
				/*hemos quedado que nos van a devolver dos listas en las que
				 * metamos los id_empleado y en la otra el id_rol
				 */
				
				JsonArray id_empleadoLista=obj.get("id_empleado").getAsJsonArray();
				int[] id_empleadoListaInt= new int[id_empleadoLista.size()];
				JsonArray rolLista=obj.get("rol").getAsJsonArray();
				String[] rolListaInt= new String[rolLista.size()];
				JsonArray id_hotelLista=obj.get("id_hotel").getAsJsonArray();
				int[] id_hotelListaInt= new int[id_hotelLista.size()];
				List<EmpleadoBean> lista=new ArrayList<EmpleadoBean>();

				for(int i=0;i<rolLista.size();i++) {
					id_empleadoListaInt[i]=id_empleadoLista.get(i).getAsInt();
					rolListaInt[i]=rolLista.get(i).getAsString();
					id_hotelListaInt[i]=id_hotelLista.get(i).getAsInt();
					lista.add(new EmpleadoBean(id_empleadoListaInt[i], rolListaInt[i], id_hotelListaInt[i]));
				}
				
				return lista;
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	
}
