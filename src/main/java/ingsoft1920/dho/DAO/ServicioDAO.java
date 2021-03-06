 package ingsoft1920.dho.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ingsoft1920.dho.bean.HabitacionBean;
import ingsoft1920.dho.bean.ServicioBean;
import ingsoft1920.dho.controller.Conexion;

public class ServicioDAO {
	private static Conexion conexion = new Conexion();

	public ServicioDAO(Conexion conexion) {
		this.conexion = conexion;
	}

	public static List<ServicioBean> devuelevServiciosreservadosPorunaEstancia(int id_estancia) {
		List<ServicioBean> res = new ArrayList<ServicioBean>();

		if (conexion.getConexion() == null)
			conexion.conectar();

		java.sql.Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conexion.getConexion().createStatement();
			rs = stmt.executeQuery("SELECT * FROM Servicios WHERE estancia_id=" + id_estancia);

			while (rs.next()) {
				res.add(new ServicioBean(rs.getInt("servicios_id"), id_estancia, rs.getInt("servicioHotel_id"),
						rs.getInt("cliente_id"), rs.getString("lugar"), rs.getDate("fecha_factura"), rs.getTime("hora"),
						rs.getString("tipo_servicio"), rs.getInt("precio")));

			}
		} catch (SQLException ex) {
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

		return res;

	}

