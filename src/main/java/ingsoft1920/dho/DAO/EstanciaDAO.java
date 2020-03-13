package ingsoft1920.dho.DAO;

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
						rs.getString("estado")));
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
	public static void checkIn(int cliente_id) {

		if (conexion.getConexion() == null)
			conexion.conectar();
		PreparedStatement stm = null;
		try {
			stm = conexion.getConexion()
					.prepareStatement("UPDATE Estancia\r\n" + "SET estado=\"check in\"\r\n" + "WHERE cliente_id = ?");
			stm.setInt(1, cliente_id);
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

	// El cliente hace check out
	public static void checkOut(int cliente_id) {
		if (conexion.getConexion() == null)
			conexion.conectar();
		PreparedStatement stm = null;
		try {
			stm = conexion.getConexion()
					.prepareStatement("UPDATE Estancia\r\n" + "SET estado=\"check out\"\r\n" + "WHERE cliente_id = ?");
			stm.setInt(1, cliente_id);
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

	public static ArrayList<EstanciaBean> geEstanciaBeans() {
		if (conexion.getConexion() == null)
			conexion.conectar();

		ArrayList<EstanciaBean> res = new ArrayList<EstanciaBean>();

		java.sql.Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = conexion.getConexion().createStatement();
			rs = stmt.executeQuery("SELECT * FROM Estancia");
			while (rs.next()) {
				res.add(new EstanciaBean(rs.getInt("estancia_id"), rs.getInt("habitacion_id"), rs.getInt("cliente_id"),
						rs.getInt("hotel_id"), rs.getDate("fecha_inicio"), rs.getDate("fecha_fin"),
						rs.getString("estado")));
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
			rs = stmt.executeQuery("SELECT * FROM Estancia WHERE estado = \"reserva\"");
			while (rs.next()) {
				res.add(new EstanciaBean(rs.getInt("estancia_id"), rs.getInt("habitacion_id"), rs.getInt("cliente_id"),
						rs.getInt("hotel_id"), rs.getDate("fecha_inicio"), rs.getDate("fecha_fin"),
						rs.getString("estado")));
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
			rs = stmt.executeQuery("SELECT * FROM Estancia WHERE estado = \"check in\"");
			while (rs.next()) {
				res.add(new EstanciaBean(rs.getInt("estancia_id"), rs.getInt("habitacion_id"), rs.getInt("cliente_id"),
						rs.getInt("hotel_id"), rs.getDate("fecha_inicio"), rs.getDate("fecha_fin"),
						rs.getString("estado")));
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
			rs = stmt.executeQuery("SELECT * FROM Estancia WHERE estado = \"check out\"");
			while (rs.next()) {
				res.add(new EstanciaBean(rs.getInt("estancia_id"), rs.getInt("habitacion_id"), rs.getInt("cliente_id"),
						rs.getInt("hotel_id"), rs.getDate("fecha_inicio"), rs.getDate("fecha_fin"),
						rs.getString("estado")));
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

	public static void anadirEstancia(int cliente_id, int hotel_id, String fecha_inicio, String fecha_fin,
			int tipo_hab_id) {
		if (conexion.getConexion() == null)
			conexion.conectar();


		java.sql.Statement stmt = null;
		ResultSet rs = null;
		/*try {
			delete from aux where id=1;
			insert into estancia(habitacion_id,cliente_id,hotel_id,fecha_inicio,fecha_fin,estado) values (-1,2,1,'2020-03-05','2020-03-10', 'reservada');
			insert into aux values (1,(select habitacion_id from (select est.habitacion_id from estancia as est
										join habitaciones as hab on est.habitacion_id=hab.habitacion_id
										where est.hotel_id=1 and  hab.tipo_habitacion='normal') tabla
					where tabla.habitacion_id not in (select est.habitacion_id from estancia as est
										join habitaciones as hab on est.habitacion_id=hab.habitacion_id
										where est.hotel_id=1 and  hab.tipo_habitacion='normal' 
			                            and ((est.fecha_fin>'2020-03-05'and est.fecha_inicio<'2020-03-10') ) )
					group by habitacion_id order by habitacion_id asc limit 1) );


			--  si aux.hab = null 
			update aux set hab=(select habitacion_id from habitaciones where not exists(select habitacion_id from estancia
			 where estancia.habitacion_id=habitaciones.habitacion_id group by habitacion_id) and tipo_habitacion='normal' limit 1) where id=1;

			-- siempre
			update estancia set habitacion_id=(select hab from aux where id=1) where estancia_id order by estancia_id desc limit 1;
			

		}catch(SQLException ex)
	{
		System.out.println("SQLException: " + ex.getMessage());
	}finally
	{ // it is a good idea to release resources in a finally block
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
	}*/conexion.desconectar();

}

}
