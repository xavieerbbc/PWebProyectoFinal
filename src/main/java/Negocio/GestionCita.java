package Negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import Datos.CitaDAO;
import Modelo.Cita;
import Modelo.Medico;

@Stateless
public class GestionCita implements GestionCitaLocal {
	
	@Inject
	private CitaDAO cdao;

	@Override
	public void insertar(Cita cita) {
		// TODO Auto-generated method stub
		this.cdao.insertar(cita);
	}

	@Override
	public void actualizar(Cita cita) {
		// TODO Auto-generated method stub
		this.cdao.actualizar(cita);
		
	}

	@Override
	public void borrar(int codigo) {
		// TODO Auto-generated method stub
		this.cdao.borrar(codigo);
		
	}

	@Override
	public Cita leer(int codigo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cita> getCitas() {
		// TODO Auto-generated method stub
		return this.cdao.getCitas();
	}
	
	public List<Cita> obtenerCitasPendientes(Medico medico){
		return this.cdao.obtenerCitasPendientes(medico);
	}
	
	public List<Cita> obtenerCitasAgendadas(Medico medico){
		return this.cdao.obtenerCitasAgendadas(medico);
	}

}
