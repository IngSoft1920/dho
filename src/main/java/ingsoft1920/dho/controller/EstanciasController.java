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

		@GetMapping("/homePageDHO/menu/estancias1")
		public String estanciasGet(Model model) {

			EstanciasModel estancia = new EstanciasModel();
			
			return "estancia";

		}
		
		//QUEDA CAMBIAR COSAS PARA SPRING 3(LO COMENTADO)
		@PostMapping("/homePageDHO/menu/estancias1")
		public String checkinPost(
				@Valid @ModelAttribute("nombre")String nombre,
				@Valid @ModelAttribute("apellidos") String apellidos,
				@Valid @ModelAttribute("dni") String dni,
				@Valid @ModelAttribute("email") String email,
				@Valid @ModelAttribute("nacionalidad") String nacionalidad,
				@Valid @ModelAttribute("telefono") Integer telefono,
				Model model) {
			
			
			ClienteBean clienteBean=new ClienteBean();
			
		
			clienteBean.setNombre(nombre);
			clienteBean.setApellidos(apellidos);
			clienteBean.setDni(dni);
			clienteBean.setEmail(email);
			clienteBean.setNacionalidad(nacionalidad);
			clienteBean.setTelefono(telefono);
			
			
		
			//AQUI IRIA UNA PETICION A CM QUE LES PASA LOS DATOS DEL CLIENTE EXCEPTO SU ID Y PASSWORD
			//ELLOS NOS DEVOLVERIAN ESOS DATOS Y YA LOS PORDIAMOS INSERTAR TODO EN LA BBDD
			
			
			EstanciasModel estanciasModel = new EstanciasModel(clienteBean);
			
			int cliente_id=estanciasModel.nuevoCliente(estanciasModel);
			
			
			return "redirect:/homePageDHO/menu/registro/"+cliente_id;
			
		}

	}


