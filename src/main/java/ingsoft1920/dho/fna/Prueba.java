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
        ArchivosFacturaBean archivo = ArchivosFacturaDAO.getPDFByCod(1);
        if (archivo == null)
            throw new Exception("Pdf no registrado en BBDD.");
        // Abrir fichero pedido
        File f = new File("files//archivo.pdf");
        if (!f.exists())
            throw new Exception("PDF does not exist.");
	}

}
