package datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Reporte;


@Stateless
public class ReporteDAO {
	
	@Inject
	private EntityManager em;
	
	public void insert(Reporte reporte) {
		em.persist(reporte);
	}
	
	public void update(Reporte reporte) {
		em.merge(reporte);
	}
	
	public void remove(int codigo) {
		em.remove(this.read(codigo));
	}
	
	public Reporte read(int codigo) {
		return em.find(Reporte.class, codigo);
	}
	
	public List<Reporte> getReportes(){
		String jpql = "SELECT l FROM Reporte l";
		Query q = em.createQuery(jpql, Reporte.class);
		
		List<Reporte> reportes = q.getResultList();
		
		return reportes;
	}
	
	public List<Reporte> getReporteXNombre(String filtro){
		String jpql = "SELECT l FROM Reporte l WHERE codigo LIKE ?1";
		Query q = em.createQuery(jpql, Reporte.class);
		q.setParameter(1, "%" + filtro + "%");
		
		List<Reporte> reportes = q.getResultList();
		
		return reportes;
	}

}
