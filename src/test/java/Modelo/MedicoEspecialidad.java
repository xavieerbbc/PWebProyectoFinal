package Modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class MedicoEspecialidad {

	@Id
	private int codigo;
	@OneToOne
	private Medico medico;
	@OneToOne
	private Especialidad especialidad;
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
	public Especialidad getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}
	
	@Override
	public String toString() {
		return "MedicoEspecialidad [codigo=" + codigo + ", medico=" + medico + ", especialidad=" + especialidad + "]";
	}
	
	
	
}
