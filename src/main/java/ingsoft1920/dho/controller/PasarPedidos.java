package ingsoft1920.dho.controller;

import java.time.LocalDate;
import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


import ingsoft1920.dho.bean.PedidosBean;
import ingsoft1920.dho.bean.ProductosBean;

public class PasarPedidos {

	

	
	public static void  pasarPedidos( int hotel_id ,LocalDate fecha,String lugar, int [] productos_id,String [] nombresProductos,
			int[] cantidades, String[] especificaciones) {
		
			
			if (lugar.equals("restaurante")) {
				pasarPedidosaFnb(hotel_id ,fecha, nombresProductos,
						cantidades, especificaciones);
			}
			pasarPedidosaCM(hotel_id ,fecha, productos_id,
					cantidades, especificaciones);
		}
		
		
	
	/*COSAS QUE HAY QUE ACLARAR:
	 * 1. URL
	 * 2.Esta biene el formato de la fecha??
	 */
	public static void pasarPedidosaCM( int hotel_id ,LocalDate fecha, int[] productos_id,int[] cantidades,
			String[] especificaciones) {
		
		
		try {
			//construimos la peticion 
			HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7000/cliente","POST");
			
			
			//metemos en el cuerpo de la peticion el id_hotel
			
			JsonObject param= new JsonObject();
			
			param.addProperty("fecha", fecha.toString());
			
			param.addProperty("hotel_id", hotel_id);
			
			
			JsonArray lista = new JsonArray();
			
			int cont = 0;
			
			for(int producto: productos_id ) {
				JsonObject obj = new JsonObject();
				
				obj.addProperty("producto_id", producto);
				obj.addProperty("cantidad", cantidades[cont]);
				obj.addProperty("especificaciones", especificaciones[cont]);
				
				lista.add(obj);
			}
			
			param.add("productos", lista);
			
			
			client.setRequestBody(param.toString());
			
		
			
							
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void pasarPedidosaFnb( int hotel_id ,LocalDate fecha, String[] productos,int[] cantidades,
			String[] especificaciones) {
		
		
		try {
			//construimos la peticion 
			HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7000/cliente","POST");
			
			
			//metemos en el cuerpo de la peticion el id_hotel
			
			JsonObject param= new JsonObject();
			
			param.addProperty("fecha", fecha.toString());
			
			param.addProperty("hotel_id", hotel_id);
			
			
			JsonArray lista = new JsonArray();
			
			int cont = 0;
			
			for(String producto: productos ) {
				JsonObject obj = new JsonObject();
				
				obj.addProperty("producto_id", producto);
				obj.addProperty("cantidad", cantidades[cont]);
				obj.addProperty("especificaciones", especificaciones[cont]);
				
				lista.add(obj);
			}
			
			param.add("productos", lista);
			
			
			client.setRequestBody(param.toString());
			
		
			
							
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
		
	}
	
}


