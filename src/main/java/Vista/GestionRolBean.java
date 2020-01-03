package Vista;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import Modelo.Rol;
import Negocio.GestionRolLocal;

@ManagedBean
public class GestionRolBean {
	
	@Inject
	private GestionRolLocal grl;
	
	private int codigo;
	private String nombre;

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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public void guardarRol() {
		Rol rol = new Rol();
		rol.setCodigo(this.getCodigo());
		rol.setNombre(this.getNombre());
		this.grl.insertar(rol);
	}
	
}
