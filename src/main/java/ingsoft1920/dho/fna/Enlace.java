package ingsoft1920.dho.fna;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Enlace {

	@ResponseBody
	@GetMapping("/download/f/{cliente_id}/{estancia_id}")
	public static void download(@PathVariable("cliente_id") int cliente_id,@PathVariable("estancia_id") int estancia_id, HttpServletResponse response) {
		try {
			// Pasa por filtro bbdd que traduce archivoCod a ArchivosFacturaBean
			ArchivosFacturaBean archivo = ArchivosFacturaDAO.getPDFByCod(cliente_id);
			File f;
			if(archivo!=null) {//Eliminar
				ArchivosFacturaDAO.eliminarPDF(archivo.getArchivoCod());
				f = new File("/hs/dho/files/" + archivo.getArchivoCod() + ".pdf");
				f.delete();
			}
			HttpClient client= new HttpClient("http://piedrafita.ls.fi.upm.es:7001/generatePDF/"+cliente_id+"/"+estancia_id,"GET");
			int respCode = client.getResponseCode();
			if(respCode!=200) {
				throw new Exception("Error en la conexion");
			}
			archivo = ArchivosFacturaDAO.getPDFByCod(cliente_id);
			// Abrir fichero pedido
			f = new File("/hs/dho/files/" + archivo.getArchivoCod() + ".pdf");
			if (!f.exists())
				throw new Exception("PDF does not exist.");

			// Obtenemos InputSteam del fichero
			InputStream is = new FileInputStream(f);
			// Marcamos respuesta en cabecera
			response.setContentType("application/pdf");
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
				response.setContentType("aplication/pdf");
				response.flushBuffer();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
