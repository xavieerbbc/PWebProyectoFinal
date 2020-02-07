package Negocio;

import java.util.List;

import Modelo.FacturaCabecera;

public interface GestionFacturaCabeceraLocal {

	public void insert(FacturaCabecera fc);
	public void update(FacturaCabecera fc);
	public FacturaCabecera read(String numeroFactura);
	public void delete(String numeroFactura);
	public List<FacturaCabecera> getFacturaCabecera();
}
