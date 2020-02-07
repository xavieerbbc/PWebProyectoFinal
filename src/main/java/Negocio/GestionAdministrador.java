package Negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import Datos.AdministradorDAO;
import Modelo.Administrador;

@Stateless
public class GestionAdministrador implements GestionAdministradorLocal {

	@Inject
	private AdministradorDAO dao;
	
	@Override
	public void insertar(Administrador administrador) {
		dao.insertar(administrador);
		System.out.println(administrador.toString());

	}

	@Override
	public List<Administrador> getAdministradores() {
		return dao.getAdministradores();
	}

	@Override
	public Administrador leer(String cedula) {
		return null;
	}

	@Override
	public void borrar(int codigo) {
		dao.borrar(codigo);
	}

	@Override
	public void actualizar(Administrador administrador) {
		dao.actualizar(administrador);
	}

}
