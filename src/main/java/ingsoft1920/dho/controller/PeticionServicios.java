
/*
package ingsoft1920.dho.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import ingsoft1920.dho.bean.ServicioBean;

public class PeticionServicios {

	/*Esta pretende ser un peticion de tipo GET:
	 * EM nos deberia devolver una lista de Empleados
	 */
	


/*
	public static List<ServicioBean> peticionServicios() {
		
		
		try {
			//construimos la peticion 
			HttpClient client= new HttpClient("http://localhost:7001/recibirServicios/7","GET");
			
			
			
			int respCode = client.getResponseCode();
			
			if(respCode==200){
				String resp=client.getResponseBody();
				
				JsonObject obj = (JsonObject) JsonParser.parseString(resp);
				
				
				//JsonArray servicios_idLista=obj.get("servicios_id").getAsJsonArray();
				//int[] servicios_idListaInt= new int[servicios_idLista.size()];
				//JsonArray estancia_idLista=obj.get("estancia_id").getAsJsonArray();
				//int[] estancia_idListaInt= new int[estancia_idLista.size()];
				JsonArray cliente_idLista=obj.get("cliente_id").getAsJsonArray();
				int[] cliente_idListaInt= new int[cliente_idLista.size()];
				JsonArray lugarLista=obj.get("lugar").getAsJsonArray();
				String[] lugarListaInt= new String[lugarLista.size()];
				JsonArray fecha_servicioLista=obj.get("fecha_servicio").getAsJsonArray();
				String[] fecha_servicioListaInt= new String[fecha_servicioLista.size()];
				JsonArray horaLista=obj.get("hora").getAsJsonArray();
				String[] horaListaInt= new String[horaLista.size()];
				JsonArray tipo_servicioLista=obj.get("tipo_servicio").getAsJsonArray();
				String[] tipo_servicioListaInt= new String[tipo_servicioLista.size()];
				List<ServicioBean> lista=new ArrayList<ServicioBean>();

				for(int i=0;i<cliente_idLista.size();i++) {
					//servicios_idListaInt[i]=servicios_idLista.get(i).getAsInt();
					//estancia_idListaInt[i]=estancia_idLista.get(i).getAsInt();
					cliente_idListaInt[i]=cliente_idLista.get(i).getAsInt();
					lugarListaInt[i]=lugarLista.get(i).getAsString();
					fecha_servicioListaInt[i]=fecha_servicioLista.get(i).getAsString();
					horaListaInt[i]=horaLista.get(i).getAsString();
					tipo_servicioListaInt[i]=tipo_servicioLista.get(i).getAsString();
					ServicioBean aux=new ServicioBean();
					aux.setCliente_id(cliente_idListaInt[i]);
					aux.setLugar(lugarListaInt[i]);
					aux.setFecha_servicio(fecha_servicioListaInt[i]);
					aux.setHora(horaListaInt[i]);
					aux.setTipo_servicio(tipo_servicioListaInt[i]);;
					lista.add(aux);
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


*/