package datos;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Medico;
import modelo.Reporte;


public class MedicoDAO {

	@Inject
	private EntityManager em;
	
	public void insert(Medico medico) {
		em.persist(medico);
	}
	
	public void update(Medico medico) {
		em.merge(medico);
	}
	
	public void remove(int codigo) {
		em.remove(this.read(codigo));
	}
	
	public Medico read(int codigo) {
		return em.find(Medico.class, codigo);
	}
	
	public List<Medico> getMedicos(){
		String jpql = "SELECT l FROM Medico l";
		Query q = em.createQuery(jpql, Medico.class);
		
		List<Medico> medicos = q.getResultList();
		
		return medicos;
	}
	
	public List<Medico> getMedicoXNombre(String filtro){
		String jpql = "SELECT l FROM Medico l WHERE codigo LIKE ?1";
		Query q = em.createQuery(jpql, Medico.class);
		q.setParameter(1, "%" + filtro + "%");
		
		List<Medico> medicos = q.getResultList();
		
		return medicos;
	}
}
