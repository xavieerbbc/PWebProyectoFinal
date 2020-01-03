package Negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import Datos.MedicoDAO;
import Modelo.Medico;

@Stateless
public class GestionMedico implements GestionMedicoLocal {

	@Inject
	private MedicoDAO dao;
	
	@Override
	public void insertar(Medico medico) {
		// TODO Auto-generated method stub
		dao.insertar(medico);
	}

	@Override
	public void actualizar(Medico medico) {
		// TODO Auto-generated method stub
		dao.actualizar(medico);
	}

	@Override
	public void borrar(int codigo) {
		// TODO Auto-generated method stub
		dao.borrar(codigo);
	}

	@Override
	public Medico leer(int codigo) {
		// TODO Auto-generated method stub
		return dao.leer(codigo);
	}

	@Override
	public List<Medico> getMedicos() {
		// TODO Auto-generated method stub
		return dao.getMedicos();
	}

}
