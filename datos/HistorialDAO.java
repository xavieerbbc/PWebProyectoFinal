package datos;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Historial;
import modelo.Medico;

public class HistorialDAO {

	@Inject
	private EntityManager em;
	
	public void insert(Historial historial_Clinica) {
		em.persist(historial_Clinica);
	}
	
	public void update(Historial historial_Clinica) {
		em.merge(historial_Clinica);
	}
	
	public void remove(int codigo) {
		em.remove(this.read(codigo));
	}
	
	public Historial read(int codigo) {
		return em.find(Historial.class, codigo);
	}
	
	public List<Historial> getHistorial_Clinicas(){
		String jpql = "SELECT l FROM Historial_Clinica l";
		Query q = em.createQuery(jpql, Historial.class);
		
		List<Historial> historial_Clinicas = q.getResultList();
		
		return historial_Clinicas;
	}
	
	public List<Historial> getHistorial_ClinicaXNombre(String filtro){
		String jpql = "SELECT l FROM Historial_Clinica l WHERE codigo LIKE ?1";
		Query q = em.createQuery(jpql, Historial.class);
		q.setParameter(1, "%" + filtro + "%");
		
		List<Historial> historial_Clinicas = q.getResultList();
		
		return historial_Clinicas;
	}
	
}
