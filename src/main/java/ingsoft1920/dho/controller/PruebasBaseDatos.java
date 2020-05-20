package ingsoft1920.dho.controller;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import com.google.gson.JsonObject;

import ingsoft1920.dho.DAO.ClienteDAO;
import ingsoft1920.dho.DAO.EstanciaDAO;
import ingsoft1920.dho.DAO.FacturasDAO;
import ingsoft1920.dho.DAO.GruposDAO;
import ingsoft1920.dho.DAO.HabitacionDAO;
import ingsoft1920.dho.DAO.HotelDAO;
import ingsoft1920.dho.DAO.IncidenciaDAO;
import ingsoft1920.dho.DAO.ServicioDAO;
import ingsoft1920.dho.DAO.ServiciosDelHotelDAO;
import ingsoft1920.dho.DAO.TareaDAO;
import ingsoft1920.dho.bean.ClienteBean;
import ingsoft1920.dho.bean.CobrosBean;
import ingsoft1920.dho.bean.EstanciaBean;
import ingsoft1920.dho.bean.GruposBean;
import ingsoft1920.dho.bean.HabitacionBean;
import ingsoft1920.dho.bean.IncidenciaBean;
import ingsoft1920.dho.bean.ServicioBean;
import ingsoft1920.dho.bean.ServiciosDelHotelBean;
import ingsoft1920.dho.bean.TareaBean;

/*
 * Aqui vamos haciendo todas las pruebas relacionadas con la base de datos para ver que funciona correctamente
 */
