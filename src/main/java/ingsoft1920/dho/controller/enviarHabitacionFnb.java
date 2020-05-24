package ingsoft1920.dho.controller;

import com.google.gson.JsonObject;

public class enviarHabitacionFnb {
	public static void enviarHabitacion(int id_habitacion) {

		try {
			// construimos la peticion
			HttpClient client = new HttpClient("http://piedrafita.ls.fi.upm.es:7003/habitacionReservada", "POST");

			JsonObject param = new JsonObject();

			param.addProperty("habitacion_id", id_habitacion);
			System.out.print(param.toString());

			client.setRequestBody(param.toString());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
