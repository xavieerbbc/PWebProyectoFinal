package Negocio;

import java.util.List;

import javax.ejb.Local;

import Modelo.Cita;
import Modelo.Medico;

@Local
public interface GestionCitaLocal {

	public void insertar(Cita cita);
	public void actualizar(Cita cita);
	public void borrar(int codigo);
	public Cita leer(int codigo);
	public List<Cita> getCitas();
	public List<Cita> obtenerCitasPendientes(Medico medico);
	public List<Cita> obtenerCitasAgendadas(Medico medico);
}
