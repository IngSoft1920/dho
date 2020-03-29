package ingsoft1920.dho.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import ingsoft1920.dho.DAO.EstanciaDAO;
import ingsoft1920.dho.DAO.HabitacionDAO;
import ingsoft1920.dho.DAO.HotelDAO;
import ingsoft1920.dho.bean.EstanciaBean;





@Controller
public class CompletarEstanciaController {

	//CAMPO QUE GUARDA EL CLIENTE_ID DE LA ESTANCIA ACTUAL, SE ACTUALIZA CADA VEZ QUE LLEGA UNA NUEVA ESTANCIA
	private static int CLIENTE_ID;
	
	final static Logger logger = LogManager.getLogger(LoginController.class.getName());
	
	
	@GetMapping("/homePageDHO/menu/registro/{id_cliente}")
	public static String getEstancia(Model model,@PathVariable int id_cliente) {
		
	
		CLIENTE_ID=id_cliente;
		
		System.out.print(CLIENTE_ID);
		
		return "completar-estancia";
	}

	//COMPLETAR PARA EL TERCER SPRING
	@PostMapping("/homePageDHO/menu/registro/{id_cliente}")
	public static String registrarEstancia(Model model,@Valid@ModelAttribute ("Fecha_entrada") String fecha_entrada,
			@Valid@ModelAttribute("Fecha_salida") String fecha_salida,@Valid@ModelAttribute ("Num_personas") int personas,
			@ModelAttribute("Tipo_hab_String") String Thabitacion,@ModelAttribute("Nombre_Hotel") String hotel,
			@ModelAttribute("Num_Habitacion") int habitacion_id) {
		
		
		
		int hotel_id=HotelDAO.ConseguirIDHotelDadoNombre(hotel);
		
		int reserva_id=EstanciaDAO.idUltimaEstancia();
		
		int tipo_hab_id=HabitacionDAO.idTipoHabitacion(Thabitacion);
		
		LocalDate fechaInicio= LocalDate.parse(fecha_entrada);
		
		LocalDate fechaSalida=LocalDate.parse(fecha_salida);
		
		
		
		//AQUI IRIA UNA PETICION A CM QUE LES PASA LOS DATOS DE LA RESERVA Y QUE ESPERA RECIBIR EL IMPORTE Y RESEERVA_ID
		//PARA QUE ASI LA BBDD ESTE SINCORNIZADA CON LA SUYA Y E
		
		EstanciaDAO.anadirEstanciaBean(new EstanciaBean(reserva_id, habitacion_id, CLIENTE_ID, hotel_id,java.sql.Date.valueOf(fechaInicio)
				, java.sql.Date.valueOf(fechaSalida), "reserva", 0));
		
		//EstanciaDAO.anadirEstancia(reserva_id, CLIENTE_ID, hotel_id, fecha_entrada, fecha_salida, tipo_hab_id, 0);
		
		return "redirect:/homePageDHO/menu";
		
	}
	


}
