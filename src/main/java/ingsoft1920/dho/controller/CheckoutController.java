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
import ingsoft1920.dho.Model.CheckoutModel;
import ingsoft1920.dho.bean.EstanciaBean;

	
	@Controller
	public class CheckoutController {

		
		final static Logger logger = LogManager.getLogger(LoginController.class.getName());
		
		
		@GetMapping("/checkout1")
		public String checkoutGet(Model model) {
			
			//vamos a llmar al checkinModel parar trabajar con el
			CheckoutModel checkout=new CheckoutModel();
			
			//conseguimos la lista de estancias que hay guardadas
			
			List<EstanciaBean>lista=checkout.getEstancias();
			
			//se lo añadimos al model
			
			model.addAttribute("lista", lista);
			
			//devolvemos la pagina que queremos que se muestre
			
			return "checkout";
		}

		@PostMapping("/checkout1")
		public String checkinPost(@Valid @ModelAttribute("EstanciaBean") EstanciaBean estanciaBean,
				Model model) {
		
		
			
		CheckoutModel checkoutModel=new CheckoutModel(estanciaBean);
		
		checkoutModel.cambiarEstadoEstancia(checkoutModel);
		
		return this.checkoutGet(model);
		
		}
	
	

}
	
