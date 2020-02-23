package ingsoft1920.dho.controller;
import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ingsoft1920.dho.bean.LoginBean;

@Controller
public class LoginController {
 final static Logger logger = LogManager.getLogger(LoginController.class.getName());
 
//@Autowired
//LoginBean loginBean;
 
	 @GetMapping("/homePageDHO")
	 public String login(Model model) {
		 model.addAttribute("loginBean", new LoginBean());
		 model.addAttribute("mensajeError", "");
		 return "homePageDHO";
	 }
	
	 @PostMapping("/homePageDHO")
	 public String loginValida(@Valid @ModelAttribute("loginBean") LoginBean loginBean, Model model) {
		 String usuario = loginBean.getUsuario();
		 String pass = loginBean.getPassword();
		 
		 if (usuario.equals("usuario") && pass.equals("1234")) {
			 System.out.println("Acceso Correcto");
			 return "redirect:menu"; 
		 }
		 else {
			 model.addAttribute("signupBean", new LoginBean());
			 model.addAttribute("mensajeError", "usuario o contraseña no validos");
			 return "homePageDHO";
		 }
	 
	 
	 
	 }
}
