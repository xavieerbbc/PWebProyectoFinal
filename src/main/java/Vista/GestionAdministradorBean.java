package Vista;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import Modelo.Administrador;
import Modelo.Rol;
import Negocio.GestionAdministradorLocal;
import Negocio.GestionRolLocal;

@ManagedBean
public class GestionAdministradorBean {

	@Inject
	private GestionAdministradorLocal gal;
	@Inject
	private GestionRolLocal grl;
	
	private int codigo;
	private String cedula;
	private String nombre;
	private String apellido;
	private String email;
	private String clave;
	private Rol rol;
	public GestionAdministradorLocal getGal() {
		return gal;
	}
	public void setGal(GestionAdministradorLocal gal) {
		this.gal = gal;
	}
	public GestionRolLocal getGrl() {
		return grl;
	}
	public void setGrl(GestionRolLocal grl) {
		this.grl = grl;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	public void guardarAdministrador(){
		Administrador administrador=new Administrador();
		administrador.setCodigo(this.gal.getAdministradores().size()+1);
		administrador.setCedula(this.cedula);
		administrador.setNombre(this.nombre);
		administrador.setApellido(this.apellido);
		administrador.setEmail(this.email);
		administrador.setClave(this.clave);
		administrador.setRol(this.grl.leer(1));
		this.gal.insertar(administrador);
	}
}
