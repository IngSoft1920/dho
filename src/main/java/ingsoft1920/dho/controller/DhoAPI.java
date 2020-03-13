package ingsoft1920.dho.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import ingsoft1920.dho.DAO.EstanciaDAO;
import ingsoft1920.dho.DAO.HabitacionDAO;
import ingsoft1920.dho.DAO.HotelDAO;
import ingsoft1920.dho.DAO.ServicioDAO;
import ingsoft1920.dho.DAO.ServiciosDelHotelDAO;
import ingsoft1920.dho.DAO.TareaDAO;
import ingsoft1920.dho.bean.EstanciaBean;
import ingsoft1920.dho.bean.HabitacionBean;
import ingsoft1920.dho.bean.HotelBean;
import ingsoft1920.dho.bean.ServicioBean;
import ingsoft1920.dho.bean.ServiciosDelHotelBean;
import ingsoft1920.dho.bean.TareaBean;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Controller

public class DhoAPI {

	@ResponseBody
	@GetMapping("/getHabitacion/{id_cliente}")
	public HabitacionBean getHabitacionPorId(@PathVariable int id_cliente) {
		return HabitacionDAO.getHabitacionPorId(id_cliente);

	}

	@ResponseBody
	@GetMapping("/getTarea/{id_empleado}")
	public String getTareaPorId(@PathVariable int id_empleado) {

		List<TareaBean> lista = TareaDAO.getTareaPorIdEmpleado(id_empleado);

		// parece que lo que quiere que le mandemos es una lista con los id_tarea y
		// otra con las descripiciones,el id_empleado,la hora de inicio y la hora de fin
		JsonObject obj = new JsonObject();

		JsonArray tarea_id = new JsonArray();

		JsonArray descripcion = new JsonArray();

		JsonArray horaInico = new JsonArray();

		JsonArray horaFin = new JsonArray();

		JsonArray dia = new JsonArray();

		obj.addProperty("empleado_id", id_empleado);

		for (TareaBean elem : lista) {

			tarea_id.add(elem.getId_tarea());

			descripcion.add(elem.getDescripcion());

			horaInico.add(elem.getHora().toString());

			horaFin.add(elem.getHoraFin().toString());

			dia.add(elem.getFecha().toString());
		}

		obj.add("id_TareaLista", tarea_id);

		obj.add("descripcionLista", descripcion);

		obj.add("horaInicio", horaInico);

		obj.add("horaFin", horaFin);

		obj.add("dia", dia);

		return obj.toString().toString();

	}

	@ResponseBody
	@PostMapping("/recibirTarea")
	public String recibirTarea(@RequestBody TareaBean nuevaTarea) {
		JsonObject obj = new JsonObject();
		obj.addProperty("incidencia_id", TareaDAO.recibirTarea(nuevaTarea));
		return obj.toString().toString();

	}

	@ResponseBody
	@PostMapping("/recibirServicio")
	public void recibirServicio(@RequestBody ServicioBean nuevoServicio) {
		ServicioDAO.recogerServicio(nuevoServicio);

	}
	
	
	
	
	
	@ResponseBody
	@PostMapping("/serviciosDisponibles")
	//va a devolver el JSON en string con la informacion de la base
	//de datos
	public String serviciosDisponibles(@RequestBody  String nombre_Hotel){
		List<ServiciosDelHotelBean> lista=ServiciosDelHotelDAO.serviciosHotelPorNombre(nombre_Hotel);
		
		JsonObject obj =new JsonObject();
		
		//Creamos un campo por cada columna
		
		JsonArray servicios_disponibles_id=new JsonArray();
		
		JsonArray servicios_disponibles_nombre=new JsonArray();
		
		for (ServiciosDelHotelBean elem: lista) {
			
			servicios_disponibles_id.add(elem.getId_ServicioHotel());
			
			servicios_disponibles_nombre.add(elem.getNombre());
			
			}
		obj.add("servicios_disponibles_id", servicios_disponibles_id);

		obj.add("servicios_disponibles_nombre", servicios_disponibles_nombre);
		
		return  obj.toString().toString();
	}
	
	
	@ResponseBody
	@GetMapping("/serviciosHoras")
	//va a devolver el JSON en string con la informacion de la base
	//de datos
	public String HorasDeServicio(@RequestBody int id_servicioHotel) {
		
		JsonObject obj =new JsonObject();
		
		String[] res;
		//obtenemos los horarios e un array de dos posiciones
		res=ServiciosDelHotelDAO.horasServicio(id_servicioHotel);
		obj.addProperty("horas_Inicio" , res[0]);
		obj.addProperty("hora_Fin", res[1]);
		
		return obj.toString().toString();
		
		
	}
	
	

	@ResponseBody
	@GetMapping("/reservas")
	public String obtenerEstanciaDeUnCliente(@RequestBody int id_cliente) {
		
		List<EstanciaBean> lista=EstanciaDAO.getEstacia(id_cliente);
		
		JsonObject obj =new JsonObject();
		
		JsonArray id_estancia_lista =new JsonArray();
		
		JsonArray num_hab_lista=new JsonArray();
		
		JsonArray fecha_Inicio_Lista=new JsonArray();
		
		JsonArray fecha_Fin_Lista=new JsonArray();
		
		JsonArray nombre_hotel_Lista=new JsonArray();
		
		
		//falta meter el del check_in
		
		for (EstanciaBean elem : lista) {
			
			id_estancia_lista.add(elem.getEstancia_id());
			
			num_hab_lista.add(elem.getHabitacion_id());
			
			fecha_Inicio_Lista.add(elem.getFecha_inicio().toString());
			
			fecha_Fin_Lista.add(elem.getFecha_fin().toString());
			
			nombre_hotel_Lista.add(HotelDAO.ConseguirNombreHotelDadoID(elem.getHotel_id()));
			
		}
		
		obj.add("id_estancia_lista", id_estancia_lista);
		
		obj.add("num_hab_lista", num_hab_lista);
		
		obj.add("fecha_Inicio_Lista", fecha_Inicio_Lista);
		
		obj.add("fecha_Fin_Lista", fecha_Fin_Lista);
		
		obj.add("nombre_hotel_Lista", nombre_hotel_Lista);
		
		
		return obj.toString().toString();
		
	}
	
