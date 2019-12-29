package negocio;

import java.util.List;

import javax.ejb.Remote;

import modelo.Historial;

@Remote
public interface GestionHistorialRemote {
	
	public void guardarHistorial(int codigo,String observaciones);
	public List<Historial> getHistoriales();
	public List<Historial> getHistorialesPorNombre(String filtro);


}
