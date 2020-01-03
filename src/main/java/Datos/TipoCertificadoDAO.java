package Datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import Modelo.TipoCertificado;

@Stateless
public class TipoCertificadoDAO {
	
	@Inject
	private EntityManager em;
	
	public void insertar(TipoCertificado tipoCertificado) {
		em.persist(tipoCertificado);
	}
	
	public void actualizar(TipoCertificado tipoCertificado) {
		em.merge(tipoCertificado);
	}
	
	public void borrar(int codigo) {
		em.remove(leer(codigo));
	}
	
	public TipoCertificado leer(int codigo) {
		return em.find(TipoCertificado.class, codigo);
	}
	
	public List<TipoCertificado> getTipoCertificados(){
		String jpql = "SELECT t FROM TipoCertificado t";
		Query query = em.createQuery(jpql, TipoCertificado.class);
		List<TipoCertificado> listado = query.getResultList();		
		return listado;
	}
	
}
