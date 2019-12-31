package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Certificado {

	@Id
	@Column(name="cer_codigo")
	private int codigo;
	
	@Column(name="cer_medico")
	private Medico medico;
	
	
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
	@Override
	public String toString() {
		return "Certificado [codigo=" + codigo + ", medico=" + medico + "]";
	}
	
	
}
