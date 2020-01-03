package Negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import Datos.RolDAO;
import Modelo.Rol;

@Stateless
public class GestionRol implements GestionRolLocal {
	
	@Inject
	private RolDAO rdao;

	@Override
	public void insertar(Rol rol) {
		// TODO Auto-generated method stub
		System.out.println(rol.toString());
		rdao.insertar(rol);
	}

	@Override
	public void actualizar(Rol rol) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrar(int codigo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rol leer(int codigo) {
		// TODO Auto-generated method stub
		return rdao.leer(codigo);
	}

	@Override
	public List<Rol> getRoles() {
		// TODO Auto-generated method stub
		return null;
	}


}
