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
	public String checkinPost(Model model,@Valid@ModelAttribute ("hotel_id") int hotelId,@Valid@ModelAttribute ("idProveedor") int idProveedor,@Valid@ModelAttribute ("fecha") String fechaString,
			@Valid@ModelAttribute ("lugar") String lugar,
			@Valid@ModelAttribute ("tomates") int tomates, @Valid@ModelAttribute ("specstom") String specstom,
			@Valid@ModelAttribute ("lechugas") int lechugas,@Valid@ModelAttribute ("specslec") String specslec,
			@Valid@ModelAttribute ("toallas") int toallas,@Valid@ModelAttribute ("specstoallas") String specstoallas,
			@Valid@ModelAttribute ("pan") int pan,@Valid@ModelAttribute ("specspan") String specspan,
			@Valid@ModelAttribute ("huevos") int huevos,@Valid@ModelAttribute ("specshuevos") String specshuevos,
			@Valid@ModelAttribute ("leche") int leche,@Valid@ModelAttribute ("specsleche") String specsleche,
			@Valid@ModelAttribute ("aceite") int aceite,@Valid@ModelAttribute ("specsaceite") String specsaceite,
			@Valid@ModelAttribute ("queso") int queso,@Valid@ModelAttribute ("specsqueso") String specsqueso,
			@Valid@ModelAttribute ("carne") int carne,@Valid@ModelAttribute ("specscarne") String specscarne,
			@Valid@ModelAttribute ("refrescos") int refrescos,@Valid@ModelAttribute ("specsrefrescos") String specsrefrescos,
			@Valid@ModelAttribute ("jabon") int jabon,@Valid@ModelAttribute ("specsjabon") String specsjabon,
			@Valid@ModelAttribute ("papel") int papel,@Valid@ModelAttribute ("specspapel") String specspapel,
			@Valid@ModelAttribute ("aseo") int aseo,@Valid@ModelAttribute ("specsaseo") String specsaseo,
			@Valid@ModelAttribute ("otros") int otros,@Valid@ModelAttribute ("specsotros") String specsotros) {
		LocalDate fecha = LocalDate.parse(fechaString);
		int[] productos_id = {1,71,77,10,13,14,15,12,76,78,79,80,81};
		String[] nombresProductos = {"Tomates","Lechugas","Toallas","Pan","Huevos","Leche","Aceite","Queso","Carne","Refrescos","Jabon","Papel","Aseo"};
		int[] cantidades = {tomates,lechugas,toallas,pan,huevos,leche,aceite,queso,carne,refrescos,jabon,papel,aseo,otros};
		String[] especificaciones = {specstom,specslec,specstoallas,specspan,specshuevos,specsleche,specsaceite,specsqueso,specscarne,specsrefrescos,specsjabon,specspapel,specsaseo};
		//System.out.println(lugar);
		PasarPedidos.pasarPedidos(hotelId, fecha, lugar, productos_id, nombresProductos, cantidades, especificaciones,idProveedor);
	
	return "redirect:/homePageDHO/menu/pedidos";

	
	}
	
}
