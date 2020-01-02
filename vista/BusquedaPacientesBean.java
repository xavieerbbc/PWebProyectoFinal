package vista;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import modelo.Paciente;
import negocio.GestionPacienteLocal;


@ManagedBean
public class BusquedaPacientesBean {
	
	@Inject
	private GestionPacienteLocal gl;
	
	/*Bean Properties*/
	private String filtro;
	
	private List<Paciente> pacientes;
	
	public String getFiltro() {
		return filtro;
	}


	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}


	public List<Paciente> getPacientes() {
		return pacientes;
	}


	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
	

	public String buscarPaciente() {
		
		pacientes = gl.getPacientesNombre(filtro);
		System.out.println("hola mundo");
		return filtro;
	}

	

}