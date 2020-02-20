package ingsoft1920.dho.controller;

import ingsoft1920.dho.DAO.HabitacionDAO;
import ingsoft1920.dho.DAO.IncidenciaDAO;
import ingsoft1920.dho.DAO.ServicioDAO;
import ingsoft1920.dho.DAO.ServiciosDelHotelDAO;
import ingsoft1920.dho.DAO.TareaDAO;
import ingsoft1920.dho.bean.IncidenciaBean;
import ingsoft1920.dho.bean.ServicioBean;
import ingsoft1920.dho.bean.ServiciosDelHotelBean;
import ingsoft1920.dho.bean.TareaBean;

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
	Conexion.conectar();
	/*
	 * Comienzo aqui a probar las consultas(Ire comentando las que funcionan)
	 * Funcionan:
	 		getHabitacionPorId
	 		BuscarIncidenciaPor
	 		añadirIncidencia
	 		añadirServicio
	 		darServiciosHotel
	 		añadirTarea
	 	No Funcionan:
	 	
	 	Faltan por probar:
	 		recibirTarea
	*/
	
	/*
	HabitacionDAO prueba1= new HabitacionDAO(conexion);
	System.out.println(prueba1.getHabitacionPorId(1));
	*/
	/*
	IncidenciaDAO prueba2=new IncidenciaDAO(conexion);
	System.out.println(prueba2.BuscarIncidenciaPor("habitacion 2"));
	*/
	/*
	 //Le he puesto id -1 porque el constructor te pide un id, pero este en verdad se genera al momento de meterlo en la base de datos
	IncidenciaBean a = new IncidenciaBean(-1,"limpiar","esto es una prueba","cocina",null);
	IncidenciaDAO prueba3=new IncidenciaDAO(conexion);
	prueba3.añadirIncidencia(a);
	*/
	/*
	ServicioBean b = new ServicioBean(-1,1,1,1,"cocina",null,null,"hacer una prueba");
	ServicioDAO prueba4=new ServicioDAO(conexion);
	prueba4.añadirServicio(b);
	*/
	/*
	ServiciosDelHotelDAO prueba5 = new ServiciosDelHotelDAO(conexion);
	for (ServiciosDelHotelBean elem: prueba5.darServiciosHotel()) {
		System.out.println(elem);
	}
	*/
	/*
	TareaDAO prueba6 = new TareaDAO(conexion);
	TareaBean c = new TareaBean(-1,1,1,"prueba","limpiar","cocina",false,null);
	prueba6.añadirTarea(c);
	*/
	}
}
