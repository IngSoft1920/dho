package ingsoft1920.dho.bean; 
 
import org.springframework.stereotype.Component; 
 
@Component 
public class TareaBean { 
 
	 
	private int id_incidencia; 
	private int id_empleado; 
	private String descripcion; 
	private int tipo_tarea;//se puede poner o un string o asignar un numero a los tipos que hay 
	private String lugar;//formato: HABITACION id_habitacion 
	private boolean estado; 
	 
	 
	 
	public TareaBean() { 
	 
	} 
	 
	 
	public TareaBean( int id_incidencia, int id_empleado, String descripcion, int tipo_tarea, String lugar, 
			boolean estado) { 
		 
		this.id_incidencia = id_incidencia; 
		this.id_empleado = id_empleado; 
		this.descripcion = descripcion; 
		this.tipo_tarea = tipo_tarea; 
		this.lugar = lugar; 
		this.estado = estado; 
	} 
	 
	 
	public TareaBean (int id_empleado, int tipo_tarea, String lugar) { 
		this.id_empleado = id_empleado; 
		this.tipo_tarea = tipo_tarea; 
		this.lugar = lugar; 
	} 
	 
	 
	public boolean estaRelleno(TareaBean tarea) { 
		return true; 
	} 
	 
	 
	 
	 
	public int getId_incidencia() { 
		return id_incidencia; 
	} 
	 
	 
	public void setId_incidencia(int id_incidencia) { 
		this.id_incidencia = id_incidencia; 
	} 
	 
	 
	public int getId_empleado() { 
		return id_empleado; 
	} 
	 
	 
	public void setId_empleado(int id_empleado) { 
		this.id_empleado = id_empleado; 
	} 
	 
	 
	public String getDescripcion() { 
		return descripcion; 
	} 
	 
	 
	 
	public void setDescripcion(String descripcion) { 
		this.descripcion = descripcion; 
	} 
	 
	 
	public int getTipo_tarea() { 
		return tipo_tarea; 
	} 
	 
	 
	public void setTipo_tarea(int tipo_tarea) { 
		this.tipo_tarea = tipo_tarea; 
	} 
	 
	 
	public String getLugar() { 
		return lugar; 
	} 
	 
	 
	public void setLugar(String lugar) { 
		this.lugar = lugar; 
	} 
	 
	 
	public boolean isEstado() { 
		return estado; 
	} 
	 
	 
	public void setEstado(boolean estado) { 
		this.estado = estado; 
	} 
	 
	 
	 
	 
	 
} 
