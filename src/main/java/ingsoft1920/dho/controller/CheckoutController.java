package ingsoft1920.dho.controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

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
import ingsoft1920.dho.DAO.IncidenciaDAO;
import ingsoft1920.dho.Model.CheckinModel;
import ingsoft1920.dho.Model.CheckoutModel;
import ingsoft1920.dho.bean.EstanciaBean;
import ingsoft1920.dho.bean.IncidenciaBean;
import ingsoft1920.dho.bean.ClienteBean;
import ingsoft1920.dho.DAO.ClienteDAO;
import ingsoft1920.dho.bean.ServicioBean;
import ingsoft1920.dho.DAO.ServicioDAO;

	
	@Controller
	public class CheckoutController {

		
		final static Logger logger = LogManager.getLogger(LoginController.class.getName());
		
		
		@GetMapping("/homePageDHO/menu/disponibilidad/checkout1/{num_hab}/{fecha}")
		public String checkoutGet(Model model, @PathVariable int num_hab, @PathVariable String fecha) {
			
			//vamos a llmar al checkinModel parar trabajar con el
			CheckoutModel checkout=new CheckoutModel();
			
			EstanciaBean estancia = EstanciaDAO.getEstanciaFecha(num_hab, fecha);
			ClienteBean cliente = ClienteDAO.getClienteHabitacionFecha(num_hab, fecha);
			List<ServicioBean> servicios= checkout.getClienteHabitacionFecha(num_hab, fecha);
			
			
			model.addAttribute("estancia_id",estancia.getEstancia_id());
			model.addAttribute("cliente_id",estancia.getCliente_id());
			model.addAttribute("fecha_inicio",estancia.getFecha_inicio());
			model.addAttribute("fecha_fin",estancia.getFecha_fin());
			model.addAttribute("habitacion_id", estancia.getHabitacion_id());
			model.addAttribute("importe",estancia.getImporte());
			model.addAttribute("hotel_id",estancia.getHotel_id());
			model.addAttribute("nombre", cliente.getNombre());
			model.addAttribute("apellidos", cliente.getApellidos());
			model.addAttribute("DNI", cliente.getDni());
			model.addAttribute("email", cliente.getEmail());
			model.addAttribute("nacionalidad",cliente.getNacionalidad());
			model.addAttribute("telefono", cliente.getTelefono());
			model.addAttribute("preferencias",cliente.getPreferencias());
			model.addAttribute("servicios",servicios);
			model.addAttribute("fecha_aux", fecha);
			
			
			
			return "checkout";
		}

		@PostMapping("/homePageDHO/menu/disponibilidad/checkout1/{num_hab}/{fecha}")
		public String checkoutPost(Model model,@PathVariable int num_hab,@PathVariable String fecha) {
		
		
	
		CheckoutModel checkoutModel=new CheckoutModel();
		
		EstanciaBean estancia=EstanciaDAO.getEstanciaFecha(num_hab, fecha);
		
		checkoutModel.cambiarEstadoEstancia(estancia.getEstancia_id());

		
		return "redirect:/homePageDHO/menu/disponibilidad/checkout1/{num_hab}/{fecha}";
		
		}
		
		
		
		
		/*este boton va a funcionar de la siguiente forma, se va a poder clickar sobre el para
		 * generar la incidencia de realizar el servicio de la habitacion, 
		 * (comportamiento avanzado:si no se ha realizado hoy este servicio para la habitacion
		 * se creara una incidencia autmaticamente y te dejara ir a la pagina de gestion de las
		 * incidencias, en caso contrario te dira que ya has asignado el servicio) 
		 */
		@PostMapping("/homePageDHO/menu/disponibilidad/checkout1/servivioHabitaciones/{num_hab}/{fecha}/{hotel_id}/{cliente_id}")
		public String checkoutPost(Model model,@PathVariable int num_hab,@PathVariable String fecha,
				@PathVariable int hotel_id,@PathVariable int cliente_id) {
		
			
		
		
			//comprobamos si ya se ha hecho limpieza de la habitacion ese dia
			
			if (IncidenciaDAO.BuscarServicioDeHabitacionEnFechayLugar("H "+num_hab, fecha) !=-1) {
				//ya se ha asiganado la incidencia
				
				
				
				model.addAttribute("realizada", "YA SE HA ASIGANDO HOY" );
				
				return checkoutGet(model, num_hab, fecha);
				
			}else {
				
				//vamos a crear la incidencia
				
				System.out.print("Estoy aqui");
				
				IncidenciaBean nuevaIncidencia= new IncidenciaBean(0, "limpieza", "limpieza rutinaria habitacion", "H "+num_hab,
						java.sql.Date.valueOf(LocalDate.parse(fecha)), hotel_id,java.sql.Time.valueOf(LocalTime.now()) , cliente_id);
			

				//hay que añadirla a la bbdd
				
				IncidenciaDAO.añadirIncidencia(nuevaIncidencia);
				
				//ya esta añadidia
				
				return "redirect:/homePageDHO/menu/reservas1";
				
				
			}
			
		
		
		}
	
	

}
	
