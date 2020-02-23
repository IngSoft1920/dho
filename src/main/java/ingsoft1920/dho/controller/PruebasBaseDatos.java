package ingsoft1920.dho.controller;

import java.util.ArrayList;

import ingsoft1920.dho.DAO.EstanciaDAO;
import ingsoft1920.dho.DAO.FacturasDAO;
import ingsoft1920.dho.DAO.HabitacionDAO;
import ingsoft1920.dho.DAO.IncidenciaDAO;
import ingsoft1920.dho.DAO.ServicioDAO;
import ingsoft1920.dho.DAO.ServiciosDelHotelDAO;
import ingsoft1920.dho.DAO.TareaDAO;
import ingsoft1920.dho.bean.CobrosBean;
import ingsoft1920.dho.bean.EstanciaBean;
import ingsoft1920.dho.bean.HabitacionBean;
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
	 		diasReserva
	 		idUltimoServicio
	 		getHabitacion
	 		estaCobroPagado
	 		cobrosCLiente pero falta añadir la fecha
	 		generarFactura falta añadir la fecha
	 		getHabitacionByHotel
	 		asignarTarea
	 		enviarTareas
	 		facturaPagada
	 		estaFacturaPagada
	 		cobroPagado
	 		checkIn
	 		checkOut
	 		geEstanciaBeans
	 		getEstaciaId
	 		getServiciosReservados


	 	No Funcionan:
	 	
	 	Faltan por probar:
	 		recibirTarea
	 		asignacionHorarioServicios
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
/*
	 HabitacionDAO prueba7 = new HabitacionDAO(conexion);
	 System.out.println(prueba7.diasReserva(2));
	 
	 ServicioDAO prueba8= new ServicioDAO(conexion); 
	 System.out.println(prueba8.idUltimoServicio());		 
			 
	 HabitacionDAO prueba9=new HabitacionDAO(conexion);
	 System.out.println(prueba9.getHabitacion(16).toString());
	 
	 FacturasDAO prueba10=new FacturasDAO(conexion);
	 System.out.println(prueba10.estaCobroPagado(5));
	 
	 FacturasDAO prueba11= new FacturasDAO(conexion);
	 	 ArrayList<CobrosBean> res=	 prueba11.cobrosCliente(9);
	 	 System.out.println(res.size());
	 for(int i=0; i<res.size();i++) {
		 
		 System.out.println(res.get(i).toString());
	 }
	 
	 FacturasDAO prueba12= new FacturasDAO(conexion);
	 //System.out.println(prueba12.generarFactura(9, 10));
	 
	 FacturasDAO prueba13 = new FacturasDAO(conexion);
	 //System.out.println(prueba13.generarFactura(1, 10));
	  

	  */
	/*

	HabitacionDAO prueba14=new HabitacionDAO(conexion);
	for (HabitacionBean elem: prueba14.getHabitacionByHotel(1)) {
		System.out.println(elem);
	}
	
	TareaDAO prueba15 = new TareaDAO(conexion);
	prueba15.asignarTarea(1);

	 
	
	FacturasDAO prueba18= new FacturasDAO(conexion);
	prueba18.facturaPagada(0);
	
	
	FacturasDAO prueba19=new FacturasDAO(conexion);
	System.out.println(prueba19.estaFacturaPagada(1));
	
	FacturasDAO prueba17= new FacturasDAO(conexion);
	prueba17.cobroPagado(1);
	
	
		}

	
	TareaDAO prueba16 = new TareaDAO(conexion);
	for (TareaBean elem: prueba16.enviarTareas()) {
		System.out.println(elem);
	}
	*/
	/*
	EstanciaDAO prueba17 = new EstanciaDAO(conexion);
	prueba17.checkIn(2);
	*/
	/*
	EstanciaDAO prueba18 = new EstanciaDAO(conexion);
	prueba18.checkOut(2);
	*/
	/*
	EstanciaDAO prueba19 = new EstanciaDAO(conexion);
	for (EstanciaBean elem: prueba19.geEstanciaBeans()) {
		System.out.println(elem);
	}
	*/
	/*
	EstanciaDAO prueba20= new EstanciaDAO(conexion);
	System.out.println(prueba20.getEstaciaId(1));
	*/
	ServicioDAO prueba21 = new ServicioDAO(conexion);
	for (ServicioBean elem: prueba21.getServiciosReservados()) {
		System.out.println(elem);
	}
	}
}

