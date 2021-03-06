package ingsoft1920.dho.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Conexion {
	private static Connection conn = null;
	private static String servidor = "piedrafita.ls.fi.upm.es";
	private static String usuario = "dho2";
	private static String contrasena = "ingSoft20dho2.336"; 
	private static String baseDeDatos = "dho";
	private static String puerto = "8000";

	public Connection getConexion() {
		return this.conn;
	}
	public static void conectar (){
		if (conn==null){
			try {
				Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

				conn = DriverManager.getConnection("jdbc:mysql://"+servidor+":"+puerto+"/"+baseDeDatos+"?" +       
						"user="+usuario+"&password=" + contrasena +
						"&useJDBCCompliantTimezoneShift=true");
			} catch (SQLException ex) { 
				System.out.println("SQLException: " + ex.getMessage());     
				System.out.println("SQLState: " + ex.getSQLState()); 
				System.out.println("VendorError: " + ex.getErrorCode()); 
			}catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}

	public static void init (String servidor, String puerto,String usuario, String contrasena, String baseDeDatos){
		Conexion.servidor = servidor;
		Conexion.usuario = usuario; 
		Conexion.contrasena = contrasena;
		Conexion.baseDeDatos = baseDeDatos;
		Conexion.puerto = puerto;

		if (conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
	public static void desconectar() {
		if (conn!=null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}
}
