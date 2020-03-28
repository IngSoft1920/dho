package ingsoft1920.dho.fna;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;
import java.util.UUID;

import com.itextpdf.text.Paragraph;

public class Prueba {
	public static void main(String[] args) {
		ArchivosFacturaBean archivo = ArchivosFacturaDAO.getPDFByCod(1);
		System.out.println(archivo.toString());
	}

}
