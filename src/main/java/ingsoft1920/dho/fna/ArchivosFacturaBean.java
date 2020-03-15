package ingsoft1920.dho.fna;

import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class ArchivosFacturaBean {

	private int archivoCod; 
	private String nombre_archivo;
	private Date fecha_creacion; 
	private int cliente_id; 
	private String enlace_descarga; 

	public ArchivosFacturaBean() {
		
	}
	
	public ArchivosFacturaBean(int archivoCod, String nombre_archivo, Date fecha_creacion, int cliente_id, String enlace_descarga) {
		this.archivoCod = archivoCod;
		this.nombre_archivo = nombre_archivo;
		this.fecha_creacion = fecha_creacion;
		this.cliente_id = cliente_id;
		this.enlace_descarga = enlace_descarga;
		}
	
	public int getArchivoCod() {
		return archivoCod;
	}
	public void setArchivoCod(int archivoCod) {
		this.archivoCod = archivoCod;
	}
	
	public String getNombre_archivo() {
		return nombre_archivo;
	}
	public void setNombre_archivo(String nombre_archivo) {
		this.nombre_archivo = nombre_archivo;
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
