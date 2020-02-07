package Negocio;

import java.util.List;

import javax.ejb.Local;

import Modelo.Medico;

@Local
public interface GestionMedicoLocal {

	public void insertar(Medico medico);
	public void actualizar(Medico medico);
	public void borrar(int codigo);
	public Medico leer(int codigo);
	public List<Medico> getMedicos();
	public Medico buscarMedicoxEmail(String email);
	public List<Medico> getMedicoPorEspecialidad(int filtro);
}
