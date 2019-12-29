package negocio;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import modelo.Caja;
import modelo.Usuario;

@Local
public interface GestionUsuarioLocal {
	
	public void guardarUsuario(String nombre, String apellido, String direccion, String telefono, String cedula, String email);
	public List<Usuario> getUsuario();
	public List<Usuario> getUsuariosPorNombre(String filtro);

}
