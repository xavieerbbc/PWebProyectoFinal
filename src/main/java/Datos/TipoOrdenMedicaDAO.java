package Datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import Modelo.TipoOrdenMedica;

@Stateless
public class TipoOrdenMedicaDAO {
	
	@Inject
	private EntityManager em;
	
	public void insertar(TipoOrdenMedica tipoOrdenMedica) {
		em.persist(tipoOrdenMedica);
	}
	
	public void actualizar(TipoOrdenMedica tipoOrdenMedica) {
		em.merge(tipoOrdenMedica);
	}
	
	public void borrar(int codigo) {
		em.remove(leer(codigo));
	}
	
	public TipoOrdenMedica leer(int codigo) {
		return em.find(TipoOrdenMedica.class, codigo);
	}
	
	public List<TipoOrdenMedica> getTipoOrdenesMedicas(){
		String jpql = "SELECT t FROM TipoOrdenMedica t";
		Query query = em.createQuery(jpql, TipoOrdenMedica.class);
		List<TipoOrdenMedica> listado = query.getResultList();		
		return listado;
	}
	
}
