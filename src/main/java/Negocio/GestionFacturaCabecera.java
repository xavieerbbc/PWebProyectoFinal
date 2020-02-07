package Negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import Datos.FacturaCabeceraDAO;
import Modelo.FacturaCabecera;

@Stateless
public class GestionFacturaCabecera implements GestionFacturaCabeceraLocal {

	@Inject
	private FacturaCabeceraDAO dao;
	
	@Override
	public void insert(FacturaCabecera fc) {
		dao.insert(fc);
	}

	@Override
	public void update(FacturaCabecera fc) {
		dao.update(fc);
	}

	@Override
	public FacturaCabecera read(String numeroFactura) {
		return dao.read(numeroFactura);
	}

	@Override
	public void delete(String numeroFactura) {
		dao.delete(numeroFactura);
	}

	@Override
	public List<FacturaCabecera> getFacturaCabecera() {
		return dao.getFacturaCabecera();
	}

}
