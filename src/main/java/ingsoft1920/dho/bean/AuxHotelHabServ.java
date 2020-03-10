package ingsoft1920.dho.bean;
import java.util.List;


//No es ninguna tabla de la base de datos

public class AuxHotelHabServ {
	private HotelBean hotel;
	private List<AuxHabitacion> listaHab;
	private List<ServiciosDelHotelBean> listaServ;
	public AuxHotelHabServ() {
		
	}
	public AuxHotelHabServ(HotelBean hotel, List<AuxHabitacion> listaHab, List<ServiciosDelHotelBean> listaServ) {
		super();
		this.hotel = hotel;
		this.listaHab = listaHab;
		this.listaServ = listaServ;
	}
	public HotelBean getHotel() {
		return hotel;
	}
	public void setHotel(HotelBean hotel) {
		this.hotel = hotel;
	}
	public List<AuxHabitacion> getListaHab() {
		return listaHab;
	}
	public void setListaHab(List<AuxHabitacion> listaHab) {
		this.listaHab = listaHab;
	}
	public List<ServiciosDelHotelBean> getListaServ() {
		return listaServ;
	}
	public void setListaServ(List<ServiciosDelHotelBean> listaServ) {
		this.listaServ = listaServ;
	}
	
	

}
