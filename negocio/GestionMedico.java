package negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.MedicoDAO;
import modelo.Medico;



@Stateless
public class GestionMedico {
	
	@Inject
	private MedicoDAO dao;
	
	public void guardar(Medico medico) {
		if(dao.read(medico.getCodigo())==null)
			dao.insert(medico);
		else
			dao.update(medico);	
		
	}
	
	public List<Medico> getMedicos(){
		return dao.getMedicos();
	}
	
	public List<Medico> getMedicoPorNombre(String filtro){
		
		return dao.getMedicoXNombre(filtro);
	}

}