	@ResponseBody
	@GetMapping("/serviciosReservados")
	/*nos pasan el id_estancia y el id_cliente y consiguen 
	 * los servivios asociados a esa estancia
	 */
	public String serviciosReservadosPorUnCliente(@RequestBody int id_cliente,@RequestBody int id_estancia) {
		
		List<ServicioBean> serviciosReservados=ServicioDAO.devuelevServiciosreservadosPorunaEstancia(id_estancia);
		
		JsonObject obj =new JsonObject();
		
		JsonArray nombreServicio =new JsonArray();
		
		JsonArray fechaServicio =new JsonArray();
		
		
		for (ServicioBean elem: serviciosReservados) {
			
		
			fechaServicio.add(elem.getFecha_servicio().toString());
			
			
			nombreServicio.add(ServiciosDelHotelDAO.conseguirNombreServicioHotel(elem.getId_ServicoHotel()));
			
		}
		
	
		return obj.toString().toString();
		
	}
	
	
	
	
	
	
	 

	/**
	 * @param req
	 * @return
	 */
	@ResponseBody
	@PostMapping("/recibirHotel")
	public String recibirHotel(@RequestBody String req) {
		// Nos envian
		/*
		 * { { "id" : 21, "nombre" : "El resplandor", "descripcion" :
		 * "Una experiencia cálida", "estrellas" : 4, "continente" : "Europa", "pais" :
		 * "España", "ciudad" : "Madrid", "habitaciones" : [ { "id": 1 , "nombre":
		 * "normal" , "num_disponibles":50 }, { "id": 2 , "nombre": "premium" ,
		 * "num_disponibles":10} ], "categorias": [ { "id":11 , "nombre":"adult-only"},
		 * { "id":75 , "nombre":"pet-friendly"} ], "servicios" : [ { "id" : 1 , "nombre"
		 * : "piscina" , "precio": 10 , "unidad" : "por_dia" }, { "id" : 3 , "nombre" :
		 * "restaurante" , "precio" : null , "unidad" : null} ] } }
		 */
		// Este texto estaria en la variable req

		// Parseamos el texto a un JsonObject
		JsonObject obj = (JsonObject) JsonParser.parseString(req);

		int id = obj.get("id").getAsInt();
		String nombre = obj.get("nombre").getAsString();
		String descripcion = obj.get("descripcion").getAsString();
		int estrellas = obj.get("estrellas").getAsInt();
		String continente = obj.get("continente").getAsString();
		String pais = obj.get("pais").getAsString();
		String ciudad = obj.get("ciudad").getAsString();

		HotelBean hotel = new HotelBean(id, nombre, descripcion, estrellas, continente, pais, ciudad);

		HotelDAO.anadirHotel(hotel);

		JsonArray habitacionesLista = obj.get("habitaciones").getAsJsonArray();
		JsonArray categoriasLista = obj.get("categorias").getAsJsonArray();
		JsonArray serviciosLista = obj.get("servicios").getAsJsonArray();

		for (int i = 0; i < habitacionesLista.size(); i++) {
			int idHab = habitacionesLista.get(i).getAsJsonObject().get("id").getAsInt();
			String nombreHab = habitacionesLista.get(i).getAsJsonObject().get("nombre").getAsString();
			int num_Disponibles = habitacionesLista.get(i).getAsJsonObject().get("num_Disponibles").getAsInt();
			HabitacionBean hab = new HabitacionBean();
			hab.setId_hotel(id);
			hab.setTipo_habitacion(nombreHab);
			HabitacionDAO.anadirHabitaciones(hab,num_Disponibles);
		}
		/*
		 * for (int i = 0; i < categoriasLista.size(); i++) {
		 * 
		 * int idCatLista = categoriasListaInt[i].get("id").getAsInt(); String
		 * nombreCatLista = categoriasListaInt[i].get("nombre").getAsString(); //
		 * CategoriaBean cat=new CategoriaBean(); // listaCat.add(cat); }
		 */
		for (int i = 0; i < serviciosLista.size(); i++) {

			int idServ = serviciosLista.get(i).getAsJsonObject().get("id").getAsInt();
			String nombreServ = serviciosLista.get(i).getAsJsonObject().get("nombre").getAsString();
			int precio = serviciosLista.get(i).getAsJsonObject().get("precio").getAsInt();
			String unidadLista = serviciosLista.get(i).getAsJsonObject().get("unidad").getAsString();
			ServiciosDelHotelBean serv = new ServiciosDelHotelBean();
			serv.setId_Servicio(idServ);
			serv.setHotel_id(id);
			serv.setNombre(nombreServ);
			ServiciosDelHotelDAO.anadirServicioDelHotel(serv);
		}

		return "Procesado correctamente";

	}

}
