package ingsoft1920.dho.bean;


import org.springframework.stereotype.Component; 

@Component 
public class IncidenciaBean {

	
	/*representa el numero de incidencia dentro de la tabla incidencia
	 * lo utilizo ahora pero cuando este la base de datos se sustituye
	 * por una consulta que te diga el id de la ultima incidencia asignada
	 */
	public static int ContInc=0;
	
	private int id_incidencia;
	
	private int tipo_incidencia;
	
	private String descripcion;
	
	private String lugar;
	
	private String fecha;
	
	
	
	
	

	public IncidenciaBean() {
		
	}

	public IncidenciaBean(int id_incidencia, int tipo_incidencia, String descripcion, String lugar, String fecha) {
		this.id_incidencia = id_incidencia;
		this.tipo_incidencia = tipo_incidencia;
		this.descripcion = descripcion;
		this.lugar = lugar;
		this.fecha = fecha;
	}
	
	
	public int getId_incidencia() {
		return id_incidencia;
	}

	public void setId_incidencia(int id_incidencia) {
		this.id_incidencia = id_incidencia;
	}

	public int getTipo_incidencia() {
		return tipo_incidencia;
	}

	public void setTipo_incidencia(int incidencia) {
		this.tipo_incidencia = incidencia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
	
	
	
	
}
