package ingsoft1920.dho.fna;

import java.sql.Date;

public class EstanciaBean {

	private Date fechaInicio;
	private Date fechaFin;
	private double importe;

	public EstanciaBean(Date fechaInicio, Date fechaFin, double importe) {
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.importe = importe;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public double getImporte() {
		return importe;
	}

	public void setImporte(double importe) {
		this.importe = importe;
	}

	@Override
	public String toString() {
		return "EstanciaBean [fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", importe=" + importe + "]";
	}
}
