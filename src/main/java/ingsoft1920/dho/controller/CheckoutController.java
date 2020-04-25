package ingsoft1920.dho.controller;

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
import ingsoft1920.dho.Model.CheckoutModel;
import ingsoft1920.dho.bean.EstanciaBean;

	
	@Controller
	public class CheckoutController {

		
		final static Logger logger = LogManager.getLogger(LoginController.class.getName());
		
		
		@GetMapping("/homePageDHO/menu/checkout1/{num_hab}/{fecha}")
		public String checkoutGet(Model model, @PathVariable int num_hab, @PathVariable String fecha) {
			
			//vamos a llmar al checkinModel parar trabajar con el
			CheckoutModel checkout=new CheckoutModel();
		
			
			return "checkout";
		}

		@PostMapping("/homePageDHO/menu/checkout1/{num_hab}/{fecha}")
		public String checkoutPost(@Valid @ModelAttribute("EstanciaBean") EstanciaBean estanciaBean,
				Model model) {
		
		
	
		CheckoutModel checkoutModel=new CheckoutModel(estanciaBean);
		
		checkoutModel.cambiarEstadoEstancia(checkoutModel);

		System.out.println("ckeckout:\n"+estanciaBean);
		
		return "redirect:/homePageDHO/menu";
		
		}
	
	

}
	
