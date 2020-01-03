package Negocio;

import java.util.List;

import javax.ejb.Local;

import Modelo.TipoCertificado;

@Local
public interface TipoCertificadoLocal {

	public void insertar(TipoCertificado tipoCertificado) ;
	public void actualizar(TipoCertificado tipoCertificado);
	public void borrar(int codigo);
	public TipoCertificado leer(int codigo)  ;
	public List<TipoCertificado> getTipoCertificados();
}