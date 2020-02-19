package ingsoft1920.dho.controller;


/*
 * Aqui vamos haciendo todas las pruebas relacionadas con la base de datos para ver que funciona correctamente
 */
public class PruebasBaseDatos {
	public static void main(String[]args) {
	String servidor,puerto,usuario,contraseña,baseDeDatos;
	servidor="piedrafita.ls.fi.upm.es";
	puerto="8000";
	usuario="dho2";
	contraseña="ingSoft20dho2.336";
	baseDeDatos="dho";
	Conexion conexion = new Conexion();
	Conexion.init(servidor,puerto,usuario,contraseña,baseDeDatos);
	}
}
