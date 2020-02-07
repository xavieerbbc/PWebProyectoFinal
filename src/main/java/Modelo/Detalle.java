package Modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Detalle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;
	
	@OneToOne
	private Medicina medicina;
	
	private String dosis;

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

	public String getDosis() {
		return dosis;
	}

	public void setDosis(String dosis) {
		this.dosis = dosis;
	}

	@Override
	public String toString() {
		return "Detalle [codigo=" + codigo + ", medicina=" + medicina + ", dosis=" + dosis + "]";
	}
	
}
