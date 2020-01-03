package Negocio;

import java.util.List;

import javax.ejb.Local;

import Modelo.Especialidad;

@Local
public interface EspecialidadLocal {

	public void insertar(Especialidad especialidad);
	public void actualizar(Especialidad especialidad);
	public void borrar(int codigo);
	public Especialidad leer(int codigo);
	public List<Especialidad> getEspecialidades();
}