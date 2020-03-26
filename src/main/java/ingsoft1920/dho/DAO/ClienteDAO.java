package ingsoft1920.dho.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import ingsoft1920.dho.bean.ClienteBean;
import ingsoft1920.dho.bean.EstanciaBean;
import ingsoft1920.dho.controller.Conexion;

public class ClienteDAO {private static Conexion conexion = new Conexion();

public ClienteDAO(Conexion conexion) {
	this.conexion = conexion;
}

//Dado el id de una estancia devuelve todos los datos del cliente
public static ClienteBean datosCliente(int estancia_id) {
	ClienteBean res= new ClienteBean();
	if (conexion.getConexion() == null)
		conexion.conectar();
	
	
	java.sql.Statement stmt = null;
	ResultSet rs = null;
	try {
		
		stmt= conexion.getConexion().createStatement();
		rs=stmt.executeQuery("SELECT * FROM Cliente as c join Estancia as est on est.cliente_id=c.cliente_id where est.estancia_id= "+estancia_id);
		if(rs.next()) {
			res.setCliente_id(rs.getInt("cliente_id"));
			res.setNombre(rs.getString("nombre"));
			res.setApellidos(rs.getString("apellidos"));
			res.setDni(rs.getString("DNI"));
			res.setEmail(rs.getString("email"));
			res.setNacionalidad(rs.getString("nacionalidad"));
			res.setPassword(rs.getString("password"));
			res.setTelefono(rs.getInt("telefono"));
		}
	}catch (SQLException ex) {
		System.out.println("SQLException: " + ex.getMessage());
	} finally { // it is a good idea to release resources in a finally block
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException sqlEx) {
			}
			rs = null;
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException sqlEx) {
			}
			stmt = null;
		}
	}
	conexion.desconectar();
	
	return res;
	
}

//Dado el cliente_id devuelve todos los datos del cliente 
public static ClienteBean getCliente(int cliente_id) {
	ClienteBean res= new ClienteBean();
	if (conexion.getConexion() == null)
		conexion.conectar();
	
	
	java.sql.Statement stmt = null;
	ResultSet rs = null;
	try {
		
		stmt= conexion.getConexion().createStatement();
		rs=stmt.executeQuery("SELECT * FROM Cliente where cliente_id= "+cliente_id);
		if(rs.next()) {
			res.setCliente_id(cliente_id);
			res.setNombre(rs.getString("nombre"));
			res.setApellidos(rs.getString("apellidos"));
			res.setDni(rs.getString("DNI"));
			res.setEmail(rs.getString("email"));
			res.setNacionalidad(rs.getString("nacionalidad"));
			res.setPassword(rs.getString("password"));
			res.setTelefono(rs.getInt("telefono"));
		}
	}catch (SQLException ex) {
		System.out.println("SQLException: " + ex.getMessage());
		res=null;
	} finally { // it is a good idea to release resources in a finally block
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException sqlEx) {
			}
			rs = null;
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException sqlEx) {
			}
			stmt = null;
		}
	}
	conexion.desconectar();
	
	return res;
	
}

//Dado el id de un cliente poder modificar alguno de sus datos
//el String dato es el campo que queremos modificar Ej: "nombre" y el String nuevo es dato nuevo que queremos introducir
public static void modificarDatosCliente(int cliente_id, String dato, String nuevo) {
	PreparedStatement stm=null;
	if(dato!= "nombre" && dato!= "apellidos" && dato!= "DNI" && dato!= "email" && dato!= "nacionalidad" && dato!= "password" 
			&& dato!= "telefono") {
		System.out.println("Error, campo no existente");
		return;
	}
	if (conexion.getConexion() == null)
		conexion.conectar();
	
	try {
		if(dato == "telefono") {
			stm=conexion.getConexion().prepareStatement("UPDATE Cliente Set "+dato+" = "+nuevo+" WHERE cliente_id = "+cliente_id);
			stm.executeUpdate();
		}
		else {
		stm=conexion.getConexion().prepareStatement("UPDATE Cliente Set "+dato+" = \""+nuevo+"\" WHERE cliente_id = "+cliente_id);
		stm.executeUpdate();
		}
	}catch (SQLException ex) {
		System.out.println("SQLException: " + ex.getMessage());
	} finally { // it is a good idea to release resources in a finally block
		
		if (stm != null) {
			try {
				stm.close();
			} catch (SQLException sqlEx) {
			}
			stm = null;
		}
	}
	conexion.desconectar();
	
}

//Dado un ClienteBean lo inserta en la base de datos
public static void anadirCliente(ClienteBean cliente) {
	if (conexion.getConexion() == null)
		conexion.conectar();
	
	PreparedStatement stm= null;
	try {
		stm=conexion.getConexion().prepareStatement("INSERT INTO Cliente VALUES (?,?,?,?,?,?,?,?)");
		stm.setInt(1, cliente.getCliente_id());
		stm.setString(2, cliente.getNombre());
		stm.setString(3, cliente.getApellidos());
		stm.setString(4, cliente.getDni());
		stm.setString(5, cliente.getEmail());
		stm.setString(6, cliente.getNacionalidad());
		stm.setString(7, cliente.getPassword());
		if (cliente.getTelefono() != null) {
			stm.setInt(8, cliente.getTelefono());
		} else {
			stm.setNull(8, Types.INTEGER);
		}
		stm.executeUpdate();
	}catch (SQLException ex){  
		System.out.println("SQLException: " + ex.getMessage()); 
	} finally { // it is a good idea to release resources in a finally block  
		if (stm != null) { try {  stm.close(); } catch (SQLException sqlEx) { }  stm = null; }  
	} 
}
//Dado el numero de una habitacion ver los datos del cliente que esta en esa habitacion actualmente
public static ClienteBean clientePorHabitacionID(int habitacion_id) {
	ClienteBean cliente= new ClienteBean();
	
	EstanciaBean estancia = new EstanciaBean();
	estancia=EstanciaDAO.getEstanciaByHabitacionID(habitacion_id);
	int cliente_id=estancia.getCliente_id();
	
	cliente= getCliente(cliente_id);
	
	return cliente;
}

}
