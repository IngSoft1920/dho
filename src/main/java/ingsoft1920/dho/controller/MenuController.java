package ingsoft1920.dho.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ingsoft1920.dho.DAO.EstanciaDAO;
import ingsoft1920.dho.bean.EstanciaBean;
import ingsoft1920.dho.bean.LoginBean;


@Controller
public class MenuController {
	 final static Logger logger = LogManager.getLogger(LoginController.class.getName());

	 @GetMapping("homePageDHO/menu")
	 public String menu(Model model) 
	 {		
		int numHab=49;
		String estado="";
	 	List<String> listaEstados= EstanciaDAO.getEstadoHabitaciones(LocalDate.now().toString());
	 	String[] links = new String[numHab];
	 	String[] coloresCelda = new String[numHab];
	 
	 	
	 	for(int i=0; i<numHab;i++) 
	 	{
	 		estado=listaEstados.get(i);
	 		
		 	if (estado.equals("check in")) { coloresCelda[i]="#dc2816"; links[i]="/homePageDHO/menu/checkout1"; } //rojo
		 	else if (estado.equals("reserva")) { coloresCelda[i]="#EC8B19";links[i]="/homePageDHO/menu/checkin1";} //naranja
		 	else if (estado.equals("check out")) { coloresCelda[i]="#27a912";links[i]="/homePageDHO/menu/checkin1";} //verde
	
	 	}

	 	System.out.println(coloresCelda.length);
	 	//Añadir a model
	 	model.addAttribute("coloresCelda", coloresCelda);
	 	model.addAttribute("links", links);
		return "menu";
	 }
	 
	 
	 
	 
	 
	 
	 
	 
}