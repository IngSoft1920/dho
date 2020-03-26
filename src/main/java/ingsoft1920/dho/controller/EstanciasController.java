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
	import ingsoft1920.dho.bean.EstanciaBean;

	@Controller
	public class EstanciasController {

		final static Logger logger = LogManager.getLogger(LoginController.class.getName());

		@GetMapping("/homePageDHO/menu/estancias1")
		public String estanciasGet(Model model) {

			EstanciasModel estancia = new EstanciasModel();
			
			return "estancias1";

		}
		@PostMapping("/homePageDHO/menu/estancias1")
		public String checkinPost(@Valid @ModelAttribute("cliente_id") int cliente_id,
				@Valid @ModelAttribute("estancia_id") int estancia_id,
				@Valid @ModelAttribute("habitacion_id")int habitacion_id,
				@Valid @ModelAttribute("hotel_id") int hotel_id,
				@Valid @ModelAttribute("fecha_inicio") String fecha_inicio,
				@Valid @ModelAttribute("fecha_fin") String fecha_fin,
				@Valid @ModelAttribute("estado") String estado,
				@Valid @ModelAttribute("importe") int importe,
				@Valid @ModelAttribute("tipo_hab_id") int tipo_hab_id,
				Model model) {
			
			
			EstanciaBean estanciaBean=new EstanciaBean();
			
			System.out.println(fecha_inicio);
			System.out.println(fecha_fin);
			
			estanciaBean.setCliente_id(cliente_id);
			estanciaBean.setEstancia_id(estancia_id);
			estanciaBean.setHabitacion_id(habitacion_id);
			estanciaBean.setHotel_id(hotel_id);
			estanciaBean.setTipo_hab_id(tipo_hab_id);
			
			LocalDate date1=LocalDate.parse(fecha_inicio);
			estanciaBean.setFecha_inicio(java.sql.Date.valueOf(date1));
			System.out.println(estanciaBean.getFecha_inicio());
			
			LocalDate date2=LocalDate.parse(fecha_fin);
			estanciaBean.setFecha_fin(java.sql.Date.valueOf(date2));
			
		
			
			
			
			EstanciasModel estanciasModel = new EstanciasModel(estanciaBean);
			
			estanciasModel.nuevaEstancia(estanciasModel);
			
			
			return estanciasGet(model);
			
		}

	}


