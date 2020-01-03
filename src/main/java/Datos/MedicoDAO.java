package Datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import Modelo.Medico;

@Stateless
public class MedicoDAO {

	@Inject
	private EntityManager em;
	
	public void insertar(Medico medico) {
		em.persist(medico);
	}
	
	public void actualizar(Medico medico) {
		em.merge(medico);
	}
	
	public void borrar(int codigo) {
		em.remove(leer(codigo));
	}
	
	public Medico leer(int codigo) {
		return em.find(Medico.class, codigo);
	}
	
	public List<Medico> getMedicos(){
		String jpql = "SELECT m FROM Medico m";
		Query query = em.createQuery(jpql, Medico.class);
		List<Medico> listado = query.getResultList();		
		return listado;
	}
	
}
