package negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.PacienteDAO;
import modelo.Paciente;


@Stateless
public class GestionPaciente {
	
	@Inject
	private PacienteDAO dao;
	
	public void guardar(Paciente paciente) {
		if(dao.read(paciente.getCodigo())==null)
			dao.insert(paciente);
		else
			dao.update(paciente);
		
		
	}
	
	public List<Paciente> getPacientes(){
		return dao.getPacientes();
	}
	
	
	public List<Paciente> getPacientePorNombre(String filtro){
		
		return dao.getPacienteXNombre(filtro);
	}

}
