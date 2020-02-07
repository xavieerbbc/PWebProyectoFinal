package Negocio;

import java.util.List;

import Modelo.Servicio;

public interface GestionServicioLocal {

	public void insert(Servicio s);
	public void update(Servicio s);
	public Servicio read(int codigo);
	public void delete(int codigo);
	public List<Servicio> getServicio();
}
