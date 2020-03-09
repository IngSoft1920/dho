package ingsoft1920.dho.fna;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ingsoft1920.dho.controller.Conexion;

public class FacturaDAO {
	//Dado el id de un cliente devuelve todas sus facturas
	public static ArrayList<FacturaBean> todasFacturasCliente(int cliente_id){
		ArrayList<FacturaBean> facturas= new ArrayList<FacturaBean>();
		Conexion conexion = new Conexion();
		if (conexion.getConexion()==null) 
			conexion.conectar();
		
		java.sql.Statement stmt= null;
		ResultSet rs= null;
		Date fecha = null;
		
		
		
		try {
			stmt=conexion.getConexion().createStatement();
			rs=stmt.executeQuery("SELECT fecha_factura, tipo_factura, precio\r\n" + 
					"FROM Factura\r\n" + 
					"WHERE cliente_id ="+cliente_id+"\r\n" + 
					"ORDER BY fecha_factura");
			while(rs.next()) {
				facturas.add(new FacturaBean(rs.getDate("fecha_factura"),rs.getString("tipo_factura"),rs.getInt("precio")));
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
			rs=stmt.executeQuery("SELECT fecha_factura, tipo_factura, precio\r\n" + 
					"FROM Factura\r\n" + 
					"WHERE cliente_id = "+cliente_id+" AND pagado = false\r\n" + 
					"ORDER BY fecha_factura;");
			while(rs.next()) {
				facturas.add(new FacturaBean(rs.getDate("fecha_factura"),rs.getString("tipo_factura"),rs.getInt("precio")));
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
	

}