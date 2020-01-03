package Modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Detalle {

	@Id
	private int codigo;
	@OneToOne
	private Medicina medicina;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Medicina getMedicina() {
		return medicina;
	}
	public void setMedicina(Medicina medicina) {
		this.medicina = medicina;
	}
	
	@Override
	public String toString() {
		return "Detalle [codigo=" + codigo + ", medicina=" + medicina + "]";
	}
	
	
}
