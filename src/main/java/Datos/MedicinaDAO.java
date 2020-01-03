package Datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import Modelo.Medicina;

@Stateless
public class MedicinaDAO {

	@Inject
	private EntityManager em;
	
	public void insertar(Medicina medicina) {
		em.persist(medicina);
	}
	
	public void actualizar(Medicina medicina) {
		em.merge(medicina);
	}
	
	public void borrar(int codigo) {
		em.remove(leer(codigo));
	}
	
	public Medicina leer(int codigo) {
		return em.find(Medicina.class, codigo);
	}
	
	public List<Medicina> getMedicinas(){
		String jpql = "SELECT m FROM Medicina m";
		Query query = em.createQuery(jpql, Medicina.class);
		List<Medicina> listado = query.getResultList();		
		return listado;
	}
	
}
