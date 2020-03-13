
package ingsoft1920.dho;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

import ingsoft1920.dho.controller.Conexion;
import ingsoft1920.dho.controller.DhoAPI;


@Controller
@SpringBootApplication
public class DhoApplication {
	final static Logger logger = LogManager.getLogger(DhoApplication.class.getName());

	public static void main(String[] args) {
		logger.warn("Aplicacion iniciada");
		String servidor,puerto,usuario,contraseña,baseDeDatos;
		servidor="piedrafita.ls.fi.upm.es";
		puerto="8000";
		usuario="dho2";
		contraseña="ingSoft20dho2.336";
		baseDeDatos="dho";
		Conexion conexion = new Conexion();
		Conexion.init(servidor,puerto,usuario,contraseña,baseDeDatos);
		Conexion.conectar();
		SpringApplication.run(DhoApplication.class, args);
		
		String res=DhoAPI.serviciosDisponibles("hotel_prueba");
		
		System.out.println(res);
	}
	
	
}
