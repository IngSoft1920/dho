package ingsoft1920.dho;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class DhoApplication {
	final static Logger logger = LogManager.getLogger(DhoApplication.class.getName());
	
	public static void main(String[] args) {
		logger.warn("Aplicacion iniciada");
		SpringApplication.run(DhoApplication.class, args);
	}

}
