package datos;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Caja;
import modelo.Certificado;
import modelo.Medico;

public class CajaDAO {

	@Inject
	private EntityManager em;
	
	public void insert(Caja caja) {
		em.persist(caja);
	}
	
	public void update(Caja caja) {
		em.merge(caja);
	}
	
	public void remove(int codigo) {
		em.remove(this.read(codigo));
	}
	
	public Caja read(int codigo) {
		return em.find(Caja.class, codigo);
	}

	public List<Caja> getCajas(){
		String jpql = "SELECT l FROM Caja l";
		Query q = em.createQuery(jpql, Caja.class);
		
		List<Caja> cajas = q.getResultList();
		
		return cajas;
	}
	
	public List<Caja> getCajaXNombre(String filtro){
		String jpql = "SELECT l FROM Caja l WHERE codigo LIKE ?1";
		Query q = em.createQuery(jpql, Caja.class);
		q.setParameter(1, "%" + filtro + "%");
		
		List<Caja> cajas = q.getResultList();
		
		return cajas;
	}
	
}
