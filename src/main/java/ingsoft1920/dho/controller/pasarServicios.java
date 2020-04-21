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
import ingsoft1920.dho.bean.ServicioBean;

@Component
public class pasarServicios {

	@Scheduled(cron = "0 55 23 * * ? ")
	public static void enviarServicios() {
		try {
			HttpClient client = new HttpClient("http://piedrafita.ls.fi.upm.es:7000/pasarServicios", "POST");
			Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
			ArrayList<ServicioBean> servicios = ServicioDAO.getServiciosPorFecha2(date);
			JsonObject obj = new JsonObject();
			JsonArray servicios_id = new JsonArray();
			JsonArray reserva_id = new JsonArray();
			JsonArray id_ServicioHotel = new JsonArray();
			JsonArray cliente_id = new JsonArray();
			JsonArray lugar = new JsonArray();
			JsonArray fecha_servicio = new JsonArray();
			JsonArray hora = new JsonArray();
			JsonArray tipo_servicio = new JsonArray();
			JsonArray platos = new JsonArray();
			JsonArray items = new JsonArray();
			JsonArray hora_salida = new JsonArray();
			JsonArray precio = new JsonArray();
			for (ServicioBean elem : servicios) {

				servicios_id.add(elem.getServicios_id());
				reserva_id.add(elem.getEstancia_id());
				id_ServicioHotel.add(elem.getId_ServicoHotel());
				cliente_id.add(elem.getCliente_id());
				lugar.add(elem.getLugar());
				fecha_servicio.add(elem.getFecha_servicio().toString());
				hora.add(elem.getHora().toString());
				tipo_servicio.add(elem.getTipo_servicio());
				platos.add(elem.getPlatos());
				items.add(elem.getItems());
				hora_salida.add(elem.getHora_salida().toString());
				precio.add(elem.getPrecio());

			}
			obj.add("servicios_id", servicios_id);
			obj.add("reserva_id", reserva_id);
			obj.add("id_ServicioHotel", id_ServicioHotel);
			obj.add("cliente_id", cliente_id);
			obj.add("lugar", lugar);
			obj.add("hora", hora);
			obj.add("tipo_servicio", tipo_servicio);
			obj.add("platos", platos);
			obj.add("items", items);
			obj.add("hora_salida", hora_salida);
			obj.add("precio", precio);

			client.setRequestBody(obj.toString());
			int respCode = client.getResponseCode();
			if (respCode != 200) {
				System.out.println("Ha habido un error, con código " + respCode);
				return;
			}
			String resp = client.getResponseBody();
			System.out.println((JsonObject) JsonParser.parseString(resp));

		} catch (

		Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