	public static void añadirServicio(ServicioBean servicio) {
		// consulta de añadir un servicio a la tabla servicios
		if (conexion.getConexion() == null)
			conexion.conectar();

		int servicio_id = -1;

		java.sql.Statement stmt1 = null;
		ResultSet rs1 = null;
		PreparedStatement stm = null;
		try {
			// Consulta para saber el id de la nueva incidencia a crear
			stmt1 = conexion.getConexion().createStatement();
			// rs1 = stmt1.executeQuery("SELECT COUNT(servicios_id)\r\n" +
			// "FROM Servicios;");
			// if (rs1.next()){
			servicio_id = idUltimoServicio() + 1;
			// servicio_id=rs1.getInt("COUNT(servicios_id)")+1; //id del nuevo servicio
			stm = conexion.getConexion().prepareStatement("INSERT INTO Servicios values (?,?,?,?,?,?,?,?,?)");
			stm.setInt(1, servicio_id);
			stm.setInt(2, servicio.getEstancia_id());
			stm.setString(3, servicio.getLugar());
			stm.setInt(9, servicio.getCliente_id());
			stm.setDate(4, servicio.getFecha_servicio());
			stm.setTime(5, servicio.getHora());
			stm.setString(6, servicio.getTipo_servicio());
			stm.setInt(7, servicio.getId_ServicioHotel());
			stm.setInt(8, servicio.getPrecio());

			stm.executeUpdate();
			// }

		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
		} finally { // it is a good idea to release resources in a finally block
			if (rs1 != null) {
				try {
					rs1.close();
				} catch (SQLException sqlEx) {
				}
				rs1 = null;
			}
			if (stmt1 != null) {
				try {
					stmt1.close();
				} catch (SQLException sqlEx) {
				}
				stmt1 = null;
			}
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException sqlEx) {
				}
				stm = null;
			}
		}

	}

	// devuelve el id del ultimo servicio
	public static int idUltimoServicio() {

		if (conexion == null)
			conexion.conectar();

		int res = 0;
		java.sql.Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conexion.getConexion().createStatement();
			rs = stmt.executeQuery("SELECT MAX(servicios_id) AS n FROM Servicios");
			if (rs.next()) {
				res = rs.getInt("n");
			}
		} catch (SQLException ex) {
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
		return res;
	}

	// Devolver servicios reservados
	public static ArrayList<ServicioBean> getServiciosReservados() {
		if (conexion.getConexion() == null)
			conexion.conectar();

		ArrayList<ServicioBean> res = new ArrayList<ServicioBean>();
		LocalDate hoy = null;
		String fecha = hoy.now().toString();
		System.out.println(fecha);
		java.sql.Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conexion.getConexion().createStatement();
			rs = stmt.executeQuery("SELECT * FROM Servicios Where fecha_factura >= '"+fecha +"' ORDER BY fecha_factura");
			while (rs.next()) {
				res.add(new ServicioBean(rs.getInt("servicios_id"), rs.getInt("estancia_id"),
						rs.getInt("servicioHotel_id"), rs.getInt("cliente_id"), rs.getString("lugar"),
						rs.getDate("fecha_factura"), rs.getTime("hora"), rs.getString("tipo_servicio"),
						 rs.getInt("precio")));
			}
		} catch (SQLException ex) {
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

	// Devolver los servicios reservados en una fecha y hora determinada
	public static ArrayList<ServicioBean> getServiciosPorFecha(String dia, String mes, String anio, int hora) {
		ArrayList<ServicioBean> res = new ArrayList<ServicioBean>();
		if (conexion.getConexion() == null)
			conexion.conectar();
		java.sql.Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conexion.getConexion().createStatement();
			rs = stmt.executeQuery("SELECT * FROM Servicios WHERE fecha_factura= '" + anio + "-" + mes + "-" + dia + ""
					+ "' AND " + hora + " >=  HOUR(hora) AND " + hora + " < HOUR(hora_salida)"

			);

			while (rs.next()) {
				res.add(new ServicioBean(rs.getInt("servicios_id"), rs.getInt("estancia_id"),
						rs.getInt("servicioHotel_id"), rs.getInt("cliente_id"), rs.getString("lugar"),
						rs.getDate("fecha_factura"), rs.getTime("hora"), rs.getString("tipo_servicio"),
						 rs.getInt("precio")));
			}
		} catch (SQLException ex) {
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

	public static ArrayList<ServicioBean> getServiciosPorFecha2(Date fecha) {
		ArrayList<ServicioBean> res = new ArrayList<ServicioBean>();
		if (conexion.getConexion() == null)
			conexion.conectar();
		java.sql.Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conexion.getConexion().createStatement();
			rs = stmt.executeQuery("SELECT * FROM Servicios WHERE fecha_factura= '" + fecha + "';");

			while (rs.next()) {
				res.add(new ServicioBean(rs.getInt("servicios_id"), rs.getInt("estancia_id"),
						rs.getInt("servicioHotel_id"), rs.getInt("cliente_id"), rs.getString("lugar"),
						rs.getDate("fecha_factura"), rs.getTime("hora"), rs.getString("tipo_servicio"),
						 rs.getInt("precio")));
			}
		} catch (SQLException ex) {
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

	// Devolver todos los servicios que sean en el restaurante
	public static ArrayList<ServicioBean> getServiciosRestaurante() {
		ArrayList<ServicioBean> res = new ArrayList<ServicioBean>();

		if (conexion.getConexion() == null)
			conexion.conectar();
		java.sql.Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conexion.getConexion().createStatement();
			rs = stmt.executeQuery("SELECT * FROM Servicios WHERE lugar = \"restaurante\"");

			while (rs.next()) {
				res.add(new ServicioBean(rs.getInt("servicios_id"), rs.getInt("estancia_id"),
						rs.getInt("servicioHotel_id"), rs.getInt("cliente_id"), rs.getString("lugar"),
						rs.getDate("fecha_factura"), rs.getTime("hora"), rs.getString("tipo_servicio"),
						 rs.getInt("precio")));
			}
		} catch (SQLException ex) {
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

	// Recibes habitación, nombreHotel, precio, fecha y hora
	public static void recibirMesa(int habitacion_id, String hotel, int precio, Date fecha, Time hora, String tipo) {
		// servicio_id, estancia_id, lugar, fecha factura, hora, tipo servicio,
		// servicioHotel-id, platos, items, hora salida, precio, cliente_id
		if (conexion.getConexion() == null) {
			conexion.conectar();
		}
		int servicio_id = idUltimoServicio() + 1;
		int estancia_id = EstanciaDAO.getEstanciaFecha(habitacion_id, fecha.toString()).getEstancia_id();

		int cliente_id = ClienteDAO.datosCliente(estancia_id).getCliente_id();
		int servicioDelHotel_id = ServiciosDelHotelDAO.getRestauranteId(hotel);
		java.sql.Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement stm = null;
		try {

			stm = conexion.getConexion().prepareStatement("INSERT INTO Servicios values (?,?,?,?,?,?,?,?,?)");
			stm.setInt(1, servicio_id);
			stm.setInt(2, estancia_id);
			stm.setString(3, "restaurante");
			stm.setInt(9, cliente_id);
			stm.setDate(4, fecha);
			stm.setTime(5, hora);
			stm.setString(6, tipo);
			stm.setInt(7, servicioDelHotel_id);
			stm.setInt(8, precio);

			stm.executeUpdate();

		} catch (SQLException ex) {
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
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException sqlEx) {
				}
				stm = null;
			}
		}
	}

	public static void elminarServiciosPorHotel(int hotel_id) {
		if (conexion.getConexion() == null)
			conexion.conectar();

		java.sql.Statement stmt = null;
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stmt = conexion.getConexion().createStatement();
			rs = stmt.executeQuery("select servicios_id from Servicios \r\n"
					+ "join ServiciosHotel as SH on Servicios.servicioHotel_id=SH.servicioHotel_id \r\n"
					+ " where hotel_id=" + hotel_id + ";");
			while (rs.next()) {
				System.out.println(rs.getInt("servicios_id"));
				stm = conexion.getConexion()
						.prepareStatement("delete from Servicios where servicios_id=" + rs.getInt("servicios_id") + ";");
				stm.executeUpdate();
			}
		} catch (SQLException ex) {
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
	}
	//dado habitacion_id y un fecha devuelve los servicios del cliente 
		public static List<ServicioBean> getClienteHabitacionFecha(int habitacion_id, String fecha) { 
			int cliente_id=0; 
			List<ServicioBean> res= new ArrayList<ServicioBean>(); 
		 
			int estancia_id = EstanciaDAO.getEstanciaFecha(habitacion_id, fecha).getEstancia_id(); 
			res= devuelevServiciosreservadosPorunaEstancia(estancia_id); 
			 
			return res; 
		}

}