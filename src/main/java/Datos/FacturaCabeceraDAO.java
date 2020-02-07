package Datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import Modelo.FacturaCabecera;

@Stateless
public class FacturaCabeceraDAO {

	@Inject
	private EntityManager em;
	
	public void insert(FacturaCabecera fc) {
		em.persist(fc);
	}
	
	public void update(FacturaCabecera fc) {
		em.merge(fc);
	}
	
	public FacturaCabecera read(String numeroFactura) {
		return em.find(FacturaCabecera.class, numeroFactura);
	}
	
	public void delete(String numeroFactura) {
		em.remove(this.read(numeroFactura));
	}
	
	public List<FacturaCabecera> getFacturaCabecera(){
		String jpql = "SELECT f FROM FacturaCabecera f";
		Query query = em.createQuery(jpql, FacturaCabecera.class);
		List<FacturaCabecera> listado = query.getResultList();		
		return listado;
	}
	
}
