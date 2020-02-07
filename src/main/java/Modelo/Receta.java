package Modelo;

import java.util.ArrayList;
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
	private Paciente paciente;
	
	@OneToOne
	private Medico medico;
	
	private Date fechaEmision;
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
	@JoinColumn(name = "receta_id", referencedColumnName = "codigo")
	private List<Detalle> detalle;

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

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public List<Detalle> getDetalle() {
		return detalle;
	}

	public void setDetalle(List<Detalle> detalle) {
		this.detalle = detalle;
	}
	
	public void addDetalle(Detalle detalle) {
		if(this.detalle==null)
			this.detalle = new ArrayList<>();
		this.detalle.add(detalle);
	}
	

	@Override
	public String toString() {
		return "Receta [codigo=" + codigo + ", paciente=" + paciente + ", medico=" + medico + ", fechaEmision="
				+ fechaEmision + ", detalle=" + detalle + "]";
	}	
	
}
