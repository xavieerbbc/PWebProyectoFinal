package Modelo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Historial {

	@Id
	private int codigo;
	
	@OneToOne
	private Paciente paciente;
	
	@OneToOne
	private Medico medico;
	
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	private String motivoConsulta;
	private String diagnostico;
	private String tratamiento;
	private String enfermedades;
	private String medicamentosActuales;
	private String antecedentesEnfermedades;
	private String alergias;
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
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getMotivoConsulta() {
		return motivoConsulta;
	}
	public void setMotivoConsulta(String motivoConsulta) {
		this.motivoConsulta = motivoConsulta;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	public String getTratamiento() {
		return tratamiento;
	}
	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}
	public String getEnfermedades() {
		return enfermedades;
	}
	public void setEnfermedades(String enfermedades) {
		this.enfermedades = enfermedades;
	}
	public String getMedicamentosActuales() {
		return medicamentosActuales;
	}
	public void setMedicamentosActuales(String medicamentosActuales) {
		this.medicamentosActuales = medicamentosActuales;
	}
	public String getAntecedentesEnfermedades() {
		return antecedentesEnfermedades;
	}
	public void setAntecedentesEnfermedades(String antecedentesEnfermedades) {
		this.antecedentesEnfermedades = antecedentesEnfermedades;
	}
	public String getAlergias() {
		return alergias;
	}
	public void setAlergias(String alergias) {
		this.alergias = alergias;
	}
	@Override
	public String toString() {
		return "Historial [codigo=" + codigo + ", paciente=" + paciente + ", medico=" + medico + ", fecha=" + fecha
				+ ", motivoConsulta=" + motivoConsulta + ", diagnostico=" + diagnostico + ", tratamiento=" + tratamiento
				+ ", enfermedades=" + enfermedades + ", medicamentosActuales=" + medicamentosActuales
				+ ", antecedentesEnfermedades=" + antecedentesEnfermedades + ", alergias=" + alergias + "]";
	}
	
	
	
	
}
