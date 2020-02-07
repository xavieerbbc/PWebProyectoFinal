package Datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import Modelo.Cita;
import Modelo.Medico;

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
	
	public List<Cita> obtenerCitasPendientes(Medico medico){
		String jpql = "SELECT c FROM Cita c WHERE c.medico = :medico and c.estado = :estado";
		Query query = em.createQuery(jpql, Cita.class);
		query.setParameter("medico", medico);
		query.setParameter("estado", "Pendiente");
		List<Cita> listado = query.getResultList();
		return listado;
	}
	
	public List<Cita> obtenerCitasAgendadas(Medico medico){
		String jpql = "SELECT c FROM Cita c WHERE c.medico = :medico and c.estado = :estado";
		Query query = em.createQuery(jpql, Cita.class);
		query.setParameter("medico", medico);
		query.setParameter("estado", "Agendada");
		List<Cita> listado = query.getResultList();
		return listado;
	}
	
	
}
