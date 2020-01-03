package Negocio;

import java.util.List;

import javax.ejb.Local;

import Modelo.MedicoEspecialidad;

@Local
public interface MedicoEspecialidadLocal {

	public void insertar(MedicoEspecialidad medicoEspecialidad) ;
	public void actualizar(MedicoEspecialidad medicoEspecialidad);
	public void borrar(int codigo);
	public MedicoEspecialidad leer(int codigo) ;
	public List<MedicoEspecialidad> getMedicoEspecialidades();
}