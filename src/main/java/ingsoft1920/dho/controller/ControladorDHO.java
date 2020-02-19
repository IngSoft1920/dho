package ingsoft1920.dho.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ingsoft1920.dho.bean.ReservaBean;

@Controller
public class ControladorDHO {
	@ResponseBody
	@GetMapping("/homePageDHO")
	public String homePageDHO() {
		return "homePageDHO";
		
	}
	@ResponseBody
	@GetMapping("/homePageDHO/menu")
	public String menu() {
		return "menu";
		
	}
	@ResponseBody
	@GetMapping("/homePageDHO/menu/checkin")
	public String checkin() {
		return "checkin";
		
	}
	@ResponseBody
	@GetMapping("/homePageDHO/menu/checkout")
	public String checkout() {
		return "checkout";
		
	}
	@ResponseBody
	@PostMapping("/homePageDHO/hacerReserva")
	public String hacerReservaSolicitud(ReservaBean reserva) {
		System.out.println("reserva recibida:\n"+reserva);
		return "hacerReserva";
	}
	
	
}
