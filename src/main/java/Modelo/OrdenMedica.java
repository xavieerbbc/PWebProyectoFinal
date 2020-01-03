package Modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class OrdenMedica {

	@Id
	private int codigo;
	@OneToOne
	private Medico medico;
	@OneToOne
	private TipoOrdenMedica tipo;
	private String descripcion;
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
	public TipoOrdenMedica getTipo() {
		return tipo;
	}
	public void setTipo(TipoOrdenMedica tipo) {
		this.tipo = tipo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		return "OrdenMedica [codigo=" + codigo + ", medico=" + medico + ", tipo=" + tipo + ", descripcion="
				+ descripcion + "]";
	}
	
	 
}
