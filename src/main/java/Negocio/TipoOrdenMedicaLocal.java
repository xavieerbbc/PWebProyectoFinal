package Negocio;

import java.util.List;

import javax.ejb.Local;

import Modelo.TipoOrdenMedica;

@Local
public interface TipoOrdenMedicaLocal {

	public void insertar(TipoOrdenMedica tipoOrdenMedica) ;
	public void actualizar(TipoOrdenMedica tipoOrdenMedica);
	public void borrar(int codigo);
	public TipoOrdenMedica leer(int codigo)  ;
	public List<TipoOrdenMedica> getTipoOrdenesMedicas();
}