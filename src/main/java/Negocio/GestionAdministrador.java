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
		// TODO Auto-generated method stub
		dao.insertar(administrador);
		System.out.println(administrador.toString());

	}

	@Override
	public List<Administrador> getAdministradores() {
		// TODO Auto-generated method stub
		return dao.getAdministradores();
	}

	@Override
	public Administrador leer(String cedula) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void borrar(String cedula) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(Administrador administrador) {
		// TODO Auto-generated method stub
		
	}

}
