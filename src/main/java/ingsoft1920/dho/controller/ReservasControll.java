package ingsoft1920.dho.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;


import ingsoft1920.dho.Model.ReservasModel;
import ingsoft1920.dho.bean.ServicioBean;

@Controller
public class ReservasControll {

	final static Logger logger = LogManager.getLogger(LoginController.class.getName());

	@GetMapping("/homePageDHO/menu/reservas1")
	public String reservasGet(Model model) {

		ReservasModel checkin = new ReservasModel();

		List<ServicioBean> listaReservas = checkin.getReservas();

		// se lo añadimos al model

		model.addAttribute("listaReservas", listaReservas);

		// devolvemos la pagina que queremos que se muestre

		return "reservas";
	}

}