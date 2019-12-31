package modelo;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class CitaMedica {

	@Id
	@Column(name="ci_codigo")
	private int codigo;
	
	@Column(name="ci_paciente")//falta completar
	private List<Paciente> pacientes;
	
	@Column(name="ci_medico")
	private Medico medico;
	
	@Column(name="ci_turno")
	private String turno;
	
	
	@Column(name="ci_fecha")
	private Date fecha;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public String getTurno() {
		return turno;
	}
	public void setTurno(String turno) {
		this.turno = turno;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "CitaMedica [codigo=" + codigo + ", paciente=" + paciente + ", turno=" + turno + ", fecha=" + fecha
				+ "]";
	}
	
	
}
