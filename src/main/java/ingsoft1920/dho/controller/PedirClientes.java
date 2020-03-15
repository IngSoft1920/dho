package ingsoft1920.dho.controller;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import ingsoft1920.dho.bean.ClienteBean;

public class PedirClientes {

		
		public static ClienteBean peticionPedirCliente(int reserva_id) {
			
			
			try {
				//construimos la peticion 
				HttpClient client= new HttpClient("http://localhost:7001/getCliente/7","GET");
				
				
				JsonObject param= new JsonObject();
				
				param.addProperty("reserva_id", reserva_id);
				
				client.setRequestBody(param.toString().toString());
				
				
				int respCode = client.getResponseCode();
				
				if(respCode==200){
					String resp=client.getResponseBody();
					
					JsonObject obj = (JsonObject) JsonParser.parseString(resp);
					
				    int cliente_id = obj.get("cliente_id").getAsInt();
					String nombre = obj.get("nombre").getAsString();
					String apellidos=obj.get("apellidos").getAsString();
					String dni= obj.get("dni").getAsString();
					String email= obj.get("email").getAsString();
					String password= obj.get("password").getAsString();
					String nacionalidad= obj.get("nacionalidad").getAsString();
					int telefono= obj.get("telefono").getAsInt();
					ClienteBean cliente = new ClienteBean (cliente_id, nombre,apellidos, dni, email, password, nacionalidad,telefono);
					
				 return cliente;
				
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return null;
			
		}
		
		
	}

