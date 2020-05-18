package ingsoft1920.dho.controller;

import java.time.LocalDate;
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
import ingsoft1920.dho.DAO.HabitacionDAO;
import ingsoft1920.dho.DAO.HotelDAO;
import ingsoft1920.dho.DAO.ServicioDAO;
import ingsoft1920.dho.Model.AsignarTareasModel;
import ingsoft1920.dho.Model.CheckinModel;
import ingsoft1920.dho.Model.PreCheckinModel;
import ingsoft1920.dho.bean.EmpleadoBean;
import ingsoft1920.dho.bean.EstanciaBean;
import ingsoft1920.dho.bean.IncidenciaBean;
import ingsoft1920.dho.bean.ServicioBean;
import ingsoft1920.dho.bean.ClienteBean;
import ingsoft1920.dho.DAO.ClienteDAO;



@Controller
public class Precheckincontroller {

	
	final static Logger logger = LogManager.getLogger(LoginController.class.getName());
	
	
	@GetMapping("/homePageDHO/menu/disponibilidad/precheckin/{num_hab}/{fecha}")
	public String precheckinGet(Model model,@PathVariable int num_hab, @PathVariable String fecha) {
		
		
		//vamos a llamar al checkinModel parar trabajar con el
		PreCheckinModel precheckin=new PreCheckinModel();
		
		EstanciaBean estancia = EstanciaDAO.getEstanciaFecha(num_hab, fecha);
		ClienteBean cliente = ClienteDAO.getClienteHabitacionFecha(num_hab, fecha);
		List<ServicioBean> servicios= precheckin.getClienteHabitacionFecha(num_hab, fecha);
		
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
		
		
		
		
		
		/*comentario:
		 * Ahora ya tienes el num_hab sobre la que has clickado y su fecha en string, para poder 
		 * tartarla como LocalDate tienes que hacer
		 * LocalDate fechaInicio= LocalDate.parse(fecha)
		 */
	
		return "precheckin";
	}

	@PostMapping("/homePageDHO/menu/disponibilidad/precheckin/{num_hab}/{fecha}")
	public String precheckinPost(Model model,@PathVariable int num_hab,@PathVariable String fecha) {
		
		
		
		
		
		PreCheckinModel precheckinModel=new PreCheckinModel();
	
	
		EstanciaBean estancia=EstanciaDAO.getEstanciaFecha(num_hab, fecha);

		precheckinModel.cambiarEstadoEstancia(estancia.getEstancia_id());
	
	return "redirect:/homePageDHO/menu/disponibilidad/";

	
	}
	
	}
