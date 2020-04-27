package ingsoft1920.dho.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ingsoft1920.dho.DAO.EstanciaDAO;
import ingsoft1920.dho.DAO.HabitacionDAO;
import ingsoft1920.dho.DAO.HotelDAO;
import ingsoft1920.dho.bean.HabitacionBean;


@Controller
@ControllerAdvice 
public class MenuController {
	 final static Logger logger = LogManager.getLogger(LoginController.class.getName());
	 
	 static String Colores[] = {"#05FF00", "#7CFF00", "#B8FF00", "#DBFF00",
			 "#FFF900", "#FFCB00", "#FFA700", "#FF6500" ,"#FF3900" ,"#FF0800","#FF0800"};
	 public static LocalDate fechaConsulta = LocalDate.now();
	 static String meses[]={"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
	 public static LocalDate fechaHoy = LocalDate.now();
	 
	 @GetMapping("homePageDHO/menu")
	 public static String menu(Model model) 
	 {	
		String fechaConsultaString = fechaConsulta.toString();
		model.addAttribute("fechaConsultaString",fechaConsultaString);
		model.addAttribute("Dia",fechaConsulta.getDayOfMonth());
		model.addAttribute("Mes",meses[fechaConsulta.getMonthValue()-1]);
		model.addAttribute("Año",fechaConsulta.getYear());
		//String link = "homePageDHO/menu/{" + fechaConsultaString+"}";
		ArrayList<Double> listaOcupaciones = HotelDAO.porcentajeOcupacionMes(fechaConsulta.getMonthValue(), fechaConsulta.getYear());
		String[] misColores = new String[listaOcupaciones.size()];
		
		int[] misPorcentajes = new int[listaOcupaciones.size()];
		for(int i = 0;i<listaOcupaciones.size();i++)
		{
			misPorcentajes[i]=listaOcupaciones.get(i).intValue();
			//System.out.println(misPorcentajes[i]+"\n");
			misColores[i] = Colores[misPorcentajes[i]/10];
		}
		//model.addAttribute("link", link);
		model.addAttribute("misPorcentajes", misPorcentajes);
		model.addAttribute("misColores", misColores);
			
		return "menu";
	 }
	 
	@PostMapping(value = "homePageDHO/menu/ant/{fechaConsultaString}")
	public String diaAnterior(  @PathVariable String fechaConsultaString, Model model) {
		fechaConsulta = LocalDate.parse(fechaConsultaString).plusMonths(-1);
	    //System.out.println(fechaConsultaString);
	    return "redirect:/homePageDHO/menu/";
	}
		 
	@PostMapping(value = "homePageDHO/menu/post/{fechaConsultaString}")
	public String diaPosterior(  @PathVariable String fechaConsultaString, Model model) {
		fechaConsulta = LocalDate.parse(fechaConsultaString).plusMonths(1);
		//System.out.println(fechaConsultaString);
		return "redirect:/homePageDHO/menu/";
	}
	 
	@InitBinder
	public void bindingPreparation(WebDataBinder binder) {
	DateFormat dateFormat = new SimpleDateFormat("dd-MM-YYYY");
	CustomDateEditor orderDateEditor = new CustomDateEditor(dateFormat, true);
	binder.registerCustomEditor(LocalDate.class, orderDateEditor);
	} 
	
	@PostMapping(value = "homePageDHO/menu/{fechaConsultaString}")
    public String buscaDía(  @PathVariable String fechaConsultaString, Model model) {
		fechaConsulta = LocalDate.parse(fechaConsultaString);
        //System.out.println(fechaConsultaString);
        return  "redirect:/homePageDHO/menu/disponibilidad/"+fechaConsultaString;
    }
	/* 
	@PostMapping(value = "homePageDHO/menu/buscar/{fechaConsultaString}")
    public String buscarFecha( @PathVariable String fechaConsultaString, Model model) {
		fechaConsulta = LocalDate.parse(fechaConsultaString);
		System.out.println(fechaConsultaString);
		//fechaConsulta = fechaConsultaString;
        //System.out.println(fechaConsultaString);
        return "redirect:/homePageDHO/menu";
    }
	*/
	 
	 
}









