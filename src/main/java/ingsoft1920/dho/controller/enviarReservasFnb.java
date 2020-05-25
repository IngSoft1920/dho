package ingsoft1920.dho.controller;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import ingsoft1920.dho.DAO.HabitacionDAO;

public class enviarReservasFnb {
	
	public static void enviarReservas(int id_servicioHotel,int id_reserva,int num_clientes,LocalDate fecha,
			LocalTime hora ,int id_habitacion) {

		try {
			// construimos la peticion
			HttpClient client = new HttpClient("http://piedrafita.ls.fi.upm.es:7003/nuevoServicio", "POST");

			JsonObject param = new JsonObject();

			param.addProperty("servicio_id", id_servicioHotel);
			param.addProperty("reserva_id", id_reserva);
			param.addProperty("fecha_hora", LocalDateTime.of(fecha, hora).toString());
			param.addProperty("num_clientes", num_clientes);
			param.addProperty("tipoUbicacion", 1);
			param.addProperty("ubicacion", "Mamma Mia");
			JsonArray habitaciones_id = new JsonArray();
			habitaciones_id.add(id_habitacion);
			JsonArray platos = new JsonArray();
			JsonArray items = new JsonArray();
			param.add("habitaciones_id", habitaciones_id);
			param.add("platos", platos);
			param.add("items", items);
			System.out.print(param.toString());
			
			client.setRequestBody(param.toString());
			
			int respCode = client.getResponseCode();

            if(respCode == 200) {
              
            
            	
            }

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	public static void main(String args[]) {
		
		LocalDate fecha = LocalDate.parse("2020-05-24");
		LocalTime hora= LocalTime.parse("09:30");
		
		enviarReservas(2, 2, 4, fecha, hora, 503);
		
	}
}
