package Negocio;

import javax.ejb.Stateless;
import javax.inject.Inject;

import Datos.DetalleDAO;
import Modelo.Detalle;

@Stateless
public class GestionDetalle implements GestionDetalleLocal {
	
	@Inject
	private DetalleDAO ddao;

	
	@Override
	public void borrar(Detalle detalle) {
		// TODO Auto-generated method stub
		this.ddao.borrar(detalle);
		
	}
}