public class PruebasBaseDatos {
	public static void main(String[] args) {
		String servidor, puerto, usuario, contraseña, baseDeDatos;
		servidor = "piedrafita.ls.fi.upm.es";
		puerto = "8000";
		usuario = "dho2";
		contraseña = "ingSoft20dho2.336";
		baseDeDatos = "dho";
		Conexion conexion = new Conexion();
		Conexion.init(servidor, puerto, usuario, contraseña, baseDeDatos);
		Conexion.conectar();
		/*
		 * Comienzo aqui a probar las consultas(Ire comentando las que funcionan)
		 * Funcionan: getHabitacionPorId BuscarIncidenciaPor añadirIncidencia
		 * añadirServicio darServiciosHotel añadirTarea diasReserva idUltimoServicio
		 * getHabitacion estaCobroPagado cobrosCLiente pero falta añadir la fecha
		 * generarFactura falta añadir la fecha getHabitacionByHotel asignarTarea
		 * enviarTareas facturaPagada estaFacturaPagada cobroPagado checkIn checkOut
		 * geEstanciaBeans getEstaciaId getServiciosReservados getIncidenciasSinAsignar
		 * getIncidenciasAsignadas getReservas getCheckIn getCheckOut
		 * 
		 * 
		 * No Funcionan:
		 * 
		 * Faltan por probar: recibirTarea asignacionHorarioServicios
		 *
		 *
		 * 
		 * HabitacionDAO prueba1= new HabitacionDAO(conexion);
		 * System.out.println(prueba1.getHabitacionPorId(1));
		 *
		 *
		 * IncidenciaDAO prueba2=new IncidenciaDAO(conexion);
		 * System.out.println(prueba2.BuscarIncidenciaPor("habitacion 2"));
		 *
		 *
		 * //Le he puesto id -1 porque el constructor te pide un id, pero este en verdad
		 * se genera al momento de meterlo en la base de datos IncidenciaBean a = new
		 * IncidenciaBean(-1,"limpiar","esto es una prueba","cocina",null);
		 * IncidenciaDAO prueba3=new IncidenciaDAO(conexion);
		 * prueba3.añadirIncidencia(a);
		 *
		 *
		 * ServicioBean b = new
		 * ServicioBean(-1,1,1,1,"cocina",null,null,"hacer una prueba"); ServicioDAO
		 * prueba4=new ServicioDAO(conexion); prueba4.añadirServicio(b);
		 *
		 *
		 * ServiciosDelHotelDAO prueba5 = new ServiciosDelHotelDAO(conexion); for
		 * (ServiciosDelHotelBean elem: prueba5.darServiciosHotel()) {
		 * System.out.println(elem); }
		 *
		 *
		 * TareaDAO prueba6 = new TareaDAO(conexion); TareaBean c = new
		 * TareaBean(-1,1,1,"prueba","limpiar","cocina",false,null);
		 * prueba6.añadirTarea(c);
		 * 
		 *
		 *
		 * HabitacionDAO prueba7 = new HabitacionDAO(conexion);
		 * System.out.println(prueba7.diasReserva(2));
		 * 
		 * ServicioDAO prueba8= new ServicioDAO(conexion);
		 * System.out.println(prueba8.idUltimoServicio());
		 * 
		 * HabitacionDAO prueba9=new HabitacionDAO(conexion);
		 * System.out.println(prueba9.getHabitacion(16).toString());
		 * 
		 * FacturasDAO prueba10=new FacturasDAO(conexion);
		 * System.out.println(prueba10.estaCobroPagado(5));
		 * 
		 * FacturasDAO prueba11= new FacturasDAO(conexion); ArrayList<CobrosBean> res=
		 * prueba11.cobrosCliente(9); System.out.println(res.size()); for(int i=0;
		 * i<res.size();i++) {
		 * 
		 * System.out.println(res.get(i).toString()); }
		 * 
		 * FacturasDAO prueba12= new FacturasDAO(conexion);
		 * System.out.println(prueba12.generarFactura(9, 10));
		 * 
		 * FacturasDAO prueba13 = new FacturasDAO(conexion);
		 * System.out.println(prueba13.generarFactura(1, 10));
		 * 
		 * 
		 *
		 *
		 * 
		 * HabitacionDAO prueba14=new HabitacionDAO(conexion); for (HabitacionBean elem:
		 * prueba14.getHabitacionByHotel(1)) { System.out.println(elem); }
		 * 
		 * TareaDAO prueba15 = new TareaDAO(conexion); prueba15.asignarTarea(1);
		 * 
		 * 
		 * 
		 * FacturasDAO prueba18= new FacturasDAO(conexion); prueba18.facturaPagada(0);
		 * 
		 * 
		 * FacturasDAO prueba19=new FacturasDAO(conexion);
		 * System.out.println(prueba19.estaFacturaPagada(1));
		 * 
		 * FacturasDAO prueba17= new FacturasDAO(conexion); prueba17.cobroPagado(1);
		 * 
		 * 
		 * }
		 * 
		 * 
		 * TareaDAO prueba16 = new TareaDAO(conexion); for (TareaBean elem:
		 * prueba16.enviarTareas()) { System.out.println(elem); }
		 *
		 *
		 * EstanciaDAO prueba17 = new EstanciaDAO(conexion); prueba17.checkIn(2);
		 *
		 *
		 * EstanciaDAO prueba18 = new EstanciaDAO(conexion); prueba18.checkOut(2);
		 *
		 *
		 * EstanciaDAO prueba19 = new EstanciaDAO(conexion); for (EstanciaBean elem:
		 * prueba19.geEstanciaBeans()) { System.out.println(elem); }
		 *
		 *
		 * EstanciaDAO prueba20= new EstanciaDAO(conexion);
		 * System.out.println(prueba20.getEstaciaId(1));
		 * 
		 * ServicioDAO prueba21 = new ServicioDAO(conexion); for (ServicioBean elem:
		 * prueba21.getServiciosReservados()) { System.out.println(elem); }
		 * 
		 * FacturasDAO prueba22= new FacturasDAO(conexion); Date fecha=new
		 * Date(20,02,2020); for(int i=0; i<prueba22.getCobrosFecha(fecha).size(); i++)
		 * { System.out.println(prueba22.getCobrosFecha(fecha).get(i).toString()); }
		 * 
		 * 
		 * FacturasDAO prueba24=new FacturasDAO(conexion);
		 * 
		 * FacturasDAO prueba23=new FacturasDAO(conexion);
		 * System.out.println(prueba23.genFacturaCobros(prueba24.cobrosCliente(1),
		 * 1).toString());
		 * 
		 *
		 *
		 * IncidenciaDAO prueba24 = new IncidenciaDAO(conexion); for (IncidenciaBean
		 * elem: IncidenciaDAO.getIncidenciasSinAsignar()) { System.out.println(elem); }
		 *
		 *
		 * IncidenciaDAO prueba25 = new IncidenciaDAO(conexion); for (IncidenciaBean
		 * elem: prueba25.getIncidenciasAsignadas()) { System.out.println(elem); }
		 *
		 *
		 * IncidenciaDAO prueba26 = new IncidenciaDAO(conexion);
		 * System.out.println(prueba26.getIncidenciaDadoId(1)); }
		 *
		 *
		 * EstanciaDAO prueba27 = new EstanciaDAO(conexion); for (EstanciaBean elem:
		 * prueba27.getReservas()) { System.out.println(elem); }
		 *
		 *
		 * EstanciaDAO prueba28 = new EstanciaDAO(conexion); for (EstanciaBean elem:
		 * prueba28.getCheckIn()) { System.out.println(elem); }
		 * 
		 * EstanciaDAO prueba29 = new EstanciaDAO(conexion); for (EstanciaBean elem:
		 * prueba29.getCheckOut()) { System.out.println(elem); }
		 * 
		 * 
		 * 
		 * int hora= 9;
		 * 
		 * ServiciosDelHotelDAO prueba30= new ServiciosDelHotelDAO(conexion);
		 * System.out.println(prueba30.plazasLibresServicioHotel(1, "06","03","2020",
		 * hora));
		 * 
		 * ServicioDAO prueba31 = new ServicioDAO(conexion);
		 * System.out.println(prueba31.getServiciosPorFecha("06","03","2020",
		 * hora).toString());
		 * 
		 * 
		 * ServicioDAO prueba32 = new ServicioDAO(conexion);
		 * System.out.println(prueba32.getServiciosRestaurante().toString()+"\n "
		 * +prueba32.getServiciosRestaurante().size());
		 * 
		 * 
		 * ServiciosDelHotelDAO prueba33= new ServiciosDelHotelDAO(conexion);
		 * System.out.println(prueba33.serviciosHotelPorNombre("hotel_prueba"));
		 * 
		 * 
		 * HotelDAO prueba34 = new HotelDAO(conexion);
		 * System.out.println(prueba34.devolverElNumeroDeHoteles());
		 * 
		 * 
		 * AuxHabitacion h1= new AuxHabitacion(3,1,"individual", 4); HabitacionDAO
		 * prueba35= new HabitacionDAO(conexion); prueba35.anadirHabitaciones(h1);
		 * //System.out.println(h1.getNum_Disponibles());
		 * 
		 * 
		 * Date fecha= new Date(0); fecha.setYear(125); fecha.setMonth(2);
		 * fecha.setDate(6);
		 * 
		 * Time hora= new Time(0); hora.setHours(9); System.out.println(fecha.toString()
		 * +" " +hora.toString());
		 * 
		 * 
		 * HotelDAO prueba36= new HotelDAO(conexion);
		 * System.out.println(prueba36.ConseguirNombreHotelDadoID(3));
		 * 
		 * 
		 * ServiciosDelHotelDAO prueba37 = new ServiciosDelHotelDAO(conexion);
		 * System.out.println(prueba37.conseguirNombreServicioHotel(4));
		 * 
		 * 
		 * TareaDAO prueba38 = new TareaDAO(conexion) ;
		 * System.out.println(prueba38.getTareaPorIdEmpleado(1) );
		 * 
		 * ServicioDAO prueba39= new ServicioDAO(conexion);
		 * System.out.println(prueba39.devuelevServiciosreservadosPorunaEstancia(1).
		 * toString());
		 * 
		 * 
		 * EstanciaDAO prueba40 = new EstanciaDAO(conexion);
		 * prueba40.anadirEstancia(11,12,1,"2020-03-10", "2020-03-15", 1,0);
		 * 
		 * EstanciaDAO prueba41= new EstanciaDAO(conexion);
		 * prueba41.anadirEstancia(17,12,1,"2020-03-10", "2020-03-15", 1,0);
		 * 
		 * ClienteDAO prueba42= new ClienteDAO(conexion);
		 * System.out.println(prueba42.datosCliente(1).toString());
		 * 
		 * 
		 * ClienteDAO prueba43 = new ClienteDAO(conexion);
		 * //prueba43.modificarDatosCliente(1, "telefono", "777666555");
		 * //System.out.println(prueba43.getCliente(1).toString());
		 * 
		 * ClienteBean c1 = new ClienteBean(4,"Miguel","Perez", "12365487Z",
		 * "mp@gmail.com", "Español", "0000", 654654654); ClienteDAO prueba44 = new
		 * ClienteDAO(conexion); prueba44.anadirCliente(c1);
		 * 
		 * 
		 * 
		 * Date fecha = new Date(120,03,06);
		 * 
		 * Time hora = new Time(21,00,00); Time hora2 = new Time(22,30,00);
		 * //System.out.println(fecha +" "+hora); ServicioDAO prueba45= new
		 * ServicioDAO(conexion); prueba45.añadirServicio(new ServicioBean(0,5,9,4,
		 * "restaurante", fecha, hora, " ", " ", " ", hora2, 100));
		 * 
		 * 
		 * EstanciaDAO prueba46= new EstanciaDAO(conexion); ArrayList<EstanciaBean> est=
		 * new ArrayList<EstanciaBean>(); est=prueba46.getReservas(); for(int i=0;
		 * i<est.size(); i++) { System.out.println(est.get(i).toString()); }
		 * 
		 * 
		 * EstanciaDAO prueba47 = new EstanciaDAO(conexion);
		 * 
		 * System.out.println(prueba47.getEstadoHabitaciones("2020-03-26").toString());
		 * 
		 * 
		 * 
		 * 
		 * EstanciaDAO prueba48 = new EstanciaDAO(conexion);
		 * System.out.println(prueba48.getEstanciaByHabitacionID(103).toString());
		 * 
		 * EstanciaDAO prueba49 = new EstanciaDAO(conexion); prueba49.checkIn(103);
		 * System.out.println(prueba48.getEstanciaByHabitacionID(103));
		 * 
		 * 
		 * 
		 * ClienteDAO prueba50= new ClienteDAO(conexion);
		 * System.out.println(prueba50.clientePorHabitacionID(103).toString());
		 * 
		 * //estancia_id, habitacion_id, hotel_id, fecha_inicio, fecha_fin, estado
		 * importe cliente_id // estancia, hab, cli hotel fehca fehca estado importe
		 * tipo_hab_id EstanciaDAO prueba51 = new EstanciaDAO(conexion);
		 * prueba51.anadirEstanciaBean(new EstanciaBean(35,404, 4, -1, new
		 * Date(120,03,05), new Date(120,03,10), "reserva", 100, 1));
		 * 
		 * ClienteBean c1 = new ClienteBean(4,"esto","es", "una", "prueba", "nada",
		 * "mas", 000000000); ClienteDAO prueba51 = new ClienteDAO(conexion);
		 * prueba51.anadirClienteSinID(c1); Date fecha= new Date(0); Time hora = new
		 * Time(0); TareaDAO prueba52 = new TareaDAO(conexion); prueba52.añadirTarea(new
		 * TareaBean(100,1,1,"","","",true,fecha,hora,0,hora));
		 *
		 * 
		 * System.out.println(prueba45.idUltimoServicio());
		 *
		 * 
		 * DhoAPI prueba55 = new DhoAPI(); prueba55.
		 * recibirReserva(" { \"reserva_id\" : 34, \"fecha_entrada\" : \"2020-03-10\", \"fecha_salida\" :\"2020-03-15\", \"importe\" : 4, \"cliente_id\" : 2, \"numero_acompanantes\" : 0, \"hotel_id\" : 32, \"tipo_hab_id\" : 1}"
		 * );
		 * 
		 * DhoAPI prueba55 = new DhoAPI(); prueba55.eliminarHotel(6);
		 *
		 *
		 * JsonObject json = new JsonObject(); json.addProperty("habitacion",101 );
		 * json.addProperty("Hotel", "Prueba"); json.addProperty("Factura", 15.8);
		 * prueba55.recibirMesa(json.toString());
		 *
		 * EstanciaDAO prueba56 = new EstanciaDAO(conexion);
		 * System.out.println(prueba56.getEstanciaFecha(107, "2020-04-27").toString());
		 * 
		 * ClienteDAO prueba60= new ClienteDAO(conexion);
		 * System.out.println(prueba60.getClienteHabitacionFecha(101,
		 * "2020-04-26").toString());
		 * 
		 * ServicioDAO prueba61 = new ServicioDAO(conexion);
		 * System.out.println(prueba61.getClienteHabitacionFecha(101,
		 * "2020-04-26").toString());
		 * 
		 * HotelDAO prueba62 = new HotelDAO(conexion);
		 *
		 * System.out.println(prueba62.porcentajeOcupacion("2020-04-01"));
		 * System.out.println(prueba62.porcentajeOcupacion("2020-04-02"));
		 * System.out.println(prueba62.porcentajeOcupacion("2020-04-03"));
		 *
		 * System.out.println(prueba62.porcentajeOcupacionMes(4, 2020).toString());
		 *
		 * 
		 * HotelDAO prueba57 = new HotelDAO(conexion);
		 * System.out.println(prueba57.porcentajeReservas("2020-04-01"));
		 * 
		 * 
		 * 
		 * HotelDAO prueba59= new HotelDAO(conexion);
		 * System.out.println(prueba59.getHotelId("Prueba"));
		 * 
		 * EstanciaDAO prueba58 = new EstanciaDAO(conexion);
		 * System.out.println(prueba58.getEstadoHabitaciones("2020-04-01").toString()) ;
		 * 
		 * System.out.println(new Date(120,03,28));
		 * 
		 * ServicioDAO prueba59= new ServicioDAO(conexion); prueba59.recibirMesa(205,
		 * "Prueba", 50, new Date(120,03,28), new Time(14,00,00));
		 * 
		 * ServiciosDelHotelDAO prueba60 = new ServiciosDelHotelDAO(conexion);
		 *
		 * System.out.println(prueba60.getRestauranteId("Prueba")); DhoAPI prueba55 =
		 * new DhoAPI(); System.out.println(prueba55.recibirReserva(" { \"reserva_id\" :
		 * 19, \"fecha_entrada\" : \"2020-04-03\", \"fecha_salida\" :\"2020-04-16\",
		 * \"importe\" : 4, \"cliente_id\" : 10, \"numero_acompanantes\" : 0,
		 * \"hotel_id\" : 5, \"tipo_hab_id\" : 1}")); PedirClientes a=new
		 * PedirClientes(); System.out.println("BBBBBBBBBB"+a.peticionPedirCliente(19));
		
		DhoAPI prueba55 = new DhoAPI();
		prueba55.cancelarReserva(106); 
		
		
		PasarPedidos prueba=new PasarPedidos();
		String [] pr= {"agua","botella","cerveza"};
		int[] c= {4,5,6};
		String [] e= {"a","b","c"};
		PasarPedidos.pasarPedidosaFnb(1, LocalDate.parse("2020-10-10"), pr, c, e);
		*/
		GruposDAO prueba71 = new GruposDAO(conexion);
		System.out.println(prueba71.getReservasGrupo().toString());
		
		//EstanciaDAO prueba64= new EstanciaDAO(conexion);
		//System.out.println(prueba64.idUltimaEstancia() +1);
		
		/*GruposBean a=new GruposBean();
		a.setEmail("Aaa");
		a.setHotel_id(5);
		GruposDAO prueba65= new GruposDAO(conexion);
		GruposDAO.añadirReservaGrupos(a);*/
		
		/*DhoAPI prueba55 = new DhoAPI();
		prueba55.reservaGrupo("{\"nombre\" : \"hola\",\"tipo\" :\"hola\", \"email\" :\"hola\","
				+ "\"hotel_id\" : 3 , \"numero_habitaciones\" : 5, \"numero_personas\" : 56, "
				+ "\"fecha_entrada\" :\"2020-05-05\", \"fecha_salida\" :\"2020-05-05\" }");
		*/
		//System.out.print(HabitacionDAO.getHabitacionPorIdEstancia(103));
		
		//enviarReservasFnb p=new enviarReservasFnb();
		//p.enviarReservas(1,2,3,LocalDate.parse("2020-10-10"),LocalTime.parse("20:00:00"),3);
		// prueba55.recibirHotel(
		// " { \"id\" : 32, \"nombre\" : \"El resplandor\", \"descripcion\" :\"Una
		// experiencia cálida\", \"estrellas\" : 4, \"continente\" : \"Europa\",
		// \"pais\" :\"España\", \"ciudad\" : \"Madrid\", \"habitaciones\" : [ { \"id\":
		// 1 , \"nombre_tipo\": \"normal\" , \"num_disponibles\":50
		// },{\"id\":2,\"nombre_tipo\":\"premium\",\"num_disponibles\":10}],\"categorias\":[{\"id\":11,\"nombre\":\"adult-only\"},{\"id\":75,\"nombre\":\"pet-friendly\"}],\"servicios\":[{\"id\":1,\"nombre\":\"piscina\",\"precio\":10,\"unidad\":\"por_dia\"},{\"id\":3,\"nombre\":\"restaurante\",\"precio\":null,\"unidad\":null}]}");
	}
}
