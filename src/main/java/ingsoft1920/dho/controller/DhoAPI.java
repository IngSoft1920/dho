package ingsoft1920.dho.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import ingsoft1920.dho.DAO.HabitacionDAO;
import ingsoft1920.dho.DAO.ServicioDAO;
import ingsoft1920.dho.DAO.TareaDAO;
import ingsoft1920.dho.bean.EmpleadoBean;
import ingsoft1920.dho.bean.HabitacionBean;
import ingsoft1920.dho.bean.ServicioBean;
import ingsoft1920.dho.bean.TareaBean;

@Controller

public class DhoAPI {

	@ResponseBody
	@GetMapping("/getHabitacion/{id_cliente}")
	public HabitacionBean getHabitacionPorId(@PathVariable int id_cliente) {
		return  HabitacionDAO.getHabitacionPorId(id_cliente) ;
		
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
	
}
