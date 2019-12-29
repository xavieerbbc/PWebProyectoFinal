package datos;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Certificado;
import modelo.CitaMedica;


public class CertificadoDAO {

	@Inject
	private EntityManager em;
	
	public void insert(Certificado certificado) {
		em.persist(certificado);
	}
	
	public void update(Certificado certificado) {
		em.merge(certificado);
	}
	
	public void remove(int codigo) {
		em.remove(this.read(codigo));
	}
	
	public Certificado read(int codigo) {
		return em.find(Certificado.class, codigo);
	}

	public List<Certificado> getCertificados(){
		String jpql = "SELECT l FROM Certificado l";
		Query q = em.createQuery(jpql, Certificado.class);
		
		List<Certificado> certificados = q.getResultList();
		
		return certificados;
	}
	
	public List<Certificado> getCertificadoXNombre(String filtro){
		String jpql = "SELECT l FROM Certificado l WHERE codigo LIKE ?1";
		Query q = em.createQuery(jpql, Certificado.class);
		q.setParameter(1, "%" + filtro + "%");
		
		List<Certificado> certificados = q.getResultList();
		
		return certificados;
	}
}
