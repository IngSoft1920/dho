package ingsoft1920.dho.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import ingsoft1920.dho.bean.HotelBean;
import ingsoft1920.dho.bean.ServiciosDelHotelBean;
import ingsoft1920.dho.bean.HabitacionBean;
import ingsoft1920.dho.bean.AuxHabitacion;
import ingsoft1920.dho.bean.AuxHotelHabServ;
import ingsoft1920.dho.DAO.*;

public class peticionHotel {

	public static List<AuxHotelHabServ> peticionPedirHotel() {

		try {
			// construimos la peticion
			HttpClient client = new HttpClient("http://localhost:7001/getHotel", "GET");

			// metemos en el cuerpo de la peticion el id_hotel

			JsonObject param = new JsonObject();

			client.setRequestBody(param.toString().toString());

			int respCode = client.getResponseCode();

			if (respCode == 200) {
				String resp = client.getResponseBody();

				JsonObject obj = (JsonObject) JsonParser.parseString(resp);

				JsonArray idLista = obj.get("id").getAsJsonArray();
				int[] idListaInt = new int[idLista.size()];
				JsonArray nombreLista = obj.get("nombre").getAsJsonArray();
				String[] nombreListaInt = new String[nombreLista.size()];
				JsonArray descripcionLista = obj.get("descripcion").getAsJsonArray();
				String[] descripcionListaInt = new String[descripcionLista.size()];
				JsonArray estrellasLista = obj.get("estrellas").getAsJsonArray();
				int[] estrellasListaInt = new int[estrellasLista.size()];
				JsonArray continenteLista = obj.get("continente").getAsJsonArray();
				String[] continenteListaInt = new String[continenteLista.size()];
				JsonArray paisLista = obj.get("pais").getAsJsonArray();
				String[] paisListaInt = new String[paisLista.size()];
				JsonArray ciudadLista = obj.get("ciudad").getAsJsonArray();
				String[] ciudadListaInt = new String[ciudadLista.size()];
				JsonArray habitacionesLista = obj.get("habitaciones").getAsJsonArray();
				JsonObject[] habitacionesListaInt = new JsonObject[habitacionesLista.size()];
				JsonArray categoriasLista = obj.get("categorias").getAsJsonArray();
				JsonObject[] categoriasListaInt = new JsonObject[categoriasLista.size()];
				JsonArray serviciosLista = obj.get("servicios").getAsJsonArray();
				JsonObject[] serviciosListaInt = new JsonObject[serviciosLista.size()];
				List<AuxHotelHabServ> lista = new ArrayList<AuxHotelHabServ>();
				List<AuxHabitacion> listaHab = new ArrayList<AuxHabitacion>();
				List<ServiciosDelHotelBean> listaServ = new ArrayList<ServiciosDelHotelBean>();
				
				HashMap<Integer,HabitacionBean> aux=new HashMap<Integer,HabitacionBean>();
				for (int i = 0; i < idLista.size(); i++) {
					idListaInt[i] = idLista.get(i).getAsInt();
					nombreListaInt[i] = nombreLista.get(i).getAsString();
					descripcionListaInt[i] = descripcionLista.get(i).getAsString();
					estrellasListaInt[i] = estrellasLista.get(i).getAsInt();
					continenteListaInt[i] = continenteLista.get(i).getAsString();
					paisListaInt[i] = paisLista.get(i).getAsString();
					ciudadListaInt[i] = ciudadLista.get(i).getAsString();
					HotelBean hotel = new HotelBean(idListaInt[i], nombreListaInt[i], descripcionListaInt[i],
							estrellasListaInt[i], continenteListaInt[i], paisListaInt[i], ciudadListaInt[i]);

					JsonArray idHabLista = habitacionesListaInt[i].get("id").getAsJsonArray();
					int[] idHabListaInt = new int[idHabLista.size()];
					JsonArray nombreHabLista = habitacionesListaInt[i].get("nombre").getAsJsonArray();
					String[] nombreHabListaInt = new String[nombreHabLista.size()];
					JsonArray num_DisponiblesLista = habitacionesListaInt[i].get("num_Disponibles").getAsJsonArray();
					int[] num_DisponiblesListaInt = new int[num_DisponiblesLista.size()];
					for (int j = 0; j < idHabLista.size(); j++) {
						idHabListaInt[j] = idHabLista.get(j).getAsInt();
						nombreHabListaInt[j] = nombreHabLista.get(j).getAsString();
						num_DisponiblesListaInt[j] = num_DisponiblesLista.get(j).getAsInt();
						AuxHabitacion hab = new AuxHabitacion();
						hab.setId_tipo(idHabListaInt[j]);
						hab.setId_hotel(idListaInt[i]);
						hab.setTipo_habitacion(nombreHabListaInt[j]);
						hab.setNum_Disponibles(num_DisponiblesListaInt[j]);
						listaHab.add(hab);
					}

					JsonArray idCatLista = categoriasListaInt[i].get("id").getAsJsonArray();
					int[] idCatListaInt = new int[idCatLista.size()];
					JsonArray nombreCatLista = categoriasListaInt[i].get("nombre").getAsJsonArray();
					String[] nombreCatListaInt = new String[nombreCatLista.size()];
					for (int j = 0; j < categoriasListaInt[i].size(); j++) {
						idCatListaInt[j] = idCatLista.get(j).getAsInt();
						nombreHabListaInt[j] = nombreHabLista.get(j).getAsString();
						// CategoriaBean cat=new CategoriaBean();
						// listaCat.add(cat);
					}

					JsonArray idServLista = serviciosListaInt[i].get("id").getAsJsonArray();
					int[] idServListaInt = new int[idServLista.size()];
					JsonArray nombreServLista = serviciosListaInt[i].get("nombre").getAsJsonArray();
					String[] nombreServListaInt = new String[nombreServLista.size()];
					JsonArray precioLista = serviciosListaInt[i].get("precio").getAsJsonArray();
					int[] precioListaInt = new int[precioLista.size()];
					JsonArray unidadLista = serviciosListaInt[i].get("unidad").getAsJsonArray();
					String[] unidadListaInt = new String[unidadLista.size()];

					for (int j = 0; j < serviciosListaInt[i].size(); j++) {
						idServListaInt[j] = idServLista.get(j).getAsInt();
						nombreServListaInt[j] = nombreServLista.get(j).getAsString();
						precioListaInt[j] = precioLista.get(j).getAsInt();
						unidadListaInt[j] = unidadLista.get(j).getAsString();
						ServiciosDelHotelBean serv = new ServiciosDelHotelBean();
						serv.setId_Servicio(idServListaInt[j]);
						serv.setHotel_id(idListaInt[i]);
						listaServ.add(serv);
					}

					lista.add(new AuxHotelHabServ(hotel, listaHab, listaServ));
				}

				return lista;

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	public void guardarHotelesHAbitacionesServicios() {
		List<AuxHotelHabServ> aux = peticionPedirHotel();
		guardarHoteles(aux);
		guardarServicios(aux);
		guardarHabitaciones(aux);
	}

	public void guardarHoteles(List<AuxHotelHabServ> lista) {
		for (int i = 0; i < lista.size(); i++) {
			HotelDAO.anadirHotel(lista.get(i).getHotel());
		}
	}

	public void guardarHabitaciones(List<AuxHotelHabServ> lista) {
		for (int i = 0; i < lista.size(); i++) {
			for (int j = 0; j < lista.get(i).getListaHab().size(); j++) {
				HabitacionDAO.anadirHabitaciones(lista.get(i).getListaHab().get(j));
			}
		}

	}

	public void guardarServicios(List<AuxHotelHabServ> lista) {
		for (int i = 0; i < lista.size(); i++) {
			for (int j = 0; j < lista.get(i).getListaServ().size(); j++) {
				ServiciosDelHotelDAO.anadirServicioDelHotel(lista.get(i).getListaServ().get(j));
			}
		}
	}

}
