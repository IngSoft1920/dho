package ingsoft1920.dho.bean;

import org.springframework.stereotype.Component;

@Component
public class EmpleadoBean {

	/*esta clase a diferencia de otros Beans no representa una tabla que tengamos en la base de datos,
	 * pero si la necesitamos para trabajar con sus datos
	 */
	
	
	private int id_empleado;
	private String tipo_trabajo;
	
	
	
	
	public EmpleadoBean() {
		
	}
	
	
	public EmpleadoBean(int id_empleado, String tipo_trabajo) {
		this.id_empleado = id_empleado;
		this.tipo_trabajo = tipo_trabajo;
	}
	
	public int getId_empleado() {
		return id_empleado;
	}
	
	
	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}
	
	public String getTipo_trabajo() {
		return tipo_trabajo;
	}
	
	public void setTipo_trabajo(String tipo_trabajo) {
		this.tipo_trabajo = tipo_trabajo;
	}
	
	@Override 
	public String toString() { 
		return "Empleado [id_empleado=" +id_empleado + ", tipo_trabajo=" + tipo_trabajo +  "]"; 
	}
	
	
}
