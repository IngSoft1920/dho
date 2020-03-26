package ingsoft1920.dho.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ingsoft1920.dho.bean.ReservaBean;

@Controller
public class ControladorDHO {
	

	@PostMapping("/homePageDHO/hacerReserva")
	public String hacerReservaSolicitud(Model model, ReservaBean reserva) {
		System.out.println("reserva recibida:\n"+reserva);
		return "hacerReserva";
	}
	
	
}
