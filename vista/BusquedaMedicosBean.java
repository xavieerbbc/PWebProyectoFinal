package vista;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import modelo.Medico;
import modelo.Paciente;
import negocio.GestionMedicoLocal;
import negocio.GestionPacienteLocal;


@ManagedBean
public class BusquedaMedicosBean {
	
	@Inject
	private GestionMedicoLocal gl;
	
	/*Bean Properties*/
	private String filtro;
	
	private List<Medico> medicos;
	
	
	public String BuscarMedico()
	{
		medicos = gl.getMedicosNombre(filtro);
		return filtro;
	}



	public GestionMedicoLocal getGl() {
		return gl;
	}



	public void setGl(GestionMedicoLocal gl) {
		this.gl = gl;
	}



	public List<Medico> getMedicos() {
		return medicos;
	}



	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}



	public String getFiltro() {
		return filtro;
	}


	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	

}