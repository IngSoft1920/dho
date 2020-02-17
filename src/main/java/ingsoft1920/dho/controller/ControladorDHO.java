package ingsoft1920.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import ingsoft1920.bean.Reserva;

@Controller
public class ControladorDHO {
	
	@GetMapping("/homePageDHO")
	public String homePageDHO() {
		return "homePageDHO.jsp";
		
	}
	
	@GetMapping("/homePageDHO/hacerReserva")
	public String hsacerReserva() {
		return "homePageDHO/hscerReserva.jsp";
		
	}
	
	@PostMapping("/homePageDHO/hacerReserva")
	public String hsacerReservaSolicitud(Reserva reserva) {
		System.out.println("reserva recibida:\n"+reserva);
		return "homePageDHO/hacerReserva.jsp";
	}
	
	
}
