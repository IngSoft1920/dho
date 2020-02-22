package ingsoft.dho.baseDatos;

import ingsoft1920.dho.bean.CobrosBean;
import ingsoft1920.dho.bean.EstanciaBean;
import ingsoft1920.dho.bean.FacturaBean;
import ingsoft1920.dho.bean.HabitacionBean;
import ingsoft1920.dho.controller.Conexion;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;







//Consultas previamente hechas que hay que adaptarlas al nuevo programa
public class Consultas {
	
	private static Conexion conexion=new Conexion();
	public Conexion getConexion() {
		return this.conexion;
	}
	/*
	//Devolver una habitacion por su id
	public static Habitaciones getHabitacionById (int habitacion_id){
		if (conexion.getConexion()== null)
			conexion.conectar();
		
		Habitaciones res = null;
		
		java.sql.Statement stmt = null; 
		ResultSet rs = null; 
		try { 
			stmt = conexion.getConexion().createStatement() ;
			rs =  stmt.executeQuery("SELECT * FROM habitaciones WHERE habitacion_id = "+habitacion_id);
			if (rs.next()){
				res = new Habitaciones (rs.getInt("habitacion_id"), 
						rs.getString("tipo_habitacion"), 
						rs.getInt("hotel_id")); 

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
	

	*///Dado habitacion_id devuelve el HabitacionBean
	// Si la habitacion no existe devuelve null
	public static HabitacionBean getHabitacion(int habitacion_id) {
		HabitacionBean res= new HabitacionBean(); 
		res.setId_habitacion(habitacion_id);
		String tipo=null;
		int hotel_id=0;
		
		if (conexion==null) {
			conexion.conectar();
		} 
		java.sql.Statement stmt = null; 
		ResultSet rs = null; 
		try { 
			stmt = conexion.getConexion().createStatement() ;
			rs =  stmt.executeQuery("SELECT tipo_habitacion FROM habitaciones WHERE habitacion_id = "+habitacion_id);
			if (rs.next()){
				tipo = rs.getString("tipo_habitacion");
				hotel_id=rs.getInt("hotel_id");
				

			}
			res.setId_hotel(hotel_id);
			res.setTipo_habitacion(tipo);

		} 
		catch (SQLException ex){ 
			System.out.println("SQLException: " + ex.getMessage());
		} finally { // it is a good idea to release resources in a finally block 
			if (rs != null) { try { rs.close(); } catch (SQLException sqlEx) { } rs = null; } 
			if (stmt != null) { try {  stmt.close(); } catch (SQLException sqlEx) { }  stmt = null; } 
		}
		return res;
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
			//Dado el id de un cliente ver todos los cobros a su nombre y crear la factura 
			//tambien incluye el precio de la estancia pero falta que los de cm nos manden el precio de las habitaciones
			//Devuelve el FacturaBean de la factura generada
			
			public static FacturaBean generarFactura(int cliente_id, int precioHabitacion) {
				FacturaBean res= new FacturaBean();
				int precio=0;
				int factura_id=0;
				int estancia_id=0;
				int habitacion_id=0;
				LocalDate hoy=LocalDate.now();
				Date fecha= new Date(hoy.getDayOfMonth(),hoy.getMonthValue(),hoy.getYear());
				
				
				ArrayList<CobrosBean> cobros= new ArrayList<CobrosBean>();
				if (conexion==null) 
					conexion.conectar();
				
				java.sql.Statement stmt= null;
				ResultSet rs= null;
				java.sql.Statement stmt2= null;
				ResultSet rs2= null;
				PreparedStatement stmt3= null;
				ResultSet rs3= null;
				java.sql.Statement stmt4= null;
				ResultSet rs4= null;
				try {
					stmt=conexion.getConexion().createStatement();
					rs=stmt.executeQuery("SELECT * FROM Cobros WHERE cliente_id = "+cliente_id);
					if(rs.next()) {
						if (!estaCobroPagado(rs.getInt("cobros_id"))) {
							precio=precio+ rs.getInt("precio");
						}
					}
					stmt2=conexion.getConexion().createStatement();
					rs2=stmt2.executeQuery("SELECT factura_id, COUNT(factura_id) as n FROM factura");
					if(rs2.next()) {
						factura_id=rs.getInt("n");
					}
					stmt4=conexion.getConexion().createStatement();
					rs4=stmt4.executeQuery("SELECT * FROM estancia WHERE cliente_id="+cliente_id);
					if(rs4.next()) {
						estancia_id=rs4.getInt("estancia_id");
						habitacion_id=rs4.getInt("habitacion_id");
						
					}
					precio=precio+diasReserva(cliente_id)*precioHabitacion;
					stmt3=conexion.getConexion().prepareStatement("INSERT INTO factura values (?,?,?,?,?,?,?,?)");
					stmt3.setInt(1,factura_id);
					stmt3.setInt(2,estancia_id);
					stmt3.setInt(3, cliente_id);
					stmt3.setInt(4, habitacion_id);
					stmt3.setDate(5, fecha);
					stmt3.setInt(6, precio);
					stmt3.setBoolean(7, false);
					stmt3.setString(8, " ");
					stmt3.executeUpdate();
				}catch (SQLException ex){ 
					System.out.println("SQLException: " + ex.getMessage());
				} finally { // it is a good idea to release resources in a finally block 
					if (rs != null) { try { rs.close(); } catch (SQLException sqlEx) { } rs = null; } 
					if (stmt != null) { try {  stmt.close(); } catch (SQLException sqlEx) { }  stmt = null; } 
				}
				res.setFactura_id(factura_id);
				res.setCliente_id(cliente_id);
				res.setEstancia_id(estancia_id);
				res.setPrecio(precio);
				res.setPagado(false);
				res.setTipo_factura(" ");
				res.setFecha_factura(LocalDate.now());
				res.setHabitacion_id(habitacion_id);
				
				
				return res;
			}
			
			//Dado el id de un cliente saber cuantos dias esta reservada su habitacion
			//de momento un cliente solo tiene una estancia a su nombre -> luego ampliar para que cpn un id_cliente
			//se puedan guardar varias estancias
			public static int diasReserva(int cliente_id) { 
				if (conexion.getConexion()==null) 
					conexion.conectar();
					
				int res=0; 
				java.sql.Statement stmt= null; 
				ResultSet rs=null; 
				 try {
				stmt=conexion.getConexion().createStatement(); 
				rs=stmt.executeQuery("SELECT DATEDIFF(fecha_inicio, fecha_fin) as n FROM estancia WHERE cliente_id=" +cliente_id);
				 if(rs.next()) {
					  res=rs.getInt("n");
				 }
				 }catch (SQLException ex){ 
						System.out.println("SQLException: " + ex.getMessage());
					} finally { // it is a good idea to release resources in a finally block 
						if (rs != null) { try { rs.close(); } catch (SQLException sqlEx) { } rs = null; } 
						if (stmt != null) { try {  stmt.close(); } catch (SQLException sqlEx) { }  stmt = null; } 
					}
				return res; 
			} 
			
			//Dado el id de un cliente devuelve la EstanciaBean
			public static EstanciaBean estanciaCliente(int cliente_id) {
				EstanciaBean res= new EstanciaBean();
				int estancia_id=0;
				int habitacion_id=0; 
				int hotel_id=0; 
				LocalDate fecha_inicio; 
				LocalDate fecha_fin;
				
				if (conexion==null) 
					conexion.conectar();
					
				java.sql.Statement stmt= null; 
				ResultSet rs=null;
				try {
					stmt=conexion.getConexion().createStatement(); 
					rs=stmt.executeQuery("SELECT * FROM estancia WHERE cliente_id="+ cliente_id);
					if(rs.next()) {
						estancia_id=rs.getInt("estancia_id");
						habitacion_id=rs.getInt("habitacion_id");
						hotel_id=rs.getInt("hotel_id");
						
					}
				}catch (SQLException ex){ 
					System.out.println("SQLException: " + ex.getMessage());
				} finally { // it is a good idea to release resources in a finally block 
					if (rs != null) { try { rs.close(); } catch (SQLException sqlEx) { } rs = null; } 
					if (stmt != null) { try {  stmt.close(); } catch (SQLException sqlEx) { }  stmt = null; } 
				}
				return res;
			}
			//devuelve el id del ultimo servicio
			public static int idUltimoServicio() {
				
				if (conexion==null) 
					conexion.conectar();
					
				int res=0;
				java.sql.Statement stmt= null; 
				ResultSet rs=null;
				try {
					stmt=conexion.getConexion().createStatement(); 
					rs=stmt.executeQuery("SELECT * FROM servicio");
					if(rs.next()) {
						res=rs.getInt("servicio_id");
					}
				}catch (SQLException ex){ 
					System.out.println("SQLException: " + ex.getMessage());
				} finally { // it is a good idea to release resources in a finally block 
					if (rs != null) { try { rs.close(); } catch (SQLException sqlEx) { } rs = null; } 
					if (stmt != null) { try {  stmt.close(); } catch (SQLException sqlEx) { }  stmt = null; } 
				}
				return res;
			}
			
}
