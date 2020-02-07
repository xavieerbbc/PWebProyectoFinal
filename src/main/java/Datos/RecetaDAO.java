package Datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import Modelo.Medico;
import Modelo.Receta;

@Stateless
public class RecetaDAO {
	
	@Inject
	private EntityManager em;
	
	public void insertar(Receta receta) {
		em.persist(receta);
	}
	
	public void actualizar(Receta receta) {
		em.merge(receta);
	}
	
	public void borrar(int codigo) {
		em.remove(leer(codigo));
	}
	
	public Receta leer(int codigo) {
		return em.find(Receta.class, codigo);
	}
	
	public List<Receta> getRecetas(){
		String jpql = "SELECT r FROM Receta r";
		Query query = em.createQuery(jpql, Receta.class);
		List<Receta> listado = query.getResultList();		
		return listado;
	}
	
	public List<Receta> obtenerRecetasMedico(Medico medico){
		String jpql = "SELECT r FROM Receta r WHERE r.medico = :medico";
		Query query = em.createQuery(jpql, Receta.class);
		query.setParameter("medico", medico);
		List<Receta> listado = query.getResultList();
		return listado;
	}
	
}
