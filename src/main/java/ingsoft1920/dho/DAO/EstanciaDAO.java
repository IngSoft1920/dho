package ingsoft1920.dho.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ingsoft1920.dho.bean.EstanciaBean;
import ingsoft1920.dho.bean.HabitacionBean;
import ingsoft1920.dho.controller.Conexion;

public class EstanciaDAO {
	private static Conexion conexion = new Conexion();

	public EstanciaDAO(Conexion conexion) {
		this.conexion = conexion;
	}

	// devuelve el id de la ultima estancia para saber el id de la siguiente
	public static int idUltimaEstancia() {
		int res = 0;

		if (conexion.getConexion() == null)
			conexion.conectar();

		java.sql.Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conexion.getConexion().createStatement();
			rs = stmt.executeQuery("SELECT MAX(estancia_id) AS n FROM Estancia ORDER BY estancia_id");
			if (rs.next()) {
				res = rs.getInt("n") ;
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

	// dado el cliente_id queremos que nos devuelva la estancia
	public static List<EstanciaBean> getEstancia(int cliente_id) {
		if (conexion.getConexion() == null)
			conexion.conectar();

		List<EstanciaBean> res = new ArrayList<EstanciaBean>();

		java.sql.Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conexion.getConexion().createStatement();
			rs = stmt.executeQuery("SELECT * FROM Estancia WHERE cliente_id =" + cliente_id);
			while (rs.next()) {
				res.add(new EstanciaBean(rs.getInt("estancia_id"), rs.getInt("habitacion_id"), cliente_id,
						rs.getInt("hotel_id"), rs.getDate("fecha_inicio"), rs.getDate("fecha_fin"),
						rs.getString("estado"), rs.getInt("importe")));
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

	// dado el cliente_id queremos que nos devuelva la estancia_id
	public static int getEstaciaId(int cliente_id) {
		if (conexion.getConexion() == null)
			conexion.conectar();

		int res = -1;

		java.sql.Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conexion.getConexion().createStatement();
			rs = stmt.executeQuery("SELECT estancia_id\r\n" + "FROM Estancia\r\n" + "WHERE cliente_id =" + cliente_id);
			if (rs.next()) {
				res = rs.getInt("estancia_id");
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

	// El cliente hace check in
	//
	public static String checkIn(int habitacion_id) {
		EstanciaBean est = new EstanciaBean();
		est = getEstanciaByHabitacionID(habitacion_id);
		int estancia_id = est.getEstancia_id();

		String resp = "Procesado correctamente";
		if (conexion.getConexion() == null)
			conexion.conectar();
		PreparedStatement stm = null;
		try {
			stm = conexion.getConexion()
					.prepareStatement("UPDATE Estancia\r\n" + "SET estado=\"check in\"\r\n" + "WHERE estancia_id = ?");
			stm.setInt(1, estancia_id);
			stm.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			resp = "Error en checkIn";
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
		return resp;
	}

	public static String checkInPorEstancia_id(int estancia_id) {
		EstanciaBean est = new EstanciaBean();
		String resp = "Procesado correctamente";
		if (conexion.getConexion() == null)
			conexion.conectar();
		PreparedStatement stm = null;
		try {
			stm = conexion.getConexion()
					.prepareStatement("UPDATE Estancia\r\n" + "SET estado=\"check in\"\r\n" + "WHERE estancia_id = ?");
			stm.setInt(1, estancia_id);
			stm.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			resp = "Error en checkIn";
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
		return resp;
	}

	// El cliente hace check out
	public static String checkOut(int habitacion_id) {
		EstanciaBean est = new EstanciaBean();
		est = getEstanciaByHabitacionID(habitacion_id);
		int estancia_id = est.getEstancia_id();

		String resp = "Procesado correctamente";
		if (conexion.getConexion() == null)
			conexion.conectar();
		PreparedStatement stm = null;
		try {
			stm = conexion.getConexion()
					.prepareStatement("UPDATE Estancia\r\n" + "SET estado=\"check out\"\r\n" + "WHERE estancia_id = ?");
			stm.setInt(1, estancia_id);
			stm.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			resp = "Error en checkOut";
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
		return resp;
	}

	public static String checkOutPorEstancia_id(int estancia_id) {
		EstanciaBean est = new EstanciaBean();
		String resp = "Procesado correctamente";
		if (conexion.getConexion() == null)
			conexion.conectar();
		PreparedStatement stm = null;
		try {
			stm = conexion.getConexion()
					.prepareStatement("UPDATE Estancia\r\n" + "SET estado=\"check out\"\r\n" + "WHERE estancia_id = ?");
			stm.setInt(1, estancia_id);
			stm.executeUpdate();
		} catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
			resp = "Error en checkIn";
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
		return resp;
	}
	// Para hecer el precheck in
		public static String precheckIn(int habitacion_id) {
			EstanciaBean est = new EstanciaBean();
			est = getEstanciaByHabitacionID(habitacion_id);
			int estancia_id = est.getEstancia_id();

			String resp = "Procesado correctamente";
			if (conexion.getConexion() == null)
				conexion.conectar();
			PreparedStatement stm = null;
			try {
				stm = conexion.getConexion()
						.prepareStatement("UPDATE Estancia\r\n" + "SET estado=\"precheck in\"\r\n" + "WHERE estancia_id = ?");
				stm.setInt(1, estancia_id);
				stm.executeUpdate();
			} catch (SQLException ex) {
				System.out.println("SQLException: " + ex.getMessage());
				resp = "Error en precheckIn";
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
			return resp;
		}
		//para hacer precheck in con estancia_id
		public static String precheckInPorEstancia_id(int estancia_id) {
			EstanciaBean est = new EstanciaBean();
			String resp = "Procesado correctamente";
			if (conexion.getConexion() == null)
				conexion.conectar();
			PreparedStatement stm = null;
			try {
				stm = conexion.getConexion()
						.prepareStatement("UPDATE Estancia\r\n" + "SET estado=\"precheck in\"\r\n" + "WHERE estancia_id = ?");
				stm.setInt(1, estancia_id);
				stm.executeUpdate();
			} catch (SQLException ex) {
				System.out.println("SQLException: " + ex.getMessage());
				resp = "Error en precheckIn";
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
			return resp;
		}
	public static ArrayList<EstanciaBean> geEstanciaBeans() {
		if (conexion.getConexion() == null)
			conexion.conectar();

		ArrayList<EstanciaBean> res = new ArrayList<EstanciaBean>();

		java.sql.Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conexion.getConexion().createStatement();
			rs = stmt.executeQuery("SELECT * FROM Estancia ORDER BY habitacion_id");
			while (rs.next()) {
				res.add(new EstanciaBean(rs.getInt("estancia_id"), rs.getInt("habitacion_id"), rs.getInt("cliente_id"),
						rs.getInt("hotel_id"), rs.getDate("fecha_inicio"), rs.getDate("fecha_fin"),
						rs.getString("estado"), rs.getInt("importe")));
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

	public static ArrayList<EstanciaBean> getReservas() {
		if (conexion.getConexion() == null)
			conexion.conectar();

		ArrayList<EstanciaBean> res = new ArrayList<EstanciaBean>();

		java.sql.Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conexion.getConexion().createStatement();
			rs = stmt.executeQuery("SELECT * FROM Estancia WHERE estado = \"reserva\" ORDER BY habitacion_id");
			while (rs.next()) {
				res.add(new EstanciaBean(rs.getInt("estancia_id"), rs.getInt("habitacion_id"), rs.getInt("cliente_id"),
						rs.getInt("hotel_id"), rs.getDate("fecha_inicio"), rs.getDate("fecha_fin"),
						rs.getString("estado"), rs.getInt("importe")));
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

	public static ArrayList<EstanciaBean> getCheckIn() {
		if (conexion.getConexion() == null)
			conexion.conectar();

		ArrayList<EstanciaBean> res = new ArrayList<EstanciaBean>();

		java.sql.Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conexion.getConexion().createStatement();
			rs = stmt.executeQuery("SELECT * FROM Estancia WHERE estado = \"check in\" ORDER BY habitacion_id");
			while (rs.next()) {
				res.add(new EstanciaBean(rs.getInt("estancia_id"), rs.getInt("habitacion_id"), rs.getInt("cliente_id"),
						rs.getInt("hotel_id"), rs.getDate("fecha_inicio"), rs.getDate("fecha_fin"),
						rs.getString("estado"), rs.getInt("importe")));
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

	public static ArrayList<EstanciaBean> getCheckOut() {
		if (conexion.getConexion() == null)
			conexion.conectar();

		ArrayList<EstanciaBean> res = new ArrayList<EstanciaBean>();

		java.sql.Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conexion.getConexion().createStatement();
			rs = stmt.executeQuery("SELECT * FROM Estancia WHERE estado = \"check out\" ORDER BY habitacion_id");
			while (rs.next()) {
				res.add(new EstanciaBean(rs.getInt("estancia_id"), rs.getInt("habitacion_id"), rs.getInt("cliente_id"),
						rs.getInt("hotel_id"), rs.getDate("fecha_inicio"), rs.getDate("fecha_fin"),
						rs.getString("estado"), rs.getInt("importe")));
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

	public static String anadirEstancia(int estancia_id, int cliente_id, int hotel_id, String fecha_inicio,
			String fecha_fin, int tipo_hab_id, int importe) {
		if (conexion.getConexion() == null)
			conexion.conectar();
		PreparedStatement stm2 = null;
		java.sql.Statement stmt = null;
		ResultSet rs = null;
		java.sql.Statement stmt2 = null;
		ResultSet rs2 = null;
		PreparedStatement stm = null;

		try {
			String tipo_hab = HabitacionDAO.tipoHabitacion(tipo_hab_id);

			stm2 = conexion.getConexion()
					.prepareStatement("insert into Estancia values (" + estancia_id + ", " + -1 + ", " + hotel_id
							+ ", '" + fecha_inicio + "' , '" + fecha_fin + "', \"reserva\", " + importe + " , "
							+ cliente_id + " )");

			stm2.executeUpdate();

			stmt = conexion.getConexion().createStatement();
			rs = stmt.executeQuery("select habitacion_id from (select est.habitacion_id from Estancia as est "
					+ "join Habitaciones as hab on est.habitacion_id=hab.habitacion_id " + "where est.hotel_id="
					+ hotel_id + " and  hab.tipo_habitacion=\"" + tipo_hab + "\") tabla "
					+ " where tabla.habitacion_id not in (select est.habitacion_id from Estancia as est\r\n"
					+ " join Habitaciones as hab on est.habitacion_id=hab.habitacion_id\r\n" + " where est.hotel_id="
					+ hotel_id + " and  hab.tipo_habitacion=\"" + tipo_hab + "\" \r\n" + " and (est.fecha_fin>='"
					+ fecha_inicio + "' and est.fecha_inicio<= '" + fecha_fin + "')  )\r\n"
					+ " group by habitacion_id order by habitacion_id asc limit 1 ;");

			if (rs.next()) {
				try {
					stm = conexion.getConexion().prepareStatement("update Estancia set habitacion_id="
							+ rs.getInt("habitacion_id") + " where estancia_id=" + estancia_id + ";");

					stm.executeUpdate();
					return rs.getString("habitacion_id");

				} catch (SQLException ex) {
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
			} else {
				try {
					stmt2 = conexion.getConexion().createStatement();

					rs2 = stmt.executeQuery(
							"select habitacion_id from Habitaciones where not exists(select habitacion_id from Estancia"
									+ "			 where Estancia.habitacion_id=Habitaciones.habitacion_id group by habitacion_id) and hotel_id="
									+ hotel_id + " and tipo_habitacion=\"" + tipo_hab + "\" limit 1;");
					if (rs2.next()) {
						stm = conexion.getConexion().prepareStatement("update Estancia set habitacion_id="
								+ rs2.getInt("habitacion_id") + " where estancia_id=" + estancia_id + ";");

						stm.executeUpdate();
						return rs2.getString("habitacion_id");
					} else {
						stm = conexion.getConexion()
								.prepareStatement("delete from Estancia where estancia_id=" + estancia_id + ";");
						stm.executeUpdate();
						return "Ninguna habitacion disponible";
					}
				} catch (SQLException ex) {
					System.out.println("SQLException: " + ex.getMessage());
				} finally { // it is a good idea to release resources in a finally block
					if (rs2 != null) {
						try {
							rs2.close();
						} catch (SQLException sqlEx) {
						}
						rs2 = null;
					}
					if (stmt2 != null) {
						try {
							stmt2.close();
						} catch (SQLException sqlEx) {
						}
						stmt2 = null;
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
			if (stm2 != null) {
				try {
					stm2.close();
				} catch (SQLException sqlEx) {
				}
				stm2 = null;
			}
		}
		conexion.desconectar();
		return "Procesado correctamente";

	}

	public static ArrayList<String> getEstadoHabitaciones(String fecha) {
		ArrayList<String> res = new ArrayList<String>();
		ArrayList<HabitacionBean> habs = HabitacionDAO.getHabitacionByHotel(6);

		if (conexion.getConexion() == null)
			conexion.conectar();
		java.sql.Statement stmt = null;
		ResultSet rs = null;

		for (int i = 0; i < habs.size(); i++) {
			try {
				stmt = conexion.getConexion().createStatement();
				rs = stmt.executeQuery(
						"Select estado From Estancia Where habitacion_id= " + habs.get(i).getId_habitacion()
								+ " AND fecha_inicio <= '" + fecha + "' AND fecha_fin >= '" + fecha + "'");
				if (rs.next()) {
					res.add(i, rs.getString("estado"));
				} else {
					res.add(i, "check out");
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
		}
		conexion.desconectar();

		return res;
	}

	// Dado el id de una habitacion devuelve la estancia (en la fecha del dia en el
	// que estamos)
	public static EstanciaBean getEstanciaByHabitacionID(int habitacion_id) {
		EstanciaBean res = new EstanciaBean();
		if (conexion.getConexion() == null)
			conexion.conectar();

		java.sql.Statement stmt = null;
		ResultSet rs = null;
		String hoy = LocalDate.now().toString();

		try {
			stmt = conexion.getConexion().createStatement();
			rs = stmt.executeQuery("SELECT * FROM Estancia WHERE habitacion_id = " + habitacion_id
					+ " AND fecha_inicio < '" + hoy + "' AND fecha_fin > '" + hoy + "'");

			if (rs.next()) {
				res.setEstancia_id(rs.getInt("estancia_id"));
				res.setCliente_id(rs.getInt("cliente_id"));
				res.setEstado(rs.getString("estado"));
				res.setFecha_fin(rs.getDate("fecha_fin"));
				res.setFecha_inicio(rs.getDate("fecha_inicio"));
				res.setHotel_id(rs.getInt("hotel_id"));
				res.setImporte(rs.getInt("importe"));
			} else {
				System.out.println("No hay ninguna estancia para esta habitacion.");
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

	// añade un estancia bean a la base de datos
	public static void anadirEstanciaBean(EstanciaBean estancia) {
		if (conexion.getConexion() == null)
			conexion.conectar();
		PreparedStatement stm = null;

		try {
			stm = conexion.getConexion().prepareStatement("INSERT INTO Estancia VALUES(?,?,?,?,?,?,?,?)");
			stm.setInt(1, estancia.getEstancia_id());
			stm.setInt(2, estancia.getHabitacion_id());
			stm.setInt(3, estancia.getHotel_id());
			stm.setDate(4, estancia.getFecha_inicio());
			stm.setDate(5, estancia.getFecha_fin());
			stm.setString(6, estancia.getEstado());
			stm.setInt(7, estancia.getImporte());
			stm.setInt(8, estancia.getCliente_id());
			stm.executeUpdate();

		} catch (SQLException ex) {
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

	public static EstanciaBean getEstanciaFecha(int habitacion_id, String fecha) {
		EstanciaBean res = new EstanciaBean();
		
		if (conexion.getConexion() == null)
			conexion.conectar();

		java.sql.Statement stmt = null;
		ResultSet rs = null;
		

		try {
			stmt = conexion.getConexion().createStatement();
			rs = stmt.executeQuery("SELECT * FROM Estancia WHERE habitacion_id = " + habitacion_id
					+ " AND fecha_inicio <='" + fecha + "' AND fecha_fin >='" + fecha + "'");

			if (rs.next()) {
				res.setEstancia_id(rs.getInt("estancia_id"));
				res.setHabitacion_id(habitacion_id);
				res.setCliente_id(rs.getInt("cliente_id"));
				res.setEstado(rs.getString("estado"));
				res.setFecha_fin(rs.getDate("fecha_fin"));
				res.setFecha_inicio(rs.getDate("fecha_inicio"));
				res.setHotel_id(rs.getInt("hotel_id"));
				res.setImporte(rs.getInt("importe"));
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

	public static ArrayList<EstanciaBean> getCheckOutDeCliente(int cliente_id) {
		if (conexion.getConexion() == null)
			conexion.conectar();

		ArrayList<EstanciaBean> res = new ArrayList<EstanciaBean>();

		java.sql.Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conexion.getConexion().createStatement();
			rs = stmt.executeQuery("SELECT * FROM Estancia WHERE estado = \"check out\" and cliente_id =" + cliente_id+";");
			while (rs.next()) {
				res.add(new EstanciaBean(rs.getInt("estancia_id"), rs.getInt("habitacion_id"), rs.getInt("cliente_id"),
						rs.getInt("hotel_id"), rs.getDate("fecha_inicio"), rs.getDate("fecha_fin"),
						rs.getString("estado"), rs.getInt("importe")));
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
}
