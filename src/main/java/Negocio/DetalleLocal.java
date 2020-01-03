package Negocio;

import java.util.List;

import javax.ejb.Local;

import Modelo.Detalle;

@Local
public interface DetalleLocal {

	public void insertar(Detalle detalle);
	public void actualizar(Detalle detalle);
	public void borrar(int codigo);
	public Detalle leer(int codigo);
	public List<Detalle> getDetalles();
}
