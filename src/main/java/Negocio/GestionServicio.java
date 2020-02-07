package Negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import Datos.ServicioDAO;
import Modelo.Servicio;

@Stateless
public class GestionServicio implements GestionServicioLocal {

	@Inject
	private ServicioDAO dao;
	
	@Override
	public void insert(Servicio s) {
		dao.insert(s);
	}

	@Override
	public void update(Servicio s) {
		dao.update(s);
	}

	@Override
	public Servicio read(int codigo) {
		return dao.read(codigo);
	}

	@Override
	public void delete(int codigo) {
		dao.delete(codigo);
	}

	@Override
	public List<Servicio> getServicio() {
		return dao.getServicio();
	}

}
