package Datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import Modelo.Detalle;

@Stateless
public class DetalleDAO {
	
	@Inject
	private EntityManager em;
	
	public void insertar(Detalle detalle) {
		em.persist(detalle);
	}
	
	public void actualizar(Detalle detalle) {
		em.merge(detalle);
	}
	
	public void borrar(Detalle detalle) {
		em.remove(detalle);
	}
	
	public Detalle leer(int codigo) {
		return em.find(Detalle.class, codigo);
	}
	
	public List<Detalle> getDetalles(){
		String jpql = "SELECT d FROM Detalle d";
		Query query = em.createQuery(jpql, Detalle.class);
		List<Detalle> listado = query.getResultList();		
		return listado;
	}
	
}
