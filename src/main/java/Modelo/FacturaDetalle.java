package Modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class FacturaDetalle {

	@Id
	@GeneratedValue
	private String numeroDetalle;
	private int cantidad;
	@OneToOne
	private Servicio servicio;
	private String estado;
	
	public String getNumeroDetalle() {
		return numeroDetalle;
	}
	public void setNumeroDetalle(String numeroDetalle) {
		this.numeroDetalle = numeroDetalle;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Servicio getServicio() {
		return servicio;
	}
	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "FacturaDetalle [numeroDetalle=" + numeroDetalle + ", cantidad=" + cantidad + ", servicio=" + servicio
				+ ", estado=" + estado + "]";
	}
	
	
	
}
