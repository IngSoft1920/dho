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
	@PostMapping("/homePageDHO/menu/reservas1")
	public String checkinPost(@Valid @ModelAttribute("fecha_servicioString") String fecha,
			@Valid @ModelAttribute("hora_salidaString") String horaSalida,
			@Valid @ModelAttribute("horaString") String hora,
			@Valid @ModelAttribute("cliente_id") int cliente_id,
			@Valid @ModelAttribute("estancia_id") int estancia_id,
			@Valid @ModelAttribute("id_ServicoHotel") int id_ServicoHotel,
			@Valid @ModelAttribute("items") String items,
			@Valid @ModelAttribute("lugar") String lugar,
			@Valid @ModelAttribute("platos") String platos,
			@Valid @ModelAttribute("tipo_servicio") String tipo_servicio,
			Model model) {
		
		
		ServicioBean servicioBean=new ServicioBean();
		
		System.out.println(fecha);
		
		
		servicioBean.setCliente_id(cliente_id);
		servicioBean.setEstancia_id(estancia_id);
		servicioBean.setId_ServicoHotel(id_ServicoHotel);
		servicioBean.setItems(items);
		servicioBean.setLugar(lugar);
		servicioBean.setPlatos(platos);
		servicioBean.setTipo_servicio(tipo_servicio);
		
		
		LocalDate date=LocalDate.parse(fecha);
		servicioBean.setFecha_servicio( java.sql.Date.valueOf(date));
		System.out.println(servicioBean.getFecha_servicio());
		
		LocalTime horaTime=LocalTime.parse(hora);
		servicioBean.setHora(java.sql.Time.valueOf(horaTime));
		
		LocalTime horaSalidaTime=LocalTime.parse(horaSalida);
		servicioBean.setHora_salida(java.sql.Time.valueOf(horaSalidaTime));
		
		
		
		ReservasModel reservasModel = new ReservasModel(servicioBean);
		
		reservasModel.nuevoServicio(reservasModel);
		
		
		return reservasGet(model);
		
	}

}
