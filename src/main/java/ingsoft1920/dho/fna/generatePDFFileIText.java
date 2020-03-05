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
import java.util.ArrayList; 

/**
 * Example of using the iText library to work with PDF documents on Java, 
 * lets you create, analyze, modify and maintain documents in this format.
 * Ejemplo de uso de la librería iText para trabajar con documentos PDF en Java, 
 * nos permite crear, analizar, modificar y mantener documentos en este formato.
 *
 * @author xules You can follow me on my website http://www.codigoxules.org/en
 * Puedes seguirme en mi web http://www.codigoxules.org
 */
public class generatePDFFileIText {
    // Fonts definitions (Definición de fuentes).
    private static final Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 26, Font.BOLDITALIC);
    private static final Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);
        
    private static final Font categoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 18, Font.BOLD);
    private static final Font subcategoryFont = new Font(Font.FontFamily.TIMES_ROMAN, 16, Font.BOLD);
    private static final Font blueFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.NORMAL, BaseColor.RED);    
    private static final Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
    
    private static final String iTextExampleImage = "/home/xules/codigoxules/iText-Example-image.png";
    int hola=21;
    /**
     * We create a PDF document with iText using different elements to learn 
     * to use this library.
     * Creamos un documento PDF con iText usando diferentes elementos para aprender 
     * a usar esta librería.
     * @param pdfNewFile  <code>String</code> 
     *      pdf File we are going to write. 
     *      Fichero pdf en el que vamos a escribir. 
     */
    public void createPDF(File pdfNewFile) {
        // We create the document and set the file name.        
        // Creamos el documento e indicamos el nombre del fichero.
        try {
            Document document = new Document();
            try {

                PdfWriter.getInstance(document, new FileOutputStream(pdfNewFile));

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
        	for (FacturaBean elem: FacturaDAO.todasFacturasCliente(1)) {
        		chapter.add(new Paragraph(elem.toString(), paragraphFont));
        	}
            //Subtitulo (Facturas por pagar)
            chapter.add(new Paragraph("Facturas Por Pagar:", subcategoryFont));
        	int pago_total=0;
        	for (FacturaBean elem: FacturaDAO.porPagarFacturasCliente(1)) {
        		pago_total+=elem.getPrecio();
        		chapter.add(new Paragraph(elem.toString(), paragraphFont));
        	}
        	chapter.add(new Paragraph("Me pagais esto ahora mismo o no os vais de aqui con vida: "+pago_total, paragraphFont));
            document.add(chapter);
            document.close();
            System.out.println("Your PDF file has been generated!(¡Se ha generado tu hoja PDF!");
        } catch (DocumentException documentException) {
            System.out.println("The file not exists (Se ha producido un error al generar un documento): " + documentException);
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        generatePDFFileIText generatePDFFileIText = new generatePDFFileIText();
        generatePDFFileIText.createPDF(new File("C:\\Users\\sergi\\OneDrive\\Desktop\\e.pdf"));
    }
}

