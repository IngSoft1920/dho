<<<<<<< HEAD:src/main/java/ingsoft1920/dho/EjemploApplication.java
package ingsoft1920.dho;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;


@Controller
@SpringBootApplication
public class EjemploApplication {
	final static Logger logger = LogManager.getLogger(EjemploApplication.class.getName());

	public static void main(String[] args) {
		logger.warn("Aplicacion iniciada");
		SpringApplication.run(EjemploApplication.class, args);
	}
}
=======
package ingsoft1920.dho;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import ingsoft1920.dho.bean.EmpleadoBean;
import ingsoft1920.dho.controller.PasarTurnos;
import ingsoft1920.dho.controller.PedirEmpleados;


@Controller
@SpringBootApplication
public class DhoApplication {
	final static Logger logger = LogManager.getLogger(DhoApplication.class.getName());
	
	public static void main(String[] args) {
		logger.warn("Aplicacion iniciada");
		SpringApplication.run(DhoApplication.class, args);
		//con esta linea se realiza una peticion en modo cliente a nuestro servidor
		//PasarTurnos.peticionPasarTurnos();
		
	}

	
	@GetMapping("/helloWorld")
	public String helloWorldController() {
		return "Hello world - DHO!";
	}
}
>>>>>>> develop:src/main/java/ingsoft1920/dho/DhoApplication.java