package ingsoft1920.dho.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import ingsoft1920.dho.bean.CobrosBean;
import ingsoft1920.dho.bean.FacturaBean;
import ingsoft1920.dho.controller.Conexion;

public class FacturasDAO {
private static Conexion conexion= new Conexion(); 
	
	public FacturasDAO(Conexion conexion) {
		this.conexion=conexion;
	}
	
	
	//Dado el id de un cobro ver si esta pagado o no
			//Devuelve false si no esta pagado y true si lo esta
			
			public static boolean estaCobroPagado(int cobros_id) {
				boolean res=false;
				
				if (conexion==null) 
					conexion.conectar();
				
				java.sql.Statement stmt = null; 
				ResultSet rs = null; 
				try {
					stmt=conexion.getConexion().createStatement();
					rs= stmt.executeQuery("SELECT pagado FROM Cobros WHERE cobros_id= "+cobros_id);
					if(rs.next()) {
						res=rs.getBoolean("pagado");
					}
					
				}
				catch (SQLException ex){ 
					System.out.println("SQLException: " + ex.getMessage());
				} finally { // it is a good idea to release resources in a finally block 
					if (rs != null) { try { rs.close(); } catch (SQLException sqlEx) { } rs = null; } 
					if (stmt != null) { try {  stmt.close(); } catch (SQLException sqlEx) { }  stmt = null; } 
				}
				return res;
			}
			
			//Dado el id de una factura ver si esta pagada o no
				//Devuelve false si no esta pagado y true si lo esta
				
				public static boolean estaFacturaPagada(int factura_id) {
					boolean res=false;
					
					if (conexion==null) 
						conexion.conectar();
					
					java.sql.Statement stmt = null; 
					ResultSet rs = null; 
					try {
						stmt=conexion.getConexion().createStatement();
						rs= stmt.executeQuery("SELECT pagado FROM Factura WHERE factura_id= "+factura_id);
						if(rs.next()) {
							res=rs.getBoolean("pagado");
						}
						
					}
					catch (SQLException ex){ 
						System.out.println("SQLException: " + ex.getMessage());
					} finally { // it is a good idea to release resources in a finally block 
						if (rs != null) { try { rs.close(); } catch (SQLException sqlEx) { } rs = null; } 
						if (stmt != null) { try {  stmt.close(); } catch (SQLException sqlEx) { }  stmt = null; } 
					}
					return res;
				} 
	//Dado el id de un cliente ver todos los cobros a su nombre 
		public static ArrayList<CobrosBean> cobrosCliente(int cliente_id){
			ArrayList<CobrosBean> cobros= new ArrayList<CobrosBean>();
			
			if (conexion==null) 
				conexion.conectar();
			java.sql.Statement stmt= null;
			ResultSet rs= null;
			Date fecha = null;
			
			
			
			try {
				stmt=conexion.getConexion().createStatement();
				rs=stmt.executeQuery("SELECT * FROM Cobros WHERE cliente_id= "+cliente_id  );
				while(rs.next()) {
					
					//fecha.of(rs.getDate("fecha_factura").getDay(),fecha.getMonth(),rs.getDate("fecha_factura").getYear());
					;
					cobros.add(cobros.size(), new CobrosBean(rs.getInt("cobros_id"), rs.getInt("estancia_id"), cliente_id, rs.getInt("habitacion_id"),fecha, rs.getInt("precio"), rs.getBoolean("pagado"), rs.getString("tipo_factura")));
					
				}
			}catch (SQLException ex){ 
				System.out.println("SQLException: " + ex.getMessage());
			} finally { // it is a good idea to release resources in a finally block 
				if (rs != null) { try { rs.close(); } catch (SQLException sqlEx) { } rs = null; } 
				if (stmt != null) { try {  stmt.close(); } catch (SQLException sqlEx) { }  stmt = null; } 
			}
			
			return cobros;
		}
				
				
    //Genera la factura de todos los cobros (no pagados) de un cliente 
	//tambien incluye el precio de la estancia pero falta que los de cm nos manden el precio de las habitaciones
	//Devuelve el FacturaBean de la factura generada
	
	public static FacturaBean generarFactura(int cliente_id, int precioHabitacion) {
		
		int precio=0;
		int factura_id=0;
		int estancia_id=0;
		int habitacion_id=0;
		LocalDate hoy=LocalDate.now();
		Date fecha= new Date(hoy.getDayOfMonth(),hoy.getMonthValue(),hoy.getYear());
		
		
		ArrayList<CobrosBean> cobros= new ArrayList<CobrosBean>();
		cobros=cobrosCliente(cliente_id);
		if (conexion==null) 
			conexion.conectar();
		
		java.sql.Statement stmt2= null;
		ResultSet rs2= null;
		PreparedStatement stmt3= null;
		java.sql.Statement stmt4= null;
		ResultSet rs4= null;
		try {
			//calculamos el precio de los cobros que no estan pagados
			for(int i=0; i<cobros.size();i++) {
				if(!estaCobroPagado(cobros.get(i).getCobros_id())) {
					precio=precio+cobros.get(i).getPrecio();
				}
			}
			//le añadimos el importe de la estancia
			precio=precio+HabitacionDAO.diasReserva(cliente_id)*precioHabitacion;
			
			
			
			stmt4=conexion.getConexion().createStatement();
			rs4=stmt4.executeQuery("SELECT * FROM Estancia WHERE cliente_id="+cliente_id);
			if(rs4.next()) {
				estancia_id=rs4.getInt("estancia_id");
				habitacion_id=rs4.getInt("habitacion_id");
				
			}
			stmt2=conexion.getConexion().createStatement();
			rs2=stmt2.executeQuery("SELECT COUNT(factura_id) as n FROM Factura");
			if(rs2.next()) {
				factura_id=rs2.getInt("n");
			
			
			stmt3=conexion.getConexion().prepareStatement("INSERT INTO Factura values (?,?,?,?,?,?,?,?)");
			stmt3.setInt(1,factura_id);
			stmt3.setInt(2,estancia_id);
			stmt3.setInt(3, cliente_id);
			stmt3.setInt(4, habitacion_id);
			stmt3.setDate(5, null);
			stmt3.setInt(6, precio);
			stmt3.setBoolean(7, false);
			stmt3.setString(8, " ");
			stmt3.executeUpdate();
		}
		}catch (SQLException ex){ 
			System.out.println("SQLException: " + ex.getMessage());
		} finally { // it is a good idea to release resources in a finally block 
			if (rs2 != null) { try { rs2.close(); } catch (SQLException sqlEx) { } rs2 = null; } 
			if (stmt2 != null) { try {  stmt2.close(); } catch (SQLException sqlEx) { }  stmt2 = null; } 
			if (rs4 != null) { try { rs4.close(); } catch (SQLException sqlEx) { } rs4 = null; } 
			if (stmt4 != null) { try {  stmt4.close(); } catch (SQLException sqlEx) { }  stmt4 = null; }
			if (stmt3 != null) { try {  stmt3.close(); } catch (SQLException sqlEx) { }  stmt3 = null; }
		}
		Date aux = new Date(LocalDate.now().getDayOfYear(),LocalDate.now().getMonthValue(),LocalDate.now().getDayOfMonth());
		FacturaBean res= new FacturaBean(factura_id,cliente_id,estancia_id,habitacion_id,aux,precio,false," ");
		
		
		return res;
	}
	//Dado el id de una factura poder cambiar de no pagada a pagada
	public static void facturaPagada(int factura_id) {
		if (conexion==null) 
			conexion.conectar();
		
		PreparedStatement stmt= null;
		
		
		try {
			stmt=conexion.getConexion().prepareStatement("UPDATE Factura SET pagado=true WHERE factura_id= " +factura_id);
			stmt.executeUpdate();
			
		}catch (SQLException ex){ 
			System.out.println("SQLException: " + ex.getMessage());
		} finally { // it is a good idea to release resources in a finally block 
			
			if (stmt != null) { try {  stmt.close(); } catch (SQLException sqlEx) { }  stmt = null; } 
		}
		
	}
	//Dado el id de una factura poder cambiar de no pagada a pagada
		public static void cobroPagado(int cobro_id) {
			if (conexion==null) 
				conexion.conectar();
			PreparedStatement stmt= null;
			
			try {
				stmt=conexion.getConexion().prepareStatement("UPDATE Cobros SET pagado=true WHERE cobros_id= " +cobro_id);
				stmt.executeUpdate();
			}catch (SQLException ex){ 
				System.out.println("SQLException: " + ex.getMessage());
			} finally { // it is a good idea to release resources in a finally block 
				
				if (stmt != null) { try {  stmt.close(); } catch (SQLException sqlEx) { }  stmt = null; } 
			}
			
		}
	//Dado el id de un cliente devolver las facturas  a su nombre
		public static ArrayList<FacturaBean> facturasCliente (int cliente_id){
			ArrayList<FacturaBean> res = new ArrayList<FacturaBean>();
			Date fecha= null;
			if (conexion==null) 
				conexion.conectar();
			
			java.sql.Statement stmt= null;
			ResultSet rs= null;
			try {
				stmt=conexion.getConexion().createStatement();
				rs= stmt.executeQuery("SELECT * FROM Factura WHERE cliente_id= "+cliente_id);
				while(rs.next()) {
					res.add(res.size(),new FacturaBean(rs.getInt("factura_id"),rs.getInt("estancia_id"), rs.getInt("cliente_id"), rs.getInt("habitacion_id"), fecha, rs.getInt("precio"), rs.getBoolean("pagado"), rs.getString("tipo_factura")));
				}
			}catch (SQLException ex){ 
				System.out.println("SQLException: " + ex.getMessage());
			} finally { // it is a good idea to release resources in a finally block 
				if (rs != null) { try { rs.close(); } catch (SQLException sqlEx) { } rs = null; } 
				if (stmt != null) { try {  stmt.close(); } catch (SQLException sqlEx) { }  stmt = null; } 
			}
			return res;
		}
		
		//Dado el id de una factura devolver la facturaBean
		public static ArrayList<FacturaBean> getFacturaporID (int factura_id){
			ArrayList<FacturaBean> res = new ArrayList<FacturaBean>();
			Date fecha= null;
			if (conexion==null) 
				conexion.conectar();
			
			java.sql.Statement stmt= null;
			ResultSet rs= null;
			
			try {
				stmt=conexion.getConexion().createStatement();
				rs= stmt.executeQuery("SELECT * FROM Factura WHERE factura_id= "+factura_id);
				while(rs.next()) {
					res.add(res.size(),new FacturaBean(rs.getInt("factura_id"),rs.getInt("estancia_id"), rs.getInt("cliente_id"), rs.getInt("habitacion_id"), fecha, rs.getInt("precio"), rs.getBoolean("pagado"), rs.getString("tipo_factura")));
				}
			}catch (SQLException ex){ 
				System.out.println("SQLException: " + ex.getMessage());
			} finally { // it is a good idea to release resources in a finally block 
				if (rs != null) { try { rs.close(); } catch (SQLException sqlEx) { } rs = null; } 
				if (stmt != null) { try {  stmt.close(); } catch (SQLException sqlEx) { }  stmt = null; } 
			}
			return res;
		}
		//Dado un ArrayList de cobros generar una factura. Especificar a nombre de que cliente se quiere generar la factura
		//La inserta en la base de datos y devuelve el FacturaBean
		public static FacturaBean genFacturaCobros(ArrayList<CobrosBean> cobros, int cliente_id) {
			int precioFac=0;
			int precioCo = 0;
			int factura_id=-1;
			int estancia_id=-1;
			boolean pagado=false;
			int habitacion_id=-1;
			Date fecha=null;
			
			PreparedStatement stmt2= null;
			java.sql.Statement stmt3= null;
			ResultSet rs3= null;
			
			if (conexion==null) 
				conexion.conectar();
						
			java.sql.Statement stmt= null;
			ResultSet rs= null;
			for(int i=0; i<cobros.size(); i++) {
				int cobro_id=cobros.get(i).getCobros_id();
				if(!estaCobroPagado(cobro_id)){
					precioFac+=cobros.get(i).getPrecio();
				}
			}
				
			try {
				stmt=conexion.getConexion().createStatement();
				rs=stmt.executeQuery("SELECT * FROM Estancia WHERE cliente_id= "+cliente_id);
				while(rs.next()) {
					estancia_id=rs.getInt("estancia_id");
					habitacion_id=rs.getInt("habitacion_id");
				}						
				
				
			stmt3=conexion.getConexion().createStatement();
			rs3=stmt3.executeQuery("SELECT COUNT(factura_id) as n FROM Factura");
			if(rs3.next()) {
				factura_id=rs3.getInt("n");
			
			
			stmt2=conexion.getConexion().prepareStatement("INSERT INTO Factura values (?,?,?,?,?,?,?,?)");
			stmt2.setInt(1,factura_id);
			stmt2.setInt(2,estancia_id);
			stmt2.setInt(3, cliente_id);
			stmt2.setInt(4, habitacion_id);
			stmt2.setDate(5, null);
			stmt2.setInt(6, precioFac);
			stmt2.setBoolean(7, false);
			stmt2.setString(8, " ");
			stmt2.executeUpdate();
			
			}
		}catch (SQLException ex){ 
			System.out.println("SQLException: " + ex.getMessage());
		} finally { // it is a good idea to release resources in a finally block 
			if (rs3 != null) { try { rs3.close(); } catch (SQLException sqlEx) { } rs3 = null; } 
			if (stmt3 != null) { try {  stmt3.close(); } catch (SQLException sqlEx) { }  stmt3 = null; } 
			if (rs != null) { try { rs.close(); } catch (SQLException sqlEx) { } rs = null; } 
			if (stmt != null) { try {  stmt.close(); } catch (SQLException sqlEx) { }  stmt = null; } 
		}
			Date aux = new Date(LocalDate.now().getDayOfYear(),LocalDate.now().getMonthValue(),LocalDate.now().getDayOfMonth());
		FacturaBean res= new FacturaBean(factura_id, estancia_id,cliente_id,habitacion_id,aux,precioFac,false," ");
		return res;
		}
		//Volcar toda la informacion de los cobros para pasarsela al chain master
		public static ArrayList<CobrosBean> cobrosBean(){
			ArrayList<CobrosBean> cobros= new ArrayList<CobrosBean>();
			
			if (conexion==null) 
				conexion.conectar();
			java.sql.Statement stmt= null;
			ResultSet rs= null;			
			try {
				stmt=conexion.getConexion().createStatement();
				rs=stmt.executeQuery("SELECT * FROM Cobros");
				while(rs.next()) {
					cobros.add(new CobrosBean(rs.getInt("cobros_id"), rs.getInt("estancia_id"), rs.getInt("cliente_id"), rs.getInt("habitacion_id"),rs.getDate("fecha_factura"), rs.getInt("precio"), rs.getBoolean("pagado"), rs.getString("tipo_factura")));
					
				}
			}catch (SQLException ex){ 
				System.out.println("SQLException: " + ex.getMessage());
			} finally { // it is a good idea to release resources in a finally block 
				if (rs != null) { try { rs.close(); } catch (SQLException sqlEx) { } rs = null; } 
				if (stmt != null) { try {  stmt.close(); } catch (SQLException sqlEx) { }  stmt = null; } 
			}
			
			return cobros;
		}
		
		//Volcar toda la informacion de las facturas para pasarsela al chain master
		public static ArrayList<FacturaBean> facturasBean (){
			ArrayList<FacturaBean> res = new ArrayList<FacturaBean>();
			if (conexion==null) 
				conexion.conectar();
			
			java.sql.Statement stmt= null;
			ResultSet rs= null;
			try {
				stmt=conexion.getConexion().createStatement();
				rs= stmt.executeQuery("SELECT * FROM Factura");
				while(rs.next()) {
					res.add(new FacturaBean(rs.getInt("factura_id"),rs.getInt("estancia_id"), rs.getInt("cliente_id"), rs.getInt("habitacion_id"), rs.getDate("fecha_factura"), rs.getInt("precio"), rs.getBoolean("pagado"), rs.getString("tipo_factura")));
				}
			}catch (SQLException ex){ 
				System.out.println("SQLException: " + ex.getMessage());
			} finally { // it is a good idea to release resources in a finally block 
				if (rs != null) { try { rs.close(); } catch (SQLException sqlEx) { } rs = null; } 
				if (stmt != null) { try {  stmt.close(); } catch (SQLException sqlEx) { }  stmt = null; } 
			}
			return res;
		}
		//Dada una fecha devolver todas las facturas generadas en esa fecha
		public static ArrayList<FacturaBean> getFacturasFecha(Date fecha){
			ArrayList<FacturaBean> res= new ArrayList<FacturaBean>();
			if (conexion==null) 
				conexion.conectar();
			
			java.sql.Statement stmt= null;
			ResultSet rs= null;
			try {
				stmt=conexion.getConexion().createStatement();
				rs=stmt.executeQuery("SELECT * FROM Factura WHERE fecha_factura=" +fecha);
				while(rs.next()) {
					res.add(res.size(), new FacturaBean(rs.getInt("factura_id"), rs.getInt("estancia_id"), rs.getInt("cliente_id"), rs.getInt("habitacion_id"), fecha, rs.getInt("precio"), rs.getBoolean("pagado"), rs.getString("tipo_factura")));
				}
			}catch (SQLException ex){ 
				System.out.println("SQLException: " + ex.getMessage());
			} finally { // it is a good idea to release resources in a finally block 
				if (rs != null) { try { rs.close(); } catch (SQLException sqlEx) { } rs = null; } 
				if (stmt != null) { try {  stmt.close(); } catch (SQLException sqlEx) { }  stmt = null; } 
			}
			return res;
		}
		//Dada una fecha devolver todos los cobros generados en esa fecha
				public static ArrayList<CobrosBean> getCobrosFecha(Date fecha){
					ArrayList<CobrosBean> res= new ArrayList<CobrosBean>();
					if (conexion==null) 
						conexion.conectar();
					
					java.sql.Statement stmt= null;
					ResultSet rs= null;
					try {
						stmt=conexion.getConexion().createStatement();
						rs=stmt.executeQuery("SELECT * FROM Cobros WHERE fecha_factura=" +fecha);
						while(rs.next()) {
							res.add(res.size(), new CobrosBean(rs.getInt("cobros_id"), rs.getInt("estancia_id"), rs.getInt("cliente_id"), rs.getInt("habitacion_id"), fecha, rs.getInt("precio"), rs.getBoolean("pagado"), rs.getString("tipo_factura")));
						}
					}catch (SQLException ex){ 
						System.out.println("SQLException: " + ex.getMessage());
					} finally { // it is a good idea to release resources in a finally block 
						if (rs != null) { try { rs.close(); } catch (SQLException sqlEx) { } rs = null; } 
						if (stmt != null) { try {  stmt.close(); } catch (SQLException sqlEx) { }  stmt = null; } 
					}
					return res;
				}
				
				public static CobrosBean getCobroPorID(int cobros_id) {
					CobrosBean aux=null;
					if (conexion==null) 
						conexion.conectar();
					
					java.sql.Statement stmt= null;
					ResultSet rs= null;
					try {
						stmt=conexion.getConexion().createStatement();
						rs=stmt.executeQuery("SELECT * FROM Cobros WHERE cobros_id=" +cobros_id);
						if(rs.next()) {
							CobrosBean res= new CobrosBean(cobros_id, rs.getInt("estancia_id"), rs.getInt("cliente_id"), rs.getInt("habitacion_id"), rs.getDate("fecha_factura"), rs.getInt("precio"), rs.getBoolean("pagado"), rs.getString("tipo_factura"));
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
