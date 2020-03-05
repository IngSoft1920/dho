package ingsoft1920.dho.fna;

import com.itextpdf.text.Paragraph;

public class Prueba {
	public static void main(String[] args) {
    	for (FacturaBean elem: FacturaDAO.todasFacturasCliente(1)) {
    		System.out.println(elem.toString());
    	}
	}

}
