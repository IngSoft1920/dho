package ingsoft1920.dho.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import ingsoft1920.dho.DAO.HabitacionDAO;
import ingsoft1920.dho.DAO.ServicioDAO;
import ingsoft1920.dho.DAO.ServiciosDelHotelDAO;
import ingsoft1920.dho.DAO.TareaDAO;
import ingsoft1920.dho.bean.HabitacionBean;
import ingsoft1920.dho.bean.ServicioBean;
import ingsoft1920.dho.bean.ServiciosDelHotelBean;
import ingsoft1920.dho.bean.TareaBean;
import com.google.gson.JsonArray; 
import com.google.gson.JsonObject; 


@Controller

public class DhoAPI {

	@ResponseBody
	@GetMapping("/getHabitacion/{id_cliente}")
	public HabitacionBean getHabitacionPorId(@PathVariable int id_cliente) {
		return  HabitacionDAO.getHabitacionPorId(id_cliente) ;
		
	}
	
	@ResponseBody
	@GetMapping("/getTarea/{id_empleado}")
	public TareaBean getTareaPorId(@PathVariable int id_empleado) {
		return  TareaDAO.getTareaPorIdEmpleado(id_empleado) ;
		
	}
	
	
	
	
	@ResponseBody
	@PostMapping("/recibirTarea")
	public int recibirTarea(@RequestBody TareaBean nuevaTarea) {
				return TareaDAO.recibirTarea(nuevaTarea);
				
		
	}
	
	@ResponseBody
	@PostMapping("/recibirServicio")
	public void recibirServicio(@RequestBody ServicioBean nuevoServicio) {
		ServicioDAO.recogerServicio(nuevoServicio);
		
	}
	
	
	
	@ResponseBody
	@GetMapping("/getServiciosHotel")
	//va a devolver el JSON en string con la informacion de la base
	//de datos
	public String darServiciosHotel(){
		
		List<ServiciosDelHotelBean> lista=ServiciosDelHotelDAO.darServiciosHotel();
		
		JsonObject obj =new JsonObject();
		
		//creamos un campo por cada columna
		
		JsonArray id_ServiciosHotel=new JsonArray();
		
		JsonArray HoraInicioServicio=new JsonArray();
		
		JsonArray HoraFinServicio= new JsonArray();
		
		JsonArray DisponibilidaTotal=new JsonArray();
		
		
		for (ServiciosDelHotelBean elem: lista) {
			
			id_ServiciosHotel.add(elem.getId_ServicioHotel());
			
			HoraInicioServicio.add(elem.getHoraInicioServicio());
			
			HoraFinServicio.add(elem.getHoraFinServicio());
			
			DisponibilidaTotal.add(elem.getDisponibilidadTotal());
			
			
		}
		
		//en este punto ya tenemos las listas con los elementos
		//ya solo queda añadirlas al obj y hacer el toString()
		
		
		obj.add("id_ServiciosHotel", id_ServiciosHotel);
		
		obj.add("HoraInicioServicio", HoraInicioServicio);
		
		obj.add("HoraFinServicio", HoraFinServicio);
		
		obj.add("DisponibilidaTotal", DisponibilidaTotal);
		
		return  obj.toString().toString();
	}
	
	
	
	 
		//metodo  de prueba para probar la solicitud http lanzada como cliente 
		@ResponseBody 
		@GetMapping("/getHabitacio/7") 
		public String prueba() { 
			 
			JsonObject obj = new JsonObject(); 
			JsonArray listaNotas = new JsonArray(); 
			listaNotas.add(1); 
			JsonArray listaNotas2 = new JsonArray(); 
			listaNotas2.add(1); 
			obj.add("id_empleado", listaNotas); 
			obj.add("rol", listaNotas2); 
			return obj.toString().toString(); 
			 
		} 
		
		//metodo  de prueba para probar la solicitud http de tipo POST lanzada como cliente 
		 
		@ResponseBody 
		@PostMapping("/asignarTurnos/7") 
		public String prueba2() { 
			return "ha ido correctamente"; 
		} 
	
}
