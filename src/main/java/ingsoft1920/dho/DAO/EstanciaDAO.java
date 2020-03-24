package ingsoft1920.dho.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
	public static String checkIn(int estancia_id) {
		String resp="Procesado correctamente";
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
			resp="Error en checkIn";
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
	public static String checkOut(int estancia_id) {
		String resp="Procesado correctamente";
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
			resp="Error en checkOut";
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
					.prepareStatement("insert into Estancia values (" + estancia_id + ", " + -1 + ", " + hotel_id + ", '" + fecha_inicio + "' , '" + fecha_fin + "', \"reserva\", "
							+ importe + " , "+cliente_id+" )");

			stm2.executeUpdate();

			stmt = conexion.getConexion().createStatement();
			rs = stmt.executeQuery("select habitacion_id from (select est.habitacion_id from Estancia as est "
					+ "join Habitaciones as hab on est.habitacion_id=hab.habitacion_id " + "where est.hotel_id="
					+ hotel_id + " and  hab.tipo_habitacion=\"" + tipo_hab + "\") tabla "
					+ " where tabla.habitacion_id not in (select est.habitacion_id from Estancia as est\r\n"
					+ " join Habitaciones as hab on est.habitacion_id=hab.habitacion_id\r\n" + " where est.hotel_id="
					+ hotel_id + " and  hab.tipo_habitacion=\"" + tipo_hab + "\" \r\n" + " and (est.fecha_fin>'"
					+ fecha_inicio + "' and est.fecha_inicio< '" + fecha_fin + "')  )\r\n"
					+ " group by habitacion_id order by habitacion_id asc limit 1 ;");

			if (rs.next()) {
				try {
					stm = conexion.getConexion().prepareStatement("update Estancia set habitacion_id="
							+ rs.getInt("habitacion_id") + " where estancia_id order by estancia_id desc limit 1;");

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
			} else {
				try {
					stmt2 = conexion.getConexion().createStatement();

					rs2 = stmt.executeQuery(
							"select habitacion_id from Habitaciones where not exists(select habitacion_id from Estancia"
									+ "			 where Estancia.habitacion_id=Habitaciones.habitacion_id group by habitacion_id) and hotel_id="+hotel_id+ " and tipo_habitacion=\""
									+ tipo_hab + "\" limit 1;");
					if (rs2.next()) {
						stm = conexion.getConexion()
								.prepareStatement("update Estancia set habitacion_id=" + rs2.getInt("habitacion_id")
										+ " where estancia_id order by estancia_id desc limit 1;");

						stm.executeUpdate();
					}
					else {
						stm = conexion.getConexion()
								.prepareStatement("delete from Estancia where estancia_id="+estancia_id+";");
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
	
	public static ArrayList<String> getEstadoHabitaciones(String fecha){
		ArrayList<String> res = new ArrayList<String>();
		ArrayList<HabitacionBean> habs = HabitacionDAO.getHabitacionByHotel(-1);
		
		if (conexion.getConexion() == null)
			conexion.conectar();
		java.sql.Statement stmt = null;
		ResultSet rs = null;
		
		for(int i=0; i<habs.size(); i++) {
			try {
			stmt=conexion.getConexion().createStatement();
			rs=stmt.executeQuery("Select estado From Estancia Where habitacion_id= " + habs.get(i).getId_habitacion() + 
					" AND fecha_inicio < '"+fecha +"' AND fecha_fin >'"+fecha +"'");
			if(rs.next()) {
				res.add(i, rs.getString("estado"));
			}
			else {
				res.add(i, "check in");
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
		}
		conexion.desconectar();
		
		return res;
	}

}
