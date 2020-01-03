package Datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import Modelo.MedicoEspecialidad;

@Stateless
public class MedicoEspecialidadDAO {

	@Inject
	private EntityManager em;
	
	public void insertar(MedicoEspecialidad medicoEspecialidad) {
		em.persist(medicoEspecialidad);
	}
	
	public void actualizar(MedicoEspecialidad medicoEspecialidad) {
		em.merge(medicoEspecialidad);
	}
	
	public void borrar(int codigo) {
		em.remove(leer(codigo));
	}
	
	public MedicoEspecialidad leer(int codigo) {
		return em.find(MedicoEspecialidad.class, codigo);
	}
	
	public List<MedicoEspecialidad> getMedicoEspecialidades(){
		String jpql = "SELECT m FROM MedicoEspecialidad m";
		Query query = em.createQuery(jpql, MedicoEspecialidad.class);
		List<MedicoEspecialidad> listado = query.getResultList();		
		return listado;
	}
	
}
