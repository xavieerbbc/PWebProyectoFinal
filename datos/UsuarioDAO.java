package datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Usuario;


@Stateless
public class UsuarioDAO {
	
	@Inject
	private EntityManager em;
	
	public void insert(Usuario usuario) {
		em.persist(usuario);
	}
	
	public void update(Usuario usuario) {
		em.merge(usuario);
	}
	
	public void remove(String nombre) {
		em.remove(this.read(nombre));
	}
	
	public Usuario read(String nombre) {
		return em.find(Usuario.class, nombre);
	}
	
	
	public List<Usuario> getUsuarios(){
		String jpql = "SELECT l FROM Usuario l";
		Query q = em.createQuery(jpql, Usuario.class);
		
		List<Usuario> usuarios = q.getResultList();
		
		return usuarios;
	}
	
	public List<Usuario> getUsuarioXNombre(String filtro){
		String jpql = "SELECT l FROM Cliente l WHERE nombre LIKE ?1";
		Query q = em.createQuery(jpql, Usuario.class);
		q.setParameter(1, "%" + filtro + "%");
		
		List<Usuario> usuarios = q.getResultList();
		
		return usuarios;
	}

}
