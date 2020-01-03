package Negocio;

import java.util.List;

import javax.ejb.Local;

import Modelo.Medicina;

@Local
public interface MedicinaLocal {

	public void insertar(Medicina medicina);
	public void actualizar(Medicina medicina);
	public void borrar(int codigo);
	public Medicina leer(int codigo);
	public List<Medicina> getMedicinas();
}