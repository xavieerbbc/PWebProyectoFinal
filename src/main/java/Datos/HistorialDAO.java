package Datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import Modelo.Historial;
import Modelo.Medico;

@Stateless
public class HistorialDAO {

	@Inject
	private EntityManager em;
	
	public void insertar(Historial h) {
		em.persist(h);
	}
	
	public void actualizar(Historial h) {
		em.merge(h);
	}
	
	public void borrar(int codigo) {
		em.remove(leer(codigo));
	}
	
	public Historial leer(int codigo) {
		return em.find(Historial.class, codigo);
	}
	
	public List<Historial> getHistoriales(){
		String jpql = "SELECT h FROM Historial h";
		Query query = em.createQuery(jpql, Historial.class);
		List<Historial> listado = query.getResultList();		
		return listado;
	}
	
	public List<Historial> obtenerHistorialesMedico(Medico medico){
		String jpql = "SELECT h FROM Historial h WHERE h.medico = :medico";
		Query query = em.createQuery(jpql, Historial.class);
		query.setParameter("medico", medico);
		List<Historial> listado = query.getResultList();
		return listado;
	}
	
	
}
