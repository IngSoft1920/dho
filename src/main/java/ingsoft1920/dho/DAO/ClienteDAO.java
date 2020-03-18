package ingsoft1920.dho.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;

import ingsoft1920.dho.bean.ClienteBean;
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
	
	//SELECT * FROM Cliente as c join Estancia as est on est.cliente_id=c.cliente_id where est.estancia_id=1
	
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

}
