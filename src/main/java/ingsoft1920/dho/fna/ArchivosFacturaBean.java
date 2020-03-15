package ingsoft1920.dho.fna;

import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class ArchivosFacturaBean {

	private String archivoCod;
	private Date fecha_creacion; 
	private int cliente_id; 
	private String enlace_descarga; 

	public ArchivosFacturaBean() {
		
	}
	
	public ArchivosFacturaBean(String archivoCod, Date fecha_creacion, int cliente_id, String enlace_descarga) {
		this.archivoCod = archivoCod;
		this.fecha_creacion = fecha_creacion;
		this.cliente_id = cliente_id;
		this.enlace_descarga = enlace_descarga;
		}
	
	public String getArchivoCod() {
		return archivoCod;
	}
	public void setArchivoCod(String archivoCod) {
		this.archivoCod = archivoCod;
	}
	
	public Date getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(Date fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	
	public int getCliente_id() {
		return cliente_id;
	}
	public void setCliente_id(int cliente_id) {
		this.cliente_id = cliente_id;
	}
	
	public String getEnlace_descarga() {
		return enlace_descarga;
	}
	public void setEnlace_descarga(String enlace_descarga) {
		this.enlace_descarga = enlace_descarga;
	}
	
	@Override 
	public String toString() { 
		return "ArchivosFactura [archivoCod=" + archivoCod + ", fecha_creacion=" + fecha_creacion + ", cliente_id=" + cliente_id 
				+ ", enlace_descarga=" + enlace_descarga + "]"; 
	} 
}
