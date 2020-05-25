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

import ingsoft1920.dho.DAO.EstanciaDAO;
import ingsoft1920.dho.DAO.ServiciosDelHotelDAO;
import ingsoft1920.dho.Model.AsignarTareasModel;
import ingsoft1920.dho.Model.ReservasModel;
import ingsoft1920.dho.bean.EmpleadoBean;
import ingsoft1920.dho.bean.EstanciaBean;
import ingsoft1920.dho.bean.IncidenciaBean;
import ingsoft1920.dho.bean.ServicioBean;

@Controller
public class ReservasControll {

	final static Logger logger = LogManager.getLogger(LoginController.class.getName());

	@GetMapping("/homePageDHO/menu/reservas1")
	public String reservasGet(Model model) {

		ReservasModel reservas = new ReservasModel();

		List<ServicioBean> listaReservas = reservas.getReservas();

		// se lo añadimos al model

		model.addAttribute("listaReservas", listaReservas);

		// devolvemos la pagina que queremos que se muestre

		return "reservas";
	}
	
	//Preguntar lo de lugar
	@PostMapping("/homePageDHO/menu/reservas1")
	public String checkinPost(@Valid @ModelAttribute("fecha_servicioString") String fecha,
			@Valid @ModelAttribute("horaString") String hora,
			@Valid @ModelAttribute("nombre_servicio") String servicio,
			@Valid @ModelAttribute("num_habitacion") int num_hab,
			@Valid @ModelAttribute("nombre_hotel") String hotel,
			Model model) {
		
		
		ServicioBean servicioBean=new ServicioBean();
		
		System.out.println(fecha);
		
		EstanciaBean estancia=EstanciaDAO.getEstanciaFecha(num_hab, fecha);
		
		
		
		int estado= ServiciosDelHotelDAO.id_servicioHotelPorNombreyServicio(hotel, servicio);
		switch (estado) {
		case -2:
			model.addAttribute("fallo","El servicio especificado para el hotel no existe" );
			//en caso de fallo evitamos que se guarde el serivicio
			estancia = null;
			break;
		case -1:
			model.addAttribute("fallo","El hotel especificado no existe" );
			//en caso de fallo evitamos que se guarde el serivicio
			estancia = null;
			break;

		default:
			break;
		}
		
		if (estancia!= null) {
			
		servicioBean.setCliente_id(estancia.getCliente_id());
		servicioBean.setEstancia_id(estancia.getEstancia_id());
		servicioBean.setLugar(servicio);
		servicioBean.setTipo_servicio("normal");
		
		servicioBean.setId_ServicioHotel(estado);
		
		LocalDate date=LocalDate.parse(fecha);
		servicioBean.setFecha_servicio( java.sql.Date.valueOf(date));
		
		LocalTime horaTime=LocalTime.parse(hora);
		servicioBean.setHora(java.sql.Time.valueOf(horaTime));	
		ReservasModel reservasModel = new ReservasModel(servicioBean);
		reservasModel.nuevoServicio(reservasModel);
		
		}
		return reservasGet(model);
		
	}

}
