package ingsoft1920.dho.fna;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ingsoft1920.dho.controller.Conexion;

public class FacturaDAO {
	//Dado el id de un cliente, y un id de una estancia, devuelve todas sus facturas
	public static ArrayList<FacturaBean> todasFacturasCliente(int cliente_id, int estancia_id){
		ArrayList<FacturaBean> facturas= new ArrayList<FacturaBean>();
		Conexion conexion = new Conexion();
		if (conexion.getConexion()==null) 
			conexion.conectar();
		
		java.sql.Statement stmt= null;
		ResultSet rs= null;
		Date fecha = null;
		
		
		
		try {
			stmt=conexion.getConexion().createStatement();
			rs=stmt.executeQuery("SELECT fecha_factura, lugar, precio\r\n" + 
					"FROM Servicios\r\n" + 
					"WHERE cliente_id = "+cliente_id+" AND estancia_id = "+estancia_id+"\r\n" + 
					"ORDER BY fecha_factura;");
			while(rs.next()) {
				facturas.add(new FacturaBean(rs.getDate("fecha_factura"),rs.getString("lugar"),rs.getInt("precio")));
			}
		}catch (SQLException ex){ 
			System.out.println("SQLException: " + ex.getMessage());
		} finally { // it is a good idea to release resources in a finally block 
			if (rs != null) { try { rs.close(); } catch (SQLException sqlEx) { } rs = null; } 
			if (stmt != null) { try {  stmt.close(); } catch (SQLException sqlEx) { }  stmt = null; } 
		}
		conexion.desconectar();
		return facturas;
	}
	
	//Dado el id de un cliente devuelve las facturas que faltan por pagar
	public static ArrayList<FacturaBean> porPagarFacturasCliente(int cliente_id){
		ArrayList<FacturaBean> facturas= new ArrayList<FacturaBean>();
		Conexion conexion = new Conexion();
		if (conexion.getConexion()==null) 
			conexion.conectar();
		
		java.sql.Statement stmt= null;
		ResultSet rs= null;
		Date fecha = null;
		
		
		
		try {
			stmt=conexion.getConexion().createStatement();
			rs=stmt.executeQuery("SELECT fecha_factura, lugar, precio\r\n" + 
					"FROM Servicios\r\n" + 
					"WHERE cliente_id = "+cliente_id+"\r\n" + 
					"ORDER BY fecha_factura;");
			while(rs.next()) {
				facturas.add(new FacturaBean(rs.getDate("fecha_factura"),rs.getString("lugar"),rs.getInt("precio")));
			}
		}catch (SQLException ex){ 
			System.out.println("SQLException: " + ex.getMessage());
		} finally { // it is a good idea to release resources in a finally block 
			if (rs != null) { try { rs.close(); } catch (SQLException sqlEx) { } rs = null; } 
			if (stmt != null) { try {  stmt.close(); } catch (SQLException sqlEx) { }  stmt = null; } 
		}
		conexion.desconectar();
		return facturas;
	}
	
	//Dado el id de un cliente, y su estancia id,  devuelve el precio de su estancua
	public static EstanciaBean precioEstanciaCliente(int cliente_id,int estancia_id){
		EstanciaBean estancia=null;
		Conexion conexion = new Conexion();
		if (conexion.getConexion()==null) 
			conexion.conectar();
		
		java.sql.Statement stmt= null;
		ResultSet rs= null;
		Date fecha = null;
		
		
		
		try {
			stmt=conexion.getConexion().createStatement();
			rs=stmt.executeQuery("SELECT importe, fecha_inicio,fecha_fin\r\n" + 
					"FROM Estancia\r\n" + 
					"WHERE cliente_id = "+cliente_id+" AND estancia_id = "+estancia_id+";");
			if(rs.next()) {
				estancia= new EstanciaBean(rs.getDate("fecha_inicio"),rs.getDate("fecha_fin"),rs.getDouble("importe"));
			}
		}catch (SQLException ex){ 
			System.out.println("SQLException: " + ex.getMessage());
		} finally { // it is a good idea to release resources in a finally block 
			if (rs != null) { try { rs.close(); } catch (SQLException sqlEx) { } rs = null; } 
			if (stmt != null) { try {  stmt.close(); } catch (SQLException sqlEx) { }  stmt = null; } 
		}
		conexion.desconectar();
		return estancia;
	}
	
	
	
	//Dado el cliente_id devuelve toda la informacion util del cliente para facturas
	public static ClienteBean datosCliente(int cliente_id) {
		ClienteBean cliente=null;
		Conexion conexion = new Conexion();
		if (conexion.getConexion()==null) 
			conexion.conectar();
		
		java.sql.Statement stmt= null;
		ResultSet rs= null;
		try {
			stmt=conexion.getConexion().createStatement();
			rs=stmt.executeQuery("SELECT * FROM Cliente WHERE cliente_id ="+cliente_id);
			if(rs.next()) {
				cliente= new ClienteBean(rs.getString("nombre"),rs.getString("apellidos"),rs.getString("DNI"),rs.getString("email"),rs.getString("telefono"));
			}
		}catch (SQLException ex){ 
			System.out.println("SQLException: " + ex.getMessage());
		} finally { // it is a good idea to release resources in a finally block 
			if (rs != null) { try { rs.close(); } catch (SQLException sqlEx) { } rs = null; } 
			if (stmt != null) { try {  stmt.close(); } catch (SQLException sqlEx) { }  stmt = null; } 
		}
		conexion.desconectar();
		return cliente;
	}
	
	//Dado el cliente_id devuelve toda la informacion util del hotel para facturas
	public static HotelBean datosHotel(int cliente_id,int estancia_id) {
		HotelBean hotel=null;
		Conexion conexion = new Conexion();
		if (conexion.getConexion()==null) 
			conexion.conectar();
		
		java.sql.Statement stmt= null;
		ResultSet rs= null;
		try {
			stmt=conexion.getConexion().createStatement();
			rs=stmt.executeQuery("SELECT H.nombre,H.pais,H.ciudad \r\n" + 
					"FROM Hotel AS H\r\n" + 
					"JOIN Estancia AS E ON H.hotel_id = E.hotel_id\r\n" + 
					"WHERE E.cliente_id ="+cliente_id+" AND E.estancia_id ="+estancia_id);
			if(rs.next()) {
				hotel= new HotelBean(rs.getString("H.nombre"),rs.getString("H.pais"),rs.getString("H.ciudad"));
			}
		}catch (SQLException ex){ 
			System.out.println("SQLException: " + ex.getMessage());
		} finally { // it is a good idea to release resources in a finally block 
			if (rs != null) { try { rs.close(); } catch (SQLException sqlEx) { } rs = null; } 
			if (stmt != null) { try {  stmt.close(); } catch (SQLException sqlEx) { }  stmt = null; } 
		}
		conexion.desconectar();
		return hotel;
	}

}
