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

import ingsoft1920.dho.Model.CheckinModel;
import ingsoft1920.dho.bean.EstanciaBean;


@Controller
public class CheckinController {

	
	final static Logger logger = LogManager.getLogger(LoginController.class.getName());
	
	
	@GetMapping("/homePageDHO/menu/checkin1/{num_hab}/{fecha}")
	public String checkinGet(Model model,@PathVariable int num_hab, @PathVariable String fecha) {
		
		//vamos a llmar al checkinModel parar trabajar con el
		CheckinModel checkin=new CheckinModel();
		
		
		/*comentario:
		 * Ahora ya tienes el num_hab sobre la que has clickado y su fecha en string, para poder 
		 * tartarla como LoaclDate tienes que hacer
		 * LocalDate fechaInicio= LocalDate.parse(fecha)
		 */
		
		
		return "checkin";
	}

	@PostMapping("/homePageDHO/menu/checkin1/{num_hab}/{fecha}")
	public String checkinPost(@Valid @ModelAttribute("EstanciaBean") EstanciaBean estanciaBean,
			Model model) {
		
		CheckinModel checkinModel=new CheckinModel(estanciaBean);
	
		System.out.println("ckeckin:\n"+estanciaBean);
	
	checkinModel.cambiarEstadoEstancia(checkinModel);
	
	return "redirect:/homePageDHO/menu";

	
	}
	
	}
