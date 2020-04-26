package ingsoft1920.dho.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ingsoft1920.dho.DAO.EstanciaDAO;
import ingsoft1920.dho.DAO.HabitacionDAO;
import ingsoft1920.dho.bean.HabitacionBean;


@Controller
@ControllerAdvice 
public class DisponibilidadController {
	 final static Logger logger = LogManager.getLogger(LoginController.class.getName());

	 static String ROJO = "#dc2816";
	 static String NARANJA = "#EC8B19";
	 static String VERDE = "#27a912";
	 
	 public static LocalDate fechaConsulta = LocalDate.now();
	 static String meses[]={"enero","febrero","marzo","abril","mayo","junio","julio","agosto","septiembre","octubre","noviembre","diciembre"};
	 public static LocalDate fechaHoy = LocalDate.now();
	 
	 @GetMapping("homePageDHO/menu/disponibilidad")
	 public static String menu(Model model) 
	 {	
		String fechaConsultaString = fechaConsulta.toString();
		model.addAttribute("fechaConsultaString",fechaConsultaString);
		model.addAttribute("Dia",fechaConsulta.getDayOfMonth());
		model.addAttribute("Mes",meses[fechaConsulta.getMonthValue()-1]);
		model.addAttribute("Año",fechaConsulta.getYear());
		
		model.addAttribute("DiaHoy",fechaHoy.getDayOfMonth());
		model.addAttribute("MesHoy",meses[fechaHoy.getMonthValue()-1]);
		model.addAttribute("AñoHoy",fechaHoy.getYear());
		int numHab=49;
		String estado="";
	 	List<String> listaEstados= EstanciaDAO.getEstadoHabitaciones(fechaConsulta.toString());
	 	String[] links = new String[numHab];
	 	String[] coloresCelda = new String[numHab];
	 	ArrayList<HabitacionBean> habitaciones; 
	 	for(int i=0; i<numHab;i++) 
	 	{
	 		estado=listaEstados.get(i);
	 		habitaciones= HabitacionDAO.getHabitacionByHotel(99);
		 	if (estado.equals("check in")) { coloresCelda[i]=ROJO; links[i]="/homePageDHO/menu/disponibilidad/checkout1/"+
		 			habitaciones.get(i).getId_habitacion()+"/"+fechaConsultaString; } // Rojo
		 	else if (estado.equals("reserva")) { coloresCelda[i]=NARANJA;links[i]="/homePageDHO/menu/disponibilidad/checkin1"+"/"+
		 			habitaciones.get(i).getId_habitacion()+"/"+fechaConsultaString;} // Naranja
		 	else if (estado.equals("check out")) { coloresCelda[i]=VERDE;links[i]="/homePageDHO/menu/disponibilidad/estancias1";} // Verde
	
	 	}

	 	//Añadir a model
	 	model.addAttribute("coloresCelda", coloresCelda);
	 	model.addAttribute("links", links);
	 	model.addAttribute("hoy", fechaConsulta);
		return "disponibilidad";
	 }
	 
	
	@PostMapping(value = "homePageDHO/menu/disponibilidad/ant/{fechaConsultaString}")
    public String diaAnterior(  @PathVariable String fechaConsultaString, Model model) {
        fechaConsulta = LocalDate.parse(fechaConsultaString).plusDays(-1);
        //System.out.println(fechaConsultaString);
        return "redirect:/homePageDHO/menu/disponibilidad";
    }
	 
	@PostMapping(value = "homePageDHO/menu/disponibilidad/post/{fechaConsultaString}")
    public String diaPosterior(  @PathVariable String fechaConsultaString, Model model) {
        fechaConsulta = LocalDate.parse(fechaConsultaString).plusDays(1);
        //System.out.println(fechaConsultaString);
        return "redirect:/homePageDHO/menu/disponibilidad";
    }
	
	@InitBinder
	public void bindingPreparation(WebDataBinder binder) {
	  DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
	  CustomDateEditor orderDateEditor = new CustomDateEditor(dateFormat, true);
	  binder.registerCustomEditor(LocalDate.class, orderDateEditor);
	}
	
	@PostMapping(value = "homePageDHO/menu/disponibilidad/buscar")
    public String buscarFecha( @ModelAttribute("fechaConsultaString") String fechaConsultaString, Model model) {
		fechaConsulta = LocalDate.parse(fechaConsultaString);
		//System.out.println(fechaConsultaString);
		//fechaConsulta = fechaConsultaString;
        //System.out.println(fechaConsultaString);
        return "redirect:/homePageDHO/menu/disponibilidad";
    }
	
	@PostMapping(value = "homePageDHO/menu/disponibilidad/hoy")
    public String buscarFecha(Model model) {
		fechaConsulta = fechaHoy;
		//System.out.println(fechaConsultaString);
		//fechaConsulta = fechaConsultaString;
        //System.out.println(fechaConsultaString);
        return "redirect:/homePageDHO/menu/disponibilidad";
    }
	 
	 
	 
}









