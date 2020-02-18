package ingsoft1920.dho.bean;

import org.springframework.stereotype.Component;

@Component
public class EmpleadoBean {

	/*esta clase a diferencia de otros Beans no representa una tabla que tengamos en la base de datos,
	 * pero si la necesitamos para trabajar con sus datos
	 */
	
	
	private int id_empleado;
	private int tipo_trabajo;
	
	
	
	
	public EmpleadoBean() {
		
	}
	
	
	public EmpleadoBean(int id_empleado, int tipo_trabajo) {
		this.id_empleado = id_empleado;
		this.tipo_trabajo = tipo_trabajo;
	}
	
	public int getId_empleado() {
		return id_empleado;
	}
	
	
	public void setId_empleado(int id_empleado) {
		this.id_empleado = id_empleado;
	}
	
	public int getTipo_trabajo() {
		return tipo_trabajo;
	}
	
	public void setTipo_trabajo(int tipo_trabajo) {
		this.tipo_trabajo = tipo_trabajo;
	}
	
	
	
	
}
