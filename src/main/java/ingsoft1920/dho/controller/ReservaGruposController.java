package ingsoft1920.dho.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.origin.SystemEnvironmentOrigin;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ingsoft1920.dho.DAO.EstanciaDAO;
import ingsoft1920.dho.DAO.GruposDAO;
import ingsoft1920.dho.Model.AsignarTareasModel;
import ingsoft1920.dho.Model.CheckinModel;
import ingsoft1920.dho.Model.GruposModel;
import ingsoft1920.dho.bean.EmpleadoBean;
import ingsoft1920.dho.bean.EstanciaBean;
import ingsoft1920.dho.bean.GruposBean;
import ingsoft1920.dho.bean.IncidenciaBean;


@Controller
public class ReservaGruposController {
	final static Logger logger = LogManager.getLogger(LoginController.class.getName());
		
		
		@GetMapping("/homePageDHO/menu/reservaGrupos")
		public String getReservaGrupos(Model model) {
			
			GruposModel grupos = new GruposModel();
			
			
			List<GruposBean> listaGrupos =grupos.getGrupos();
			
			
			

						
			model.addAttribute("listaGrupos", listaGrupos);
			
			return "reservaGrupos";
		}
	
		@PostMapping("/homePageDHO/menu/reservaGrupos")
		public String ReservaGruposPost (Model model,	int grupo_id){	
	
		
			GruposModel grupoModel = new GruposModel();
			
			
			GruposBean grupos = GruposDAO.reservasPorGrupoID(grupo_id);
			grupos.setEstado(grupoModel.cambiarEstado(grupo_id, grupos.getEstado()));
			
		
			
			
			return "redirect:/homePageDHO/menu/reservaGrupos";
		}
		
		
		
	
	
	
}
