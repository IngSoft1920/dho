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


public class LoginController {
 final static Logger logger = LogManager.getLogger(LoginController.class.getName());
 
 // @Autowired
 // LoginBean loginbean;
 
	 @GetMapping("/")
	 public String login(Model model) {
	 LoginBean loginBean = new LoginBean();
	 model.addAttribute("loginBean", loginBean);
	 model.addAttribute("mensajeError", "");
	 return "login";
	 }
	 
	 @PostMapping("/")
	 public String loginValida(@Valid @ModelAttribute("loginBean") LoginBean loginBean, Model model) {
		 String usuario = loginBean.getUsuario();
		 String pass = loginBean.getPassword();
		 
		 if (usuario.equals("usuario") && pass.equals("1234"))
			 return "redirect:menu"; 
		 else {
			 model.addAttribute("signupBean", loginBean);
			 model.addAttribute("mensajeError", "usuario o contraseña no validos");
			 return "login";
		 }
	 
	 
	 
	 }
}
