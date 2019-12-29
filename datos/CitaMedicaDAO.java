package datos;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.CitaMedica;
import modelo.Medico;

public class CitaMedicaDAO {

	@Inject
	private EntityManager em;
	
	public void insert(CitaMedica citaMedica) {
		em.persist(citaMedica);
	}
	
	public void update(CitaMedica citaMedica) {
		em.merge(citaMedica);
	}
	
	public void remove(int codigo) {
		em.remove(this.read(codigo));
	}
	
	public CitaMedica read(int codigo) {
		return em.find(CitaMedica.class, codigo);
	}
	
	public List<CitaMedica> getCitaMedicas(){
		String jpql = "SELECT l FROM CitaMedica l";
		Query q = em.createQuery(jpql, CitaMedica.class);
		
		List<CitaMedica> citaMedicas = q.getResultList();
		
		return citaMedicas;
	}
	
	public List<CitaMedica> getCitaMedicaXNombre(String filtro){
		String jpql = "SELECT l FROM CitaMedica l WHERE codigo LIKE ?1";
		Query q = em.createQuery(jpql, CitaMedica.class);
		q.setParameter(1, "%" + filtro + "%");
		
		List<CitaMedica> citaMedicas = q.getResultList();
		
		return citaMedicas;
	}
}
