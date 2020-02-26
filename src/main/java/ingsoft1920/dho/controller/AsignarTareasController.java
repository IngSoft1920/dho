package ingsoft1920.dho.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.origin.SystemEnvironmentOrigin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ingsoft1920.dho.Model.AsignarTareasModel;
import ingsoft1920.dho.bean.EmpleadoBean;
import ingsoft1920.dho.bean.EstanciaBean;
import ingsoft1920.dho.bean.IncidenciaBean;


@Controller
public class AsignarTareasController {
	final static Logger logger = LogManager.getLogger(LoginController.class.getName());
		
		
		@GetMapping("/homePageDHO/menu/asignarTareas")
		public String getIncidencias(Model model) {
			
			AsignarTareasModel asignarTareas=new AsignarTareasModel();
			
			List<IncidenciaBean> incidenciasSinAsignar= asignarTareas.getIncidenciaSinAsignar();
			
			List<IncidenciaBean> incidenciasAsignadas= asignarTareas.getIncidenciaAsignadas();
			
			List<EmpleadoBean> empleados=asignarTareas.getEmpleados();
			
			
			model.addAttribute("incidenciasSinAsignar", incidenciasSinAsignar);
			
			model.addAttribute("incidenciasAsignadas", incidenciasAsignadas);
			
			model.addAttribute("empleados", empleados);
			
			return "mostrarTareas";
		}
	
		
		@PostMapping("/homePageDHO/menu/asignarTareas")
		public String checkinPost(@Valid @ModelAttribute("IncidenciaBean") IncidenciaBean incidenciaBean,
				@Valid @ModelAttribute("EmpleadoBean") EmpleadoBean empleadoBean,  Model model) {
			
			
			AsignarTareasModel asignarTareas= new AsignarTareasModel(incidenciaBean, empleadoBean);
			
			asignarTareas.asignarTarea(asignarTareas);
			
			
			return getIncidencias(model);
			
		}
		
	
	
	
}
