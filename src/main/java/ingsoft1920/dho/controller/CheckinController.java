package ingsoft1920.dho.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ingsoft1920.dho.DAO.EstanciaDAO;
import ingsoft1920.dho.DAO.HabitacionDAO;
import ingsoft1920.dho.DAO.HotelDAO;
import ingsoft1920.dho.Model.AsignarTareasModel;
import ingsoft1920.dho.Model.CheckinModel;
import ingsoft1920.dho.bean.EmpleadoBean;
import ingsoft1920.dho.bean.EstanciaBean;
import ingsoft1920.dho.bean.IncidenciaBean;



@Controller
public class CheckinController {

	
	final static Logger logger = LogManager.getLogger(LoginController.class.getName());
	
	
	@GetMapping("/homePageDHO/menu/disponibilidad/checkin1/{num_hab}/{fecha}")
	public String checkinGet(Model model,@PathVariable int num_hab, @PathVariable String fecha) {
		
		
		//vamos a llamar al checkinModel parar trabajar con el
		CheckinModel checkin=new CheckinModel();
		
		EstanciaBean estancia = EstanciaDAO.getEstanciaFecha(num_hab, fecha);
		
		model.addAttribute("estancia_id",estancia.getEstancia_id());
		model.addAttribute("cliente_id",estancia.getCliente_id());
		model.addAttribute("fecha_inicio",estancia.getFecha_inicio());
		model.addAttribute("fecha_fin",estancia.getFecha_fin());
		model.addAttribute("habitacion_id", estancia.getHabitacion_id());
		model.addAttribute("importe",estancia.getImporte());
		model.addAttribute("hotel_id",estancia.getHotel_id());
		
		
		
		
		/*comentario:
		 * Ahora ya tienes el num_hab sobre la que has clickado y su fecha en string, para poder 
		 * tartarla como LocalDate tienes que hacer
		 * LocalDate fechaInicio= LocalDate.parse(fecha)
		 */
	
		return "checkin";
	}

	@PostMapping("/homePageDHO/menu/disponibilidad/checkin1/{num_hab}/{fecha}")
	public String checkinPost(@Valid @ModelAttribute("EstanciaBean") EstanciaBean estanciaBean,
			Model model) {
		
		
		
		
		
		CheckinModel checkinModel=new CheckinModel(estanciaBean);
	
		System.out.println("ckeckin:\n"+estanciaBean);
	
	checkinModel.cambiarEstadoEstancia(checkinModel);
	
	return "redirect:/homePageDHO/menu/disponibilidad";

	
	}
	
	}
