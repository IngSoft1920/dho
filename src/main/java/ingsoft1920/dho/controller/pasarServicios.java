package ingsoft1920.dho.controller;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import ingsoft1920.dho.DAO.ServicioDAO;
import ingsoft1920.dho.DAO.ServiciosDelHotelDAO;
import ingsoft1920.dho.bean.ServicioBean;

@Component
public class pasarServicios {

	@Scheduled(cron = "0 55 23 * * ? ")
	public static void enviarServicios() {
		HttpClient client;
		try {
			client = new HttpClient("http://piedrafita.ls.fi.upm.es:7000/facturas", "POST");
			JsonArray lista = new JsonArray();
			Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
			ArrayList<ServicioBean> servicios = ServicioDAO.getServiciosPorFecha2(date);
			for (ServicioBean elem : servicios) {
				JsonObject obj = new JsonObject();
				obj.addProperty("reserva_id", elem.getEstancia_id());
				obj.addProperty("pagado", false);
				obj.addProperty("cantidad_consumida", 1);
				String nombre = ServiciosDelHotelDAO.conseguirNombreServicioHotel(elem.getId_ServicioHotel());
				obj.addProperty("nombre_servicio", nombre);
				obj.addProperty("importe", elem.getPrecio());
				lista.add(obj);
			}
			client.setRequestBody(lista.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		enviarServicios();
	}

}
