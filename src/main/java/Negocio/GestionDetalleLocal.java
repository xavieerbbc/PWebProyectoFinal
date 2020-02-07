package Negocio;


import javax.ejb.Local;

import Modelo.Detalle;


@Local
public interface GestionDetalleLocal {

	public void borrar(Detalle detalle);
}
