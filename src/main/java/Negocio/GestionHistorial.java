package Negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import Datos.HistorialDAO;
import Modelo.Historial;
import Modelo.Medico;

@Stateless
public class GestionHistorial implements GestionHistorialLocal {
	
	@Inject
	private HistorialDAO hdao;

	@Override
	public void insertar(Historial historial) {
		// TODO Auto-generated method stub
		hdao.insertar(historial);
	}

	@Override
	public void actualizar(Historial historial) {
		// TODO Auto-generated method stub
		this.hdao.actualizar(historial);
	}

	@Override
	public void borrar(int codigo) {
		// TODO Auto-generated method stub
		hdao.borrar(codigo);
		
	}

	@Override
	public Historial leer(int codigo) {
		// TODO Auto-generated method stub
		return hdao.leer(codigo);
	}

	@Override
	public List<Historial> getHistoriales() {
		// TODO Auto-generated method stub
		return hdao.getHistoriales();
	}

	@Override
	public List<Historial> obteneHistorialesMedico(Medico medico) {
		// TODO Auto-generated method stub
		return this.hdao.obtenerHistorialesMedico(medico);
	}

}
