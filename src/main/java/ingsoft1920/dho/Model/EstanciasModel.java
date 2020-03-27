package ingsoft1920.dho.Model;
import java.sql.Date;
import java.sql.Time;
import java.util.List;

import ingsoft1920.dho.bean.EstanciaBean;
import ingsoft1920.dho.bean.ServicioBean;
import ingsoft1920.dho.DAO.ClienteDAO;
import ingsoft1920.dho.DAO.EstanciaDAO;
import ingsoft1920.dho.DAO.ServicioDAO;
import ingsoft1920.dho.bean.ClienteBean;

public class EstanciasModel {
	private int cliente_id;
	private String nombre;
	private String apellidos;
	private String dni;
	private String email;
	private String password;
	private String nacionalidad;
	private Integer telefono;
	
	public EstanciasModel() {
		
	}
	
public EstanciasModel(ClienteBean clienteBean) {
		
		this.cliente_id=clienteBean.getCliente_id();
		this.nombre=clienteBean.getNombre();
		this.apellidos=clienteBean.getApellidos();
		this.dni=clienteBean.getDni();
		this.email=clienteBean.getEmail();
		this.password=clienteBean.getPassword();
		this.nacionalidad=clienteBean.getNacionalidad();
		this.telefono=clienteBean.getTelefono();
		
		
	}

public void nuevoCliente(EstanciasModel estanciasModel) {
	
	ClienteDAO.anadirClienteSinID(new ClienteBean(cliente_id,nombre,apellidos,dni,email,password,nacionalidad,telefono));
	
		
	}


}


