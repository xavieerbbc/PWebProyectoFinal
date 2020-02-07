package Datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import Modelo.Servicio;

@Stateless
public class ServicioDAO {

	@Inject
	private EntityManager em;
	
	public void insert(Servicio s) {
		em.persist(s);
	}
	
	public void update(Servicio s) {
		em.merge(s);
	}
	
	public Servicio read(int codigo) {
		return em.find(Servicio.class,codigo);
	}
	
	public void delete(int codigo) {
		em.remove(this.read(codigo));
	}
	
	public List<Servicio> getServicio(){
		String jpql = "SELECT s FROM Servicio s";
		Query query= em.createQuery(jpql,Servicio.class);
		return query.getResultList();
	}
}
