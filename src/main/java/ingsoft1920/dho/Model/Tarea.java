package ingsoft1920.dho.Model;

import java.time.LocalDate; 

public class Tarea { 
	private int tarea_id; 
	private int incidencia_id; 
	private int empleado_id; 
	private String descripcion; 
	private String lugar_tarea; 
	private boolean estado; 
	private LocalDate fecha_tarea; 
	private String tipo_tarea; 
	 
	public Tarea(int tarea_id, int incidencia_id, int empleado_id, String descripcion, String lugar_tarea, 
			boolean estado, LocalDate fecha_tarea, String tipo_tarea) { 
		super(); 
		this.tarea_id = tarea_id; 
		this.incidencia_id = incidencia_id; 
		this.empleado_id = empleado_id; 
		this.descripcion = descripcion; 
		this.lugar_tarea = lugar_tarea; 
		this.estado = estado; 
		this.fecha_tarea = fecha_tarea; 
		this.tipo_tarea = tipo_tarea; 
	} 
 
	public int getTarea_id() { 
		return tarea_id; 
	} 
	public void setTarea_id(int tarea_id) { 
		this.tarea_id = tarea_id; 
	} 
	public int getIncidencia_id() { 
		return incidencia_id; 
	} 
	public void setIncidencia_id(int incidencia_id) { 
		this.incidencia_id = incidencia_id; 
	} 
	public int getEmpleado_id() { 
		return empleado_id; 
	} 
	public void setEmpleado_id(int empleado_id) { 
		this.empleado_id = empleado_id; 
	} 
	public String getDescripcion() { 
		return descripcion; 
	} 
	public void setDescripcion(String descripcion) { 
		this.descripcion = descripcion; 
	} 
	public String getLugar_tarea() { 
		return lugar_tarea; 
	} 
	public void setLugar_tarea(String lugar_tarea) { 
		this.lugar_tarea = lugar_tarea; 
	} 
	public boolean isEstado() { 
		return estado; 
	} 
	public void setEstado(boolean estado) { 
		this.estado = estado; 
	} 
	public LocalDate getFecha_tarea() { 
		return fecha_tarea; 
	} 
	public void setFecha_tarea(LocalDate fecha_tarea) { 
		this.fecha_tarea = fecha_tarea; 
	} 
	public String getTipo_tarea() { 
		return tipo_tarea; 
	} 
	public void setTipo_tarea(String tipo_tarea) { 
		this.tipo_tarea = tipo_tarea; 
	} 
	@Override 
	public String toString() { 
		return "Tarea [tarea_id=" + tarea_id + ", incidencia_id=" + incidencia_id + ", empleado_id=" + empleado_id 
				+ ", descripcion=" + descripcion + ", lugar_tarea=" + lugar_tarea + ", estado=" + estado 
				+ ", fecha_tarea=" + fecha_tarea + ", tipo_tarea=" + tipo_tarea + "]"; 
	} 
 
} 
