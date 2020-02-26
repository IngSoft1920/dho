package ingsoft1920.dho.Model;

import java.util.ArrayList;
import java.util.List;

import ingsoft1920.dho.DAO.IncidenciaDAO;
import ingsoft1920.dho.DAO.TareaDAO;
import ingsoft1920.dho.bean.EmpleadoBean;
import ingsoft1920.dho.bean.IncidenciaBean;
import ingsoft1920.dho.bean.TareaBean;
import ingsoft1920.dho.controller.PedirEmpleados;


	public class AsignarTareasModel {

		private int id_incidencia;
	
		private int id_empleado;
	

	public AsignarTareasModel() {
	

	}
	

	public AsignarTareasModel(IncidenciaBean incidenciaBean, EmpleadoBean empleadoBean) {
		this.id_incidencia=incidenciaBean.getId_incidencia();
		this.id_empleado=empleadoBean.getId_empleado();
	}


	public List<IncidenciaBean> getIncidenciaSinAsignar(){
	
		List<IncidenciaBean> lista=IncidenciaDAO.getIncidenciasSinAsignar();
	
		return lista;
	}
	

	public List<IncidenciaBean> getIncidenciaAsignadas(){
	
		List<IncidenciaBean> lista=IncidenciaDAO.getIncidenciasAsignadas();
	
		return lista;
	}

	public List<EmpleadoBean> getEmpleados(){
	
	
		//con esta lineaa pedimos a la API de EM los empleados
		//de momento vamos a simularlo
	
		//List<EmpleadoBean> lista=PedirEmpleados.peticionPedirEmpleado();
	
		List<EmpleadoBean> lista=new ArrayList<EmpleadoBean>();
		lista.add(new EmpleadoBean(1,"COCINA"));
		lista.add(new EmpleadoBean(2, "LIMPIEZA"));
	
		return lista;
	}

	
	public void asignarTarea(AsignarTareasModel tareaModel) {
		
	TareaBean nuevaTarea=new TareaBean();
	
	IncidenciaBean incidenciautilizada=IncidenciaDAO.getIncidenciaDadoId(tareaModel.id_incidencia);
	
	nuevaTarea.setEstado(false);
	
	nuevaTarea.setTipo_tarea(incidenciautilizada.getTipo_incidencia());
	
	nuevaTarea.setLugar(incidenciautilizada.getLugar());
	
	nuevaTarea.setDescripcion(incidenciautilizada.getDescripcion());
	
	nuevaTarea.setFecha(incidenciautilizada.getFecha());
	
	nuevaTarea.setId_empleado(tareaModel.id_empleado);
	
	nuevaTarea.setId_incidencia(id_incidencia);
	
	TareaDAO.añadirTarea(nuevaTarea);
		
	}

	
	
}

	