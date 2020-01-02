package vista;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import modelo.Caja;
import modelo.Historial;
import modelo.Paciente;
import modelo.Reporte;
import negocio.GestionPaciente;
import negocio.GestionReporte;

@ManagedBean
@SessionScoped
public class GestionPacienteBean {
	
	private Paciente paciente = new Paciente();
	private Reporte reporte = new Reporte();
	
	@Inject
	private GestionPaciente gp;
	
	private List<Paciente> pacientes;
	private List<Reporte> reportes;
	
	@PostConstruct
	public void init() {
		paciente = new Paciente();
		paciente.addHistorial(new Historial());
		
		pacientes = gp.getPacientes();
	}
	
	@PostConstruct
	public void init2() {
		paciente = new Paciente();
		paciente.addReporte(new Reporte());
		
		pacientes = gp.getPacientes();
	}

	
	public Reporte getReporte() {
		return reporte;
	}

	public void setReporte(Reporte reporte) {
		this.reporte = reporte;
	}

	public List<Reporte> getReportes() {
		return reportes;
	}

	public void setReportes(List<Reporte> reportes) {
		this.reportes = reportes;
	}

	public Paciente getPaciente() {
		return paciente;
	}


	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}


	public List<Paciente> getPacientes() {
		return pacientes;
	}


	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}


	public String guardar() {
		System.out.println(paciente);
		gp.guardar(paciente);
		init();
		init2();
		return null;
	}
	
	public String addHistorial() {
		paciente.addHistorial(new Historial());
		return null;
	}
	
	public String addReporte() {
		paciente.addReporte(new Reporte());
		return null;
	}

}
