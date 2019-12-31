package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Historial {
	
	@Id
	@Column(name="hi_codigo")
	private int codigo;
	
	@Column(name="hi_observaciones")
	private String observaciones;
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getObservaciones() {
		return observaciones;
	}
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	@Override
	public String toString() {
		return "Historial_Clinica [codigo=" + codigo + ", observaciones=" + observaciones + "]";
	}
	
	

}
