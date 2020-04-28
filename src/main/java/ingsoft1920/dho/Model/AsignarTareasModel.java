package ingsoft1920.dho.Model;

import java.util.ArrayList;
import java.util.List;

import ingsoft1920.dho.DAO.HotelDAO;
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
		
		List<EmpleadoBean> lista=new ArrayList<EmpleadoBean>();
		
		int cont=HotelDAO.devolverElNumeroDeHoteles();
		for(int i=1; i<=cont;i++) {
			lista.addAll(PedirEmpleados.peticionPedirEmpleado(i));
		}
	
		
	/*
		
		List<EmpleadoBean> lista=new ArrayList<EmpleadoBean>();
		lista.add(new EmpleadoBean(1,"COCINA",1));
		lista.add(new EmpleadoBean(2, "LIMPIEZA",1));
	
	*/
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
	
	nuevaTarea.setHora(incidenciautilizada.getHora());
	
	nuevaTarea.setHoraFin(incidenciautilizada.getHora().toLocalTime().plusMinutes(30).toString());
	
	TareaDAO.añadirTarea(nuevaTarea);
		
	}

	
	
}

	