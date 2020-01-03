package Datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import Modelo.Especialidad;

@Stateless
public class EspecialidadDAO {

	@Inject
	private EntityManager em;
	
	public void insertar(Especialidad especialidad) {
		em.persist(especialidad);
	}
	
	public void actualizar(Especialidad especialidad) {
		em.merge(especialidad);
	}
	
	public void borrar(int codigo) {
		em.remove(leer(codigo));
	}
	
	public Especialidad leer(int codigo) {
		return em.find(Especialidad.class, codigo);
	}
	
	public List<Especialidad> getEspecialidades(){
		String jpql = "SELECT e FROM Especialidad e";
		Query query = em.createQuery(jpql, Especialidad.class);
		List<Especialidad> listado = query.getResultList();		
		return listado;
	}
	
}
