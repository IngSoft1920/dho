package ingsoft1920.dho.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ingsoft1920.dho.bean.ReservaBean;

@Controller
public class ControladorDHO {
	
	@GetMapping("/homePageDHO")
	public String homePageDHO() {
		return "homePageDHO";
		
	}
	
	@GetMapping("/homePageDHO/hacerReserva")
	public String hacerReserva() {
		return "hacerReserva";
		
	}
	
	@PostMapping("/homePageDHO/hacerReserva")
	public String hacerReservaSolicitud(ReservaBean reserva) {
		System.out.println("reserva recibida:\n"+reserva);
		return "hacerReserva";
	}
	
	
}
