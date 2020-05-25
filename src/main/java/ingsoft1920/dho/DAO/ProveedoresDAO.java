package ingsoft1920.dho.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import ingsoft1920.dho.bean.HotelBean;
import ingsoft1920.dho.bean.ProveedoresBean;
import ingsoft1920.dho.controller.Conexion;

public class ProveedoresDAO {
	private static Conexion conexion = new Conexion();

	public ProveedoresDAO(Conexion conexion) {
		this.conexion = conexion;
	}

	public static void anadirProveedor(ProveedoresBean proveedor) {

		if (conexion.getConexion() == null)
			conexion.conectar();

		PreparedStatement stm = null;
		try {

			stm = conexion.getConexion().prepareStatement("INSERT INTO Proveedores values (?,?,?)");
			stm.setInt(1, proveedor.getProveedor_id());
			stm.setString(2, proveedor.getEmpresa());
			stm.setInt(3, proveedor.getHotel_id());

			stm.executeUpdate();
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
		}

	}

}
