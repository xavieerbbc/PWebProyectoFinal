package Datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import Modelo.Rol;

@Stateless
public class RolDAO {

	@Inject
	private EntityManager em;
	
	public void insertar(Rol rol) {
		em.persist(rol);
	}
	
	public void actualizar(Rol rol) {
		em.merge(rol);
	}
	
	public void borrar(int codigo) {
		em.remove(leer(codigo));
	}
	
	public Rol leer(int codigo) {
		return em.find(Rol.class, codigo);
	}
	
	public List<Rol> getRoles(){
		String jpql = "SELECT r FROM Rol r";
		Query query = em.createQuery(jpql, Rol.class);
		List<Rol> listado = query.getResultList();		
		return listado;
	}
	
}
