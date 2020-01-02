package vista;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Email;

import modelo.Usuario;
import negocio.GestionUsuarioLocal;



@ManagedBean
public class GestionUsuariosBean {

	@Inject
	private GestionUsuarioLocal gl;
	
	
	/*Beans properties*/
	private String nombre;
	private String apellido;
	private String direccion;
	private String telefono;
	private String cedula;
	private String email;
	
	private List<Usuario> usuario;

	public GestionUsuarioLocal getGl() {
		return gl;
	}

	public void setGl(GestionUsuarioLocal gl) {
		this.gl = gl;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Usuario> getUsuario() {
		return usuario;
	}

	public void setUsuario(List<Usuario> usuario) {
		this.usuario = usuario;
	}
	
public String guardarUsuario() {
		
		System.out.println(nombre + "  " + apellido + " " + " "+direccion + " "+ telefono+ " " +cedula +" " + email);
		gl.guardarUsuario(nombre, apellido, direccion, telefono,cedula, email); 
		
		usuario = gl.getUsuario();
		
		return "listado-libros";
	}

}
