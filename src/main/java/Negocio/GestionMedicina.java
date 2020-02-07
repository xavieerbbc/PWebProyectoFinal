package Negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import Datos.MedicinaDAO;
import Modelo.Medicina;

@Stateless
public class GestionMedicina implements GestionMedicinaLocal {

	@Inject
	private MedicinaDAO mdao;
	
	@Override
	public void insertar(Medicina medicina) {
		// TODO Auto-generated method stub
		mdao.insertar(medicina);
	}

	@Override
	public void actualizar(Medicina medicina) {
		// TODO Auto-generated method stub
		mdao.actualizar(medicina);
	}

	@Override
	public void borrar(int codigo) {
		// TODO Auto-generated method stub
		mdao.borrar(codigo);
	}

	@Override
	public Medicina leer(int codigo) {
		// TODO Auto-generated method stub
		return mdao.leer(codigo);
	}

	@Override
	public List<Medicina> getMedicinas() {
		// TODO Auto-generated method stub
		return mdao.getMedicinas();
	}

}
