package ingsoft1920.dho.fna;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.io.File;
import java.sql.Date;
import java.util.UUID;

import com.itextpdf.text.Paragraph;

public class Prueba {
	public static void main(String[] args) throws Exception {
		/*
        ArchivosFacturaBean archivo = ArchivosFacturaDAO.getPDFByCod(3);
        System.out.println(archivo.getArchivoCod());
        if (archivo == null)
            throw new Exception("Pdf no registrado en BBDD.");
        ArchivosFacturaDAO.eliminarPDF(archivo.getArchivoCod());
        // Abrir fichero pedido
        /*
        File f = new File("files//" + archivo.getArchivoCod() + ".pdf");
        if (!f.exists())
            throw new Exception("PDF does not exist.");
	*/
		int cliente_id=99;
		int estancia_id=1;
		for (FacturaBean elem: FacturaDAO.todasFacturasCliente(cliente_id,estancia_id)) {
			System.out.println(elem.toString());
		}
		EstanciaBean aux = FacturaDAO.precioEstanciaCliente(cliente_id,estancia_id);
		System.out.println(aux.toString());
	}
}
