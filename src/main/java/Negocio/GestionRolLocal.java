package Negocio;

import java.util.List;

import javax.ejb.Local;

import Modelo.Rol;

@Local
public interface GestionRolLocal {

	public void insertar(Rol rol) ;
	public void actualizar(Rol rol);
	public void borrar(int codigo);
	public Rol leer(int codigo)  ;
	public List<Rol> getRoles();
}