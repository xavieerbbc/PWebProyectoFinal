package Datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import Modelo.Paciente;

@Stateless
public class PacienteDAO {

	@Inject
	private EntityManager em;
	
	public void insertar(Paciente paciente) {
		em.persist(paciente);
	}
	
	public void actualizar(Paciente paciente) {
		em.merge(paciente);
	}
	
	public void borrar(int codigo) {
		em.remove(leer(codigo));
	}
	
	public Paciente leer(int codigo) {
		return em.find(Paciente.class, codigo);
	}
	
	public List<Paciente> getPacientes(){
		String jpql = "SELECT p FROM Paciente p";
		Query query = em.createQuery(jpql, Paciente.class);
		List<Paciente> listado = query.getResultList();		
		return listado;
	}
	
}
