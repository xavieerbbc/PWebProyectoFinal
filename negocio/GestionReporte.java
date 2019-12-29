package negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.ReporteDAO;
import datos.UsuarioDAO;
import modelo.Reporte;
import modelo.Usuario;

@Stateless
public class GestionReporte {

	@Inject
	private ReporteDAO dao;
	
	public void guardar(Reporte reporte) {
		if(dao.read(reporte.getCodigo())==null)
			dao.insert(reporte);
		else
			dao.update(reporte);
		
		
	}
	
	public List<Reporte> getReportes(){
		return dao.getReportes();
	}
	
	
	public List<Reporte> getReportePorNombre(String filtro){
		
		return dao.getReporteXNombre(filtro);
	}
}
