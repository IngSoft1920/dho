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
				HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7000/reserva/getCliente/"+reserva_id,"GET");
				
				int respCode = client.getResponseCode();
				if(respCode==200){
					String resp=client.getResponseBody();
					
					JsonObject obj = (JsonObject) JsonParser.parseString(resp);
				    int cliente_id = obj.get("cliente_id").getAsInt();
					String nombre = cambio(obj.get("nombre").toString());
					String apellidos=cambio(obj.get("apellidos").toString());
					String dni= cambio(obj.get("DNI").toString());
					String email= cambio(obj.get("email").toString());
					String password= cambio(obj.get("password").toString());
					String nacionalidad= cambio(obj.get("nacionalidad").toString());
					Integer telefono= valueOf2(obj.get("telefono").toString());
					ClienteBean cliente = new ClienteBean (cliente_id, nombre,apellidos, dni, email, password, nacionalidad,telefono,"");
					
				 return cliente;
				
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return null;
			
		}
		public static Integer valueOf2(String inputString) {
			return (inputString.equals("null") || inputString == null) ? null : Integer.parseInt(inputString);
		}
		public static String cambio(String input) {
			return (input.equals("null") || input == null) ? null : input;
			
		}
		
		
	}

