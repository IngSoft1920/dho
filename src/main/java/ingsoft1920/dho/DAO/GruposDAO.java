package ingsoft1920.dho.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ingsoft1920.dho.bean.EstanciaBean;
import ingsoft1920.dho.bean.GruposBean;
import ingsoft1920.dho.controller.Conexion;

public class GruposDAO {
	private static Conexion conexion = new Conexion();

	public GruposDAO(Conexion conexion) {
		this.conexion = conexion;
	}

	// Metodo para añadir reservas de grupos
	public static void añadirReservaGrupos(GruposBean grupo) {

		if (conexion.getConexion() == null)
			conexion.conectar();
		int grupo_id=-1;

		PreparedStatement stm = null;
		java.sql.Statement stmt1 = null;
		ResultSet rs1 = null;
		try {
			stmt1 = conexion.getConexion().createStatement();
			rs1 = stmt1.executeQuery("SELECT MAX(grupo_id)\r\n" + "FROM Grupos;");
			if (rs1.next()) {
				grupo_id=rs1.getInt("MAX(grupo_id)")+1;
				stm = conexion.getConexion().prepareStatement("INSERT INTO Grupos values (?,?,?,?,?,?,?,?,?,?)");
				stm.setInt(1, grupo_id);
				stm.setString(2, grupo.getNombre());
				stm.setString(3, grupo.getTipo());
				stm.setString(4, grupo.getEmail());
				stm.setInt(5, grupo.getHotel_id());
				stm.setInt(6, grupo.getNum_habitaciones());
				stm.setInt(7, grupo.getNum_personas());
				stm.setDate(8, grupo.getFecha_entrada());
				stm.setDate(9, grupo.getFecha_salida());
				stm.setString(10, "solicitado");
				stm.executeUpdate();
			}
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

	// Metodo que dado el hotel_id te devuelve un arraylist de todas las reservas de
	// grupo que hay en ese hotel
	public static ArrayList<GruposBean> reservasPorHotelID(int hotel_id) {
		ArrayList<GruposBean> res = new ArrayList<GruposBean>();

		if (conexion.getConexion() == null)
			conexion.conectar();

		java.sql.Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conexion.getConexion().createStatement();
			rs = stmt.executeQuery("SELECT * FROM Grupos WHERE hotel_id =" + hotel_id);

			while (rs.next()) {
				res.add(new GruposBean(rs.getInt("grupo_id"), rs.getString("nombre"), rs.getString("tipo"),
						rs.getString("email"), hotel_id, rs.getInt("num_habitaciones"), rs.getInt("num_personas"),
						rs.getDate("fecha_entrada"), rs.getDate("fecha_salida"), rs.getString("estado")));

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
	public static GruposBean reservasPorGrupoID(int grupo_id) {
		GruposBean res = new GruposBean();
		
		if (conexion.getConexion() == null)
			conexion.conectar();

		java.sql.Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conexion.getConexion().createStatement();
			rs = stmt.executeQuery("SELECT * FROM Grupos WHERE grupo_id =" + grupo_id);

			while (rs.next()) {
				GruposBean aux = new GruposBean(grupo_id, rs.getString("nombre"), rs.getString("tipo"),
						rs.getString("email"), rs.getInt("hotel_id"), rs.getInt("num_habitaciones"), rs.getInt("num_personas"),
						rs.getDate("fecha_entrada"), rs.getDate("fecha_salida"), rs.getString("estado"));
						res = aux;
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
	//Devuelve todas las reservas de grupos que hay en la bbdd
	public static ArrayList<GruposBean> getReservasGrupo() {
		ArrayList<GruposBean> res = new ArrayList<GruposBean>();

		if (conexion.getConexion() == null)
			conexion.conectar();

		java.sql.Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conexion.getConexion().createStatement();
			rs = stmt.executeQuery("SELECT * FROM Grupos");

			while (rs.next()) {
				res.add(new GruposBean(rs.getInt("grupo_id"), rs.getString("nombre"), rs.getString("tipo"),
						rs.getString("email"), rs.getInt("hotel_id"), rs.getInt("num_habitaciones"), rs.getInt("num_personas"),
						rs.getDate("fecha_entrada"), rs.getDate("fecha_salida"), rs.getString("estado")));

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

	
	//cambia estado a aceptado
	public static void aceptarReservaGrupo(int grupo_id) {
		if (conexion.getConexion() == null)
			conexion.conectar();

		PreparedStatement stmt = null;
		
		
		try {
			stmt = conexion.getConexion()
					.prepareStatement("UPDATE Grupos SET estado=\"aceptado\" WHERE grupo_id ="+grupo_id);
			stmt.executeUpdate();
		}catch (SQLException ex) {
			System.out.println("SQLException: " + ex.getMessage());
		} finally { // it is a good idea to release resources in a finally block
			
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
	//cambia estado a denegado
		public static void denegarReservaGrupo(int grupo_id) {
			if (conexion.getConexion() == null)
				conexion.conectar();

			PreparedStatement stmt = null;
			
			
			try {
				stmt = conexion.getConexion()
						.prepareStatement("UPDATE Grupos SET estado=\"denegado\" WHERE grupo_id ="+grupo_id);
				stmt.executeUpdate();
			}catch (SQLException ex) {
				System.out.println("SQLException: " + ex.getMessage());
			} finally { // it is a good idea to release resources in a finally block
				
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
		
		//cambia estado a pendiente
				public static void pendienteReservaGrupo(int grupo_id) {
					if (conexion.getConexion() == null)
						conexion.conectar();

					PreparedStatement stmt = null;
					
					
					try {
						stmt = conexion.getConexion()
								.prepareStatement("UPDATE Grupos SET estado=\"pendiente\" WHERE grupo_id ="+grupo_id);
						stmt.executeUpdate();
					}catch (SQLException ex) {
						System.out.println("SQLException: " + ex.getMessage());
					} finally { // it is a good idea to release resources in a finally block
						
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
		
		//Dado el grupo_id y un estado, cambiar al estado especificado
				public static String cambiarEstado(int grupo_id, String estado) {
					if (conexion.getConexion() == null)
						conexion.conectar();

					PreparedStatement stmt = null;
					
					
					try {
						stmt = conexion.getConexion()
								.prepareStatement("UPDATE Grupos SET estado=\""+estado+"\" WHERE grupo_id ="+grupo_id);
						stmt.executeUpdate();
					}catch (SQLException ex) {
						System.out.println("SQLException: " + ex.getMessage());
					} finally { // it is a good idea to release resources in a finally block
						
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
