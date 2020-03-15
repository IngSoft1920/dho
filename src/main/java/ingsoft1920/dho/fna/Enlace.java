package ingsoft1920.dho.fna;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class Enlace {
	@GetMapping("/download/f/{archivoCod}")
    public static void download(@PathVariable("archivoCod") String archivoCod, HttpServletResponse response) {
        try {
            // Pasa por filtro bbdd que traduce archivoCod a videoFileName, asi como comprueba
            // permisos etc...
            ArchivosFacturaBean archivo = ArchivosFacturaDAO.getPDFByCod(archivoCod);
            if (archivo == null)
                throw new Exception("Pdf no registrado en BBDD.");
            // Abrir fichero pedido
            File f = new File("files//archivo/" + archivoCod + ".pdf");
            if (!f.exists())
                throw new Exception("PDF does not exist.");
            // Obtenemos InputSteam del fichero
            InputStream is = new FileInputStream(f);
            // Marcamos respuesta en cabecera
            response.setContentType("aplication/pdf");
            response.setContentLength((int) f.length());
            response.setStatus(HttpStatus.OK.value());
            // Ponemos el strem del fichero en el stream de la respuesta
            IOUtils.copy(is, response.getOutputStream());
            // Flusheamos buffer para permitir que cliente empiece a recibir info
            response.flushBuffer();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            response.setStatus(HttpStatus.CONFLICT.value());
            response.setContentType("text/plain");
            try {
                PrintWriter w = response.getWriter();
                w.println(ex.getLocalizedMessage());
                response.flushBuffer();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
