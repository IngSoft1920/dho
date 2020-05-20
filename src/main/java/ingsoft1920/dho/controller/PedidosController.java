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
import ingsoft1920.dho.bean.EmpleadoBean;
import ingsoft1920.dho.bean.EstanciaBean;
import ingsoft1920.dho.bean.IncidenciaBean;
import ingsoft1920.dho.bean.ServicioBean;
import ingsoft1920.dho.bean.ClienteBean;
import ingsoft1920.dho.DAO.ClienteDAO;



@Controller
public class PedidosController {

	
	final static Logger logger = LogManager.getLogger(LoginController.class.getName());
	String fechaHoy = LocalDate.now().toString();
	
	@GetMapping("/homePageDHO/menu/pedidos")
	public String checkinGet(Model model) {
		
		
		//vamos a llamar al checkinModel parar trabajar con el
		//CheckinModel pedidos=new PedidosModel();
		
		model.addAttribute("fechaHoy",fechaHoy);
		
		/*EstanciaBean estancia = EstanciaDAO.getEstanciaFecha(num_hab, fecha);
		ClienteBean cliente = ClienteDAO.getClienteHabitacionFecha(num_hab, fecha);
		List<ServicioBean> servicios= checkin.getClienteHabitacionFecha(num_hab, fecha);
		
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
		model.addAttribute("servicios",servicios);*/
		
		
		
		
		
		/*comentario:
		 * Ahora ya tienes el num_hab sobre la que has clickado y su fecha en string, para poder 
		 * tartarla como LocalDate tienes que hacer
		 * LocalDate fechaInicio= LocalDate.parse(fecha)
		 */
	
		return "pedidos";
	}

	@PostMapping("/homePageDHO/menu/pedidos/submit")
	public String checkinPost(Model model,@Valid@ModelAttribute ("hotel_id") int hotelId,@Valid@ModelAttribute ("fecha") String fechaString,
			@Valid@ModelAttribute ("lugar") String lugar,@Valid@ModelAttribute ("tomates1") int tomates1, @Valid@ModelAttribute ("specstom1") String specstom1,
			@Valid@ModelAttribute ("lechugas1") int lechugas1,@Valid@ModelAttribute ("specslec1") String specslec1,
			@Valid@ModelAttribute ("toallas1") int toallas1,@Valid@ModelAttribute ("specstoallas1") String specstoallas1,
			@Valid@ModelAttribute ("papel1") int papel1,@Valid@ModelAttribute ("specspapel1") String specspapel1,
			@Valid@ModelAttribute ("otros1") int otros1,@Valid@ModelAttribute ("specsotros1") String specsotros1) {
		//System.out.println(tomates);
		//System.out.println(lechugas);
		LocalDate fecha = LocalDate.parse(fechaString);
		int[] productos_id = {0,1,2,3,4};
		String[] nombresProductos = {"Tomates","Lechugas","Toallas","Papel","Otro"};
		int[] cantidades = {tomates1,lechugas1,toallas1,papel1,otros1};
		String[] especificaciones = {specstom1,specslec1,specstoallas1,specspapel1,specsotros1};
		if(lugar.equals("Restaurante")) lugar = "restaurante";
		PasarPedidos.pasarPedidos(hotelId, fecha, lugar, productos_id, nombresProductos, cantidades, especificaciones);
	
	return "redirect:/homePageDHO/menu/pedidos";

	
	}
	
	}