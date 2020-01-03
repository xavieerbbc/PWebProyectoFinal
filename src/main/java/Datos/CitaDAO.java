package Datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import Modelo.Cita;

@Stateless
public class CitaDAO {
	
	@Inject
	private EntityManager em;
	
	public void insertar(Cita cita) {
		em.persist(cita);
	}
	
	public void actualizar(Cita cita) {
		em.merge(cita);
	}
	
	public void borrar(int codigo) {
		em.remove(leer(codigo));
	}
	
	public Cita leer(int codigo) {
		return em.find(Cita.class, codigo);
	}
	
	public List<Cita> getCitas(){
		String jpql = "SELECT c FROM Cita c";
		Query query = em.createQuery(jpql, Cita.class);
		List<Cita> listado = query.getResultList();		
		return listado;
	}
	
}
