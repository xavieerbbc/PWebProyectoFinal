package negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.CitaMedicaDAO;
import modelo.CitaMedica;



@Stateless
public class GestionCitaMedica {
	
	@Inject
	private CitaMedicaDAO dao;
	
	public void guardar(CitaMedica citaMedica) {
		if(dao.read(citaMedica.getCodigo())==null)
			dao.insert(citaMedica);
		else
			dao.update(citaMedica);	
		
	}
	
	public List<CitaMedica> getCitasMedicas(){
		return dao.getCitaMedicas();
	}
	
	public List<CitaMedica> getCitaMedicaPorNombre(String filtro){
		
		return dao.getCitaMedicaXNombre(filtro);
	}


}
