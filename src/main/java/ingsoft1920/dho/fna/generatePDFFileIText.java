package ingsoft1920.dho.fna;

import com.itextpdf.text.Anchor;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.List;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;

import ingsoft1920.dho.controller.Conexion;

import java.io.*;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Example of using the iText library to work with PDF documents on Java, lets
 * you create, analyze, modify and maintain documents in this format. Ejemplo de
 * uso de la librería iText para trabajar con documentos PDF en Java, nos
 * permite crear, analizar, modificar y mantener documentos en este formato.
 *
 * @author xules You can follow me on my website http://www.codigoxules.org/en
 *         Puedes seguirme en mi web http://www.codigoxules.org
 */

@Controller
public class generatePDFFileIText {
	// Fonts definitions (Definición de fuentes).
	private static final Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 26, Font.BOLDITALIC);
	private static final Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);

	private static final Font categoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
	private static final Font subcategoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
	private static final Font blueFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);
	private static final Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

	private static final String iTextExampleImage = "/home/xules/codigoxules/iText-Example-image.png";
	int hola = 21;

	/**
	 * We create a PDF document with iText using different elements to learn 
	 * to use this library.
	 * Creamos un documento PDF con iText usando diferentes elementos para aprender 
	 * a usar esta librería.
	 * @param pdfNewFile  <code>String</code> 
	 *      pdf File we are going to write. 
	 *      Fichero pdf en el que vamos a escribir. 
	 */
	/*
     /*
	 * ArchivosFactura
	 * archivoCod String
	 * fecha_creacion DATE
	 * cliente_id int
	 * enlaceDescarga String
	 */
	public void createPDF(int cliente_id) {
		// We create the document and set the file name.        
		// Creamos el documento y generamos el nombre del fichero.
		String name=UUID.randomUUID().toString();
		File file=new File("files//"+name+".pdf");
		Date date=new Date(LocalDate.now().getYear()-1900,LocalDate.now().getMonthValue()-1,LocalDate.now().getDayOfMonth());
		try {
			Document document = new Document();
			try {

				PdfWriter.getInstance(document, new FileOutputStream(file));

			} catch (FileNotFoundException fileNotFoundException) {
				System.out.println("No such file was found to generate the PDF "
						+ "(No se encontró el fichero para generar el pdf)" + fileNotFoundException);
			}
			document.open();
			// We add metadata to PDF
			// Añadimos los metadatos del PDF
			document.addTitle("Table export to PDF (Exportamos la tabla a PDF)");
			document.addSubject("Using iText (usando iText)");
			document.addKeywords("Java, PDF, iText");
			document.addAuthor("Código Xules");
			document.addCreator("Código Xules");

			//Añadimos titulo
			Chunk chunk = new Chunk("FACTURA", chapterFont);
			chunk.setBackground(BaseColor.GRAY);

			//Creamos el primer capitulo 
			Chapter chapter = new Chapter(new Paragraph(chunk), 1);
			chapter.setNumberDepth(0);
			//Subtitulo (Todas las Facturas)
			chapter.add(new Paragraph("Todas Las Facturas:", subcategoryFont));
			//Obtenemos todas las facturas
			for (FacturaBean elem: FacturaDAO.todasFacturasCliente(cliente_id)) {
				chapter.add(new Paragraph(elem.toString(), paragraphFont));
			}
			//Subtitulo (Facturas por pagar)
			chapter.add(new Paragraph("Facturas Por Pagar:", subcategoryFont));
			int pago_total=0;
			for (FacturaBean elem: FacturaDAO.porPagarFacturasCliente(cliente_id)) {
				pago_total+=elem.getPrecio();
				chapter.add(new Paragraph(elem.toString(), paragraphFont));
			}
			//Subtitulo (Precio de la estancia)
			chapter.add(new Paragraph("Precio de la estancia :", subcategoryFont));
			EstanciaBean aux = FacturaDAO.precioEstanciaCliente(cliente_id);
			pago_total+=aux.getImporte();
			chapter.add(new Paragraph(aux.toString(), paragraphFont));
			//Total a pagar
			chapter.add(new Paragraph("TOTAL: "+pago_total, paragraphFont));
			document.add(chapter);
			document.close();
			System.out.println("Your PDF file has been generated!(¡Se ha generado tu hoja PDF!");
			//Ahora añadimos a la base de datos el PDF creado
			Conexion conexion = new Conexion();
			if (conexion.getConexion()==null) 
				conexion.conectar();
			PreparedStatement stm=null; 
			try {  
				stm=conexion.getConexion().prepareStatement("INSERT INTO ArchivosFactura values (?,?,?,?)"); 
				stm.setString(1,name); 
				stm.setDate(2, date); 
				stm.setInt(3, cliente_id); 
				stm.setString(4, ""); 
				stm.executeUpdate(); 

			}  
			catch (SQLException ex){  
				System.out.println("SQLException: " + ex.getMessage()); 
			} finally { // it is a good idea to release resources in a finally block  
				if (stm != null) { try {  stm.close(); } catch (SQLException sqlEx) { }  stm = null; }  
			} 
			conexion.desconectar();
		} catch (DocumentException documentException) {
			System.out.println("The file not exists (Se ha producido un error al generar un documento): " + documentException);
		}
	}

	/**
	 * @param args the command line arguments
	 */

	@ResponseBody
	@GetMapping("/generatePDF/{cliente_id}")
	public String generatePDF(@PathVariable("cliente_id") int cliente_id) {
		generatePDFFileIText generatePDFFileIText = new generatePDFFileIText();
		generatePDFFileIText.createPDF(1);
		return "";

	}
}
