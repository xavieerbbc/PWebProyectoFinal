package datos;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Paciente;
import modelo.Reporte;



public class PacienteDAO {
	
	@Inject
	private EntityManager em;
	
	public void insert(Paciente paciente) {
		em.persist(paciente);
	}
	
	public void update(Paciente paciente) {
		em.merge(paciente);
	}
	
	public void remove(int codigo) {
		em.remove(this.read(codigo));
	}
	
	public Paciente read(int codigo) {
		return em.find(Paciente.class, codigo);
	}
	
	public List<Paciente> getPacientes(){
		String jpql = "SELECT l FROM Paciente l";
		Query q = em.createQuery(jpql, Paciente.class);
		
		List<Paciente> pacientes = q.getResultList();
		
		return pacientes;
	}
	
	public List<Paciente> getPacienteXNombre(String filtro){
		String jpql = "SELECT l FROM Paciente l WHERE codigo LIKE ?1";
		Query q = em.createQuery(jpql, Paciente.class);
		q.setParameter(1, "%" + filtro + "%");
		
		List<Paciente> pacientes = q.getResultList();
		
		return pacientes;
	}

}
