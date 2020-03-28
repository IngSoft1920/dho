package ingsoft1920.dho.fna;

import java.sql.ResultSet;
import java.sql.SQLException;

import ingsoft1920.dho.bean.CobrosBean;
import ingsoft1920.dho.controller.Conexion;

public class ArchivosFacturaDAO {
private static Conexion conexion= new Conexion(); 
	
	public ArchivosFacturaDAO(Conexion conexion) {
		this.conexion=conexion;
	}
	
	public static ArchivosFacturaBean getPDFByCod(int cliente_id) {
		ArchivosFacturaBean aux=null;
		Conexion conexion = new Conexion();
		if (conexion.getConexion()==null) 
			conexion.conectar();
		
		
		java.sql.Statement stmt= null;
		ResultSet rs= null;
		try {
			stmt=conexion.getConexion().createStatement();
			rs=stmt.executeQuery("SELECT * FROM ArchivosFactura WHERE cliente_id=" +cliente_id);
			if(rs.next()) {
				ArchivosFacturaBean res= new ArchivosFacturaBean(rs.getString("archivoCod"), rs.getDate("fecha_creacion"), rs.getInt("cliente_id"),"");
				aux=res;
			}
		}catch (SQLException ex){ 
			System.out.println("SQLException: " + ex.getMessage());
		} finally { // it is a good idea to release resources in a finally block 
			if (rs != null) { try { rs.close(); } catch (SQLException sqlEx) { } rs = null; } 
			if (stmt != null) { try {  stmt.close(); } catch (SQLException sqlEx) { }  stmt = null; } 
		}
		
		return aux;
	}
		
	}

