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
	import org.springframework.web.bind.annotation.PostMapping;

	import ingsoft1920.dho.Model.AsignarTareasModel;
	import ingsoft1920.dho.Model.ReservasModel;
	import ingsoft1920.dho.bean.EmpleadoBean;
	import ingsoft1920.dho.bean.IncidenciaBean;
	import ingsoft1920.dho.bean.ServicioBean;
	import ingsoft1920.dho.Model.EstanciasModel;
	import ingsoft1920.dho.bean.ClienteBean;

	@Controller
	public class EstanciasController {

		final static Logger logger = LogManager.getLogger(LoginController.class.getName());

		@GetMapping("/homePageDHO/menu/disponibilidad/estancias1")
		public String estanciasGet(Model model) {

			EstanciasModel estancia = new EstanciasModel();
			
			return "estancia";

		}
		
		@PostMapping("/homePageDHO/menu/disponibilidad/estancias1")
		public String checkinPost(
				@Valid @ModelAttribute("nombre")String nombre,
				@Valid @ModelAttribute("apellidos") String apellidos,
				@Valid @ModelAttribute("dni") String dni,
				@Valid @ModelAttribute("email") String email,
				@Valid @ModelAttribute("nacionalidad") String nacionalidad,
				@Valid @ModelAttribute("telefono") Integer telefono,
				@Valid @ModelAttribute("password") String password,
				Model model) {
			
			
			ClienteBean clienteBean=new ClienteBean();
			
		
			clienteBean.setNombre(nombre);
			clienteBean.setApellidos(apellidos);
			clienteBean.setDni(dni);
			clienteBean.setEmail(email);
			clienteBean.setNacionalidad(nacionalidad);
			clienteBean.setTelefono(telefono);
			clienteBean.setPassword(password);
			
			
			clienteBean.setCliente_id(EnviarRegistro.peticionEnviarRegistro(clienteBean));
			
			EstanciasModel estanciasModel = new EstanciasModel(clienteBean);
			
			estanciasModel.nuevoCliente(estanciasModel);
			
			
			return "redirect:/homePageDHO/menu/registro/"+clienteBean.getCliente_id();
			
		}

	}


