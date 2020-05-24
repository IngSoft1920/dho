package ingsoft1920.dho.DAO;

import ingsoft1920.dho.bean.HabitacionBean;
import ingsoft1920.dho.bean.HotelBean;
import ingsoft1920.dho.controller.Conexion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class HabitacionDAO {

	private static Conexion conexion = new Conexion();

	public HabitacionDAO(Conexion conexion) {
		this.conexion = conexion;
	}

	// Dado el int del tipo devuelve un string
	public static String tipoHabitacion(int id) {
		String res = null;
		if (id == 1) {
			res = "normal";
		} else if (id == 2) {
			res = "premium";
		} else if (id == 3) {
			res = "presidencial";
		}

		return res;
	}

	// Dado el int del tipo devuelve un string
	public static int idTipoHabitacion(String tipo) {
		int res = 0;
		if (tipo.equals("normal")) {
			res = 1;
		} else if (tipo.equals("premium")) {
			res = 2;
		} else if (tipo.equals("presidencial")) {
			res = 3;
		}

		return res;
	}

	public static HabitacionBean getHabitacionPorId(int id_cliente) {
		// Devuelve la habitacion que ha alquilado un cliente
		if (conexion.getConexion() == null)
			conexion.conectar();

		HabitacionBean res = null;

		java.sql.Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conexion.getConexion().createStatement();
			rs = stmt.executeQuery("SELECT h.habitacion_id,h.tipo_habitacion,h.hotel_id\r\n,h.capacidad"
					+ "FROM Habitaciones AS h\r\n" + "JOIN Estancia AS e ON h.habitacion_id=e.habitacion_id\r\n"
					+ "WHERE cliente_id = " + id_cliente);
			if (rs.next()) {
				res = new HabitacionBean(rs.getInt("habitacion_id"), rs.getInt("hotel_id"),
						rs.getString("tipo_habitacion"), rs.getInt("capacidad"));

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

	// Dado el id de un cliente saber cuantos dias esta reservada su habitacion
	// de momento un cliente solo tiene una estancia a su nombre -> luego ampliar
	// para que con un id_cliente se puedan guardar varias estancias
	public static int diasReserva(int cliente_id) {
		if (conexion.getConexion() == null)
			conexion.conectar();

		int res = 0;
		java.sql.Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conexion.getConexion().createStatement();
			rs = stmt.executeQuery(
					"SELECT DATEDIFF(fecha_fin, fecha_inicio) as n FROM Estancia WHERE cliente_id=" + cliente_id);
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

	/// Dado habitacion_id devuelve el HabitacionBean
	// Si la habitacion no existe devuelve null
	public static HabitacionBean getHabitacion(int habitacion_id) {
		HabitacionBean res = new HabitacionBean();
		res.setId_habitacion(habitacion_id);
		String tipo = null;
		int hotel_id = 0;

		if (conexion == null) {
			conexion.conectar();
		}
		java.sql.Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conexion.getConexion().createStatement();
			rs = stmt.executeQuery("SELECT * FROM Habitaciones WHERE habitacion_id = " + habitacion_id);
			if (rs.next()) {
				tipo = rs.getString("tipo_habitacion");
				hotel_id = rs.getInt("hotel_id");

			}
			res.setId_hotel(hotel_id);
			res.setTipo_habitacion(tipo);

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

	// Devolver las habitaciones de un hotel
	public static ArrayList<HabitacionBean> getHabitacionByHotel(int hotel_id) {
		if (conexion.getConexion() == null)
			conexion.conectar();

		ArrayList<HabitacionBean> res = new ArrayList<HabitacionBean>();

		java.sql.Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conexion.getConexion().createStatement();
			rs = stmt.executeQuery("SELECT * FROM Habitaciones WHERE hotel_id = " + hotel_id);
			while (rs.next()) {
				res.add(new HabitacionBean(rs.getInt("habitacion_id"), rs.getInt("hotel_id"),
						rs.getString("tipo_habitacion"), rs.getInt("capacidad")));

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

	// devuelve el id de la ultima habitacion para saber el id de la siguiente
	public static int idUltimaHabitacion() {
		int res = 0;

		if (conexion.getConexion() == null)
			conexion.conectar();

		java.sql.Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conexion.getConexion().createStatement();
			rs = stmt.executeQuery("SELECT MAX(habitacion_id) AS n FROM Habitaciones ");
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
		conexion.desconectar();
		return res;
	}
	
	public static HabitacionBean getHabitacionPorIdEstancia(int id_estancia) {
		// Devuelve la habitacion que ha alquilado un cliente
		if (conexion.getConexion() == null)
			conexion.conectar();

		HabitacionBean res = null;

		java.sql.Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conexion.getConexion().createStatement();
			rs = stmt.executeQuery("SELECT h.habitacion_id,h.tipo_habitacion,h.hotel_id ,h.capacidad "
					+ "FROM Habitaciones AS h JOIN Estancia AS e ON h.habitacion_id=e.habitacion_id "
					+ "WHERE estancia_id =" + id_estancia+";");
			if (rs.next()) {
				res = new HabitacionBean(rs.getInt("habitacion_id"), rs.getInt("hotel_id"),
						rs.getString("tipo_habitacion"), rs.getInt("capacidad"));

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

	// añade habitaciones a la base de datos
	public static void anadirHabitaciones(HabitacionBean habitacion, int num_Disponibles) {
		int habitacion_id = -1;
		// consulta de añadir un servicio a la tabla servicios

		for (int i = 0; i < num_Disponibles; i++) {
			if (conexion.getConexion() == null)
				conexion.conectar();
			PreparedStatement stm = null;
			java.sql.Statement stmt = null;
			ResultSet rs = null;
			try {
				stmt = conexion.getConexion().createStatement();
				rs = stmt.executeQuery("SELECT MAX(habitacion_id) AS n FROM Habitaciones ");
				if (rs.next()) {
					habitacion_id = rs.getInt("n") + 1;

					stm = conexion.getConexion().prepareStatement("INSERT INTO Habitaciones VALUES (?,?,?,?)");
					stm.setInt(1, habitacion_id);
					stm.setString(2, habitacion.getTipo_habitacion());
					stm.setInt(3, habitacion.getId_hotel());
					stm.setInt(4, 0);

					stm.executeUpdate();

				}
			}

			catch (SQLException ex) {
				System.out.println("SQLException: " + ex.getMessage());
			} finally { // it is a good idea to release resources in a finally block
				if (stm != null) {
					try {
						stm.close();
					} catch (SQLException sqlEx) {
					}
					stm = null;
				}
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

		}
	}
}