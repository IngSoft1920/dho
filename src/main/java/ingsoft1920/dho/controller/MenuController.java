package ingsoft1920.dho.controller;

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
		 //Variables
	 	List<EstanciaBean> listaEstancias= EstanciaDAO.geEstanciaBeans();
	 	String primero = listaEstancias.get(0).getEstado();
	 	String colorCelda="";
	 	
	 	//if(true) { colorCelda="#EC8B19"; }
	 	if (primero.equals("check in")) { colorCelda="#dc2816"; } //rojo
	 	else if (primero.equals("reserva")) { colorCelda="#EC8B19"; } //naranja
	 	else if (primero.equals("check out")) { colorCelda="#27a912"; } //verde
	 	
	 	System.out.print(colorCelda);
	 	//Añadir a model
	 	model.addAttribute("listaEstancias", listaEstancias);
	 	model.addAttribute("colorCelda", colorCelda);
		 return "menu";
	 }
}