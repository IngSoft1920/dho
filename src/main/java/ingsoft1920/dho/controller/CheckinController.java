package ingsoft1920.dho.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ingsoft1920.dho.Model.CheckinModel;
import ingsoft1920.dho.bean.EstanciaBean;


@Controller
public class CheckinController {

	
	final static Logger logger = LogManager.getLogger(LoginController.class.getName());
	
	
	@GetMapping("/homePageDHO/menu/checkin1")
	public String checkinGet(Model model) {
		
		//vamos a llmar al checkinModel parar trabajar con el
		CheckinModel checkin=new CheckinModel();
		
		//conseguimos la lista de estancias que hay guardadas
		
		List<EstanciaBean>listaSinHacerCheckIn=checkin.getEstanciasSinHacerCheckIn();
		
		List<EstanciaBean>listaConCheckIn=checkin.getEstanciasConCheckIn();
		
		
		//se lo añadimos al model
		
		model.addAttribute("listaSinHacerCheckIn", listaSinHacerCheckIn);
		
		model.addAttribute("listaConCheckIn", listaConCheckIn);
		
		//devolvemos la pagina que queremos que se muestre
		
		return "checkin";
	}

	@PostMapping("/homePageDHO/menu/checkin1")
	public String checkinPost(@Valid @ModelAttribute("EstanciaBean") EstanciaBean estanciaBean,
			Model model) {
		
		CheckinModel checkinModel=new CheckinModel(estanciaBean);
	
		System.out.println("ckeckin:\n"+estanciaBean);
	
	checkinModel.cambiarEstadoEstancia(checkinModel);
	
	return this.checkinGet(model);

	
	}
	
	}
