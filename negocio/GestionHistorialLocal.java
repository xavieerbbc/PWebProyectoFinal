package negocio;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;


import modelo.Historial;

@Local
public interface GestionHistorialLocal {
	
	public void guardarHistorial(int codigo,String observaciones);
	public List<Historial> getHistoriales();
	public List<Historial> getHistorialesPorNombre(String filtro);

}
