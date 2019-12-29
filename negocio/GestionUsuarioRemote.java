package negocio;

import java.util.List;

import javax.ejb.Remote;

import modelo.Usuario;

@Remote
public interface GestionUsuarioRemote {
	
	public void guardarUsuario(String nombre, String apellido, String direccion, String telefono, String cedula, String email);
	public List<Usuario> getUsuario();
	public List<Usuario> getUsuariosPorNombre(String filtro);

}
