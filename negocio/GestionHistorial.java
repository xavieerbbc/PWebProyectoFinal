package negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.HistorialDAO;
import datos.UsuarioDAO;
import modelo.Historial;
import modelo.Usuario;

@Stateless
public class GestionHistorial implements GestionHistorialLocal, GestionHistorialRemote {

	@Inject
	private HistorialDAO dao;
	
	
	public void guardarHistorial(int codigo, String observaciones){
		Historial h = new Historial();  
		h.setCodigo(codigo);
		h.setObservaciones(observaciones);
		System.out.println(h);
		dao.insert(h);
	}
	
	public List<Historial> getHistoriales(){
		
		return dao.getHistorial_Clinicas();
	}
	
	public List<Historial> getHistorialesPorNombre(String filtro){
		
		return dao.getHistorial_ClinicaXNombre(filtro);
	}
}
