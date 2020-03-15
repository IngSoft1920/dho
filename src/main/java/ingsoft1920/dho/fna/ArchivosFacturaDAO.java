package ingsoft1920.dho.fna;

import ingsoft1920.dho.controller.Conexion;

public class ArchivosFacturaDAO {
private static Conexion conexion= new Conexion(); 
	
	public ArchivosFacturaDAO(Conexion conexion) {
		this.conexion=conexion;
	}
	
	public static ArchivosFacturaBean getPDFByCod(int archivoCod) {
		return null;
		
	}
}
