package Negocio;

import java.util.List;

import javax.ejb.Local;

import Modelo.Administrador;

@Local
public interface GestionAdministradorLocal {

	public void insertar(Administrador administrador);
	public List<Administrador> getAdministradores();
	public Administrador leer(String cedula);
	public void borrar(String cedula);
	public void actualizar(Administrador administrador);
}
