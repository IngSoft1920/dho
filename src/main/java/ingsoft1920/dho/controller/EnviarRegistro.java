package ingsoft1920.dho.controller;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import ingsoft1920.dho.bean.ClienteBean;
import ingsoft1920.dho.bean.EmpleadoBean;
import ingsoft1920.dho.bean.EstanciaBean;

public class EnviarRegistro {

public static int peticionEnviarRegistro(ClienteBean cliente) {
		
	int id_cliente=-1;
		
		try {
			//construimos la peticion 
			HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7000/cliente","POST");
			
			
			//metemos en el cuerpo de la peticion el id_hotel
			
			JsonObject param= new JsonObject();
			
			param.addProperty("nombre", cliente.getNombre());
			
			param.addProperty("apellidos", cliente.getApellidos());
			
			param.addProperty("DNI", cliente.getDni());
			
			param.addProperty("email", cliente.getEmail());
			
			param.addProperty("telefono", cliente.getTelefono());
			
			param.addProperty("nacionalidad", cliente.getNacionalidad());
			
			param.addProperty("password", cliente.getPassword());
			
			
			
			client.setRequestBody(param.toString());
			
			
			int respCode = client.getResponseCode();
			
		
			
			if(respCode==200){
				String resp=client.getResponseBody();
				 
				
				
				
				JsonObject obj = (JsonObject) JsonParser.parseString(resp);
				
				id_cliente=obj.get("id").getAsInt();
			
				
				
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id_cliente;
		
	}




public static int peticionEnviarEstancia(String fechaIncio,String fechaFin,
		int id_hotel,String regimen,int id_cliente,int num_acomp,
		int tipo_hab) {
	
	int id_reserva = -1;
		
		try {
			//construimos la peticion 
			HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7000/cliente","POST");
			
			
			//metemos en el cuerpo de la peticion el id_hotel
			
			JsonObject param= new JsonObject();
			
			param.addProperty("fecha_entrada", fechaIncio);
			
			param.addProperty("fecha_salida", fechaFin);
			
			param.addProperty("regimen", regimen);
			
			param.addProperty("cliente_id",id_cliente);
			
			param.addProperty("hotel_id", id_hotel);
			
			param.addProperty("tipo_hab_id", tipo_hab);
			
			param.addProperty("numero_acompanantes", num_acomp);
			
			param.addProperty("metodo_pago", "pagado");
			
			
			client.setRequestBody(param.toString());
			
			
			int respCode = client.getResponseCode();
			
		
			
			if(respCode==200){
				String resp=client.getResponseBody();
				 
				
				
				
				JsonObject obj = (JsonObject) JsonParser.parseString(resp);
				
				id_reserva=obj.get("id").getAsInt();
				
			
				
				
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return id_reserva;
		
	}
	
	
	
	
}
