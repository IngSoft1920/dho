package ingsoft1920.dho.DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import ingsoft1920.dho.bean.ProductosBean;
import ingsoft1920.dho.bean.ProveedoresBean;
import ingsoft1920.dho.controller.Conexion;

public class ProductosDAO {
	public static Conexion conexion = new Conexion();
	
	public ProductosDAO(Conexion conexion) {
		this.conexion = conexion;
	}
	public static void anadirProducto(ProductosBean producto) {

		if (conexion.getConexion() == null)
			conexion.conectar();

		PreparedStatement stm = null;
		try {

			stm = conexion.getConexion().prepareStatement("INSERT INTO Productos values (?,?,?,?,?)");
			stm.setInt(1, producto.getProducto_id());
			stm.setString(2, producto.getNombre());
			stm.setInt(3, producto.getPrecio());
			stm.setInt(4, producto.getProveedor_id());
			stm.setString(5, producto.getUnidad());

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
