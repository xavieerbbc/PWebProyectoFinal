package Modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Receta {

	@Id
	private int codigo;
	@OneToOne
	private Medico medico;
	private String observaciones;
	private Date fechaEmision;
	
	@OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
	@JoinColumn(name = "detalle", referencedColumnName = "codigo")
	private List<Detalle> items;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public List<Detalle> getItems() {
		return items;
	}
	public void setItems(List<Detalle> items) {
		this.items = items;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	public Date getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	
	@Override
	public String toString() {
		return "Receta [codigo=" + codigo + ", medico=" + medico + ", items=" + items + ", observaciones="
				+ observaciones + ", fechaEmision=" + fechaEmision + "]";
	}
	
	
}
