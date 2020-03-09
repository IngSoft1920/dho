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
	public String getTareaPorId(@PathVariable int id_empleado) {
		 
		List<TareaBean> lista=TareaDAO.getTareaPorIdEmpleado(id_empleado) ;
		
		//parece que lo que quiere que le mandemos es una lista con los id_tarea y 
		//otra con las descripiciones,el id_empleado,la hora de inicio y la hora de fin
		JsonObject obj=new JsonObject();
		
		JsonArray tarea_id=new JsonArray();
		
		JsonArray descripcion=new JsonArray();
		
		JsonArray horaInico=new JsonArray();
		
		JsonArray horaFin=new JsonArray();
		
		JsonArray dia=new JsonArray();
		
		obj.addProperty("empleado_id", id_empleado);
		
		
	for (TareaBean elem: lista) {
			
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
	
	
	return  obj.toString().toString();
		
	}
	
	
	
	
	@ResponseBody
	@PostMapping("/recibirTarea")
	public String recibirTarea(@RequestBody TareaBean nuevaTarea) {
				JsonObject obj=new JsonObject();
				obj.addProperty("incidencia_id", TareaDAO.recibirTarea(nuevaTarea));
				return  obj.toString().toString();
				
				
				
		
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
			
			//HoraInicioServicio.add(elem.getHoraInicioServicio());
			
			//HoraFinServicio.add(elem.getHoraFinServicio());
			
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
	
	
	
	
	 
}
