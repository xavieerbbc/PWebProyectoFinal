package Negocio;

import java.util.List;

import javax.ejb.Local;

import Modelo.Cita;

@Local
public interface GestionCitaLocal {

	public void insertar(Cita cita);
	public void actualizar(Cita cita);
	public void borrar(int codigo);
	public Cita leer(int codigo);
	public List<Cita> getCitas();
}
