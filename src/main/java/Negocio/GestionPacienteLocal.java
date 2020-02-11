package Negocio;

import java.util.List;

import javax.ejb.Local;

import Exception.ExcepcionesRegistro;
import Modelo.Paciente;
import Modelo.Rol;

@Local
public interface GestionPacienteLocal {

	public void insertar(Paciente paciente) ;
	public void insertar2(Paciente paciente) throws ExcepcionesRegistro ;
	public void actualizar(Paciente paciente);
	public void borrar(int codigo);
	public Paciente leer(int codigo) ;
	public List<Paciente> getPacientes();
	public Rol obtenerRol(int codigo);
}