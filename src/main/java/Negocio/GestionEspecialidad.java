package Negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import Datos.EspecialidadDAO;
import Modelo.Especialidad;

@Stateless
public class GestionEspecialidad implements GestionEspecialidadLocal {

	@Inject
	private EspecialidadDAO edao;
	
	@Override
	public void insertar(Especialidad especialidad) {
		// TODO Auto-generated method stub
		edao.insertar(especialidad);
	}

	@Override
	public void actualizar(Especialidad especialidad) {
		// TODO Auto-generated method stub
		edao.actualizar(especialidad);
	}

	@Override
	public void borrar(int codigo) {
		// TODO Auto-generated method stub
		edao.borrar(codigo);
	}

	@Override
	public Especialidad leer(int codigo) {
		// TODO Auto-generated method stub
		return edao.leer(codigo);
	}

	@Override
	public List<Especialidad> getEspecialidades() {
		// TODO Auto-generated method stub
		return edao.getEspecialidades();
	}

}
