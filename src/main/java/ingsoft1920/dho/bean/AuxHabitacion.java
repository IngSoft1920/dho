package ingsoft1920.dho.bean;


//No es ninguna tabla de la base de datos


public class AuxHabitacion {
	private int id_hotel;
	private int id_tipo;
	private String tipo_habitacion;
	private int num_Disponibles;
	public AuxHabitacion() {
		
	}
	public AuxHabitacion(int id_hotel, int id_tipo, String tipo_habitacion, int num_Disponibles) {
		super();
		this.id_hotel = id_hotel;
		this.id_tipo = id_tipo;
		this.tipo_habitacion = tipo_habitacion;
		this.num_Disponibles = num_Disponibles;
	}
	public int getId_hotel() {
		return id_hotel;
	}
	public void setId_hotel(int id_hotel) {
		this.id_hotel = id_hotel;
	}
	public int getId_tipo() {
		return id_tipo;
	}
	public void setId_tipo(int id_tipo) {
		this.id_tipo = id_tipo;
	}
	public String getTipo_habitacion() {
		return tipo_habitacion;
	}
	public void setTipo_habitacion(String tipo_habitacion) {
		this.tipo_habitacion = tipo_habitacion;
	}
	public int getNum_Disponibles() {
		return num_Disponibles;
	}
	public void setNum_Disponibles(int num_Disponibles) {
		this.num_Disponibles = num_Disponibles;
	}
	

}
