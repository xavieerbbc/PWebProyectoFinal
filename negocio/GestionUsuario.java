package negocio;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import datos.UsuarioDAO;

import modelo.Usuario;

@Stateless
public class GestionUsuario implements GestionUsuarioLocal, GestionUsuarioRemote{

	@Inject
	private UsuarioDAO dao;
	
	
	public void guardarUsuario(String nombre, String apellido, String direccion, String telefono, String cedula, String email){
		Usuario u = new Usuario();  
		u.setNombre(nombre);
		u.setApellido(apellido);
		u.setDireccion(direccion);
		u.setTelefono(telefono);
		u.setCedula(cedula);
		u.setEmail(email);
		System.out.println(u);
		dao.insert(u);
	}
	
	public List<Usuario> getUsuario(){
		
		return dao.getUsuarios();
	}
	
	public List<Usuario> getUsuariosPorNombre(String filtro){
		
		return dao.getUsuarioXNombre(filtro);
	}

	
	
}
