package Datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import Modelo.Administrador;

@Stateless
public class AdministradorDAO {
	
	@Inject
	private EntityManager em;
	
	public void insertar(Administrador administrador) {
		em.persist(administrador);
	}
	
	public void actualizar(Administrador administrador) {
		em.merge(administrador);
	}
	
	public void borrar(int codigo) {
		em.remove(leer(codigo));
	}
	
	public Administrador leer(int codigo) {
		return em.find(Administrador.class, codigo);
	}
	
	public List<Administrador> getAdministradores(){
		String jpql = "SELECT a FROM Administrador a";
		Query query = em.createQuery(jpql, Administrador.class);
		List<Administrador> listado = query.getResultList();		
		return listado;
	}
	
}
