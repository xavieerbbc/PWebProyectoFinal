package Vista;


import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import Modelo.Medico;
import Negocio.GestionMedicoLocal;
import Negocio.GestionRolLocal;

@ManagedBean
@ViewScoped
public class GestionMedicoBean {
	
	@Inject
	private GestionMedicoLocal gml;
	
	@Inject
	private GestionRolLocal grl;
	
	private String id;
	
	private List<Medico> medicos;
	
	private String cedula;
	private String nombre;
	private String apellido;
	private String email;
	private String clave;
	private Date fechaNac;
	
	@PostConstruct
	public void init() {
		this.medicos = gml.getMedicos();
	}
	
	
	
	
	public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}




	public GestionRolLocal getGrl() {
		return grl;
	}


	public void setGrl(GestionRolLocal grl) {
		this.grl = grl;
	}


	public List<Medico> getMedicos() {
		return medicos;
	}


	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}


	public GestionMedicoLocal getGml() {
		return gml;
	}
	public void setGml(GestionMedicoLocal gml) {
		this.gml = gml;
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
	public Date getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}
	
	public void guardarMedico() {
		Medico medico = new Medico();
		medico.setCodigo(this.gml.getMedicos().size()+1);
		medico.setCedula(this.getCedula());
		medico.setNombre(this.getNombre());
		medico.setApellido(this.getApellido());
		medico.setEmail(this.getEmail());
		medico.setClave(this.getClave());
		medico.setFechaNac(this.getFechaNac());
		medico.setRol(this.grl.leer(2));
		this.gml.insertar(medico);
	}
	
	public String eliminar(int codigo) {
		
		try {
			this.gml.borrar(codigo);
			System.out.println("Registro eliminado");
			return "crearMedico?faces-redirect=true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error al eliminar");
			e.printStackTrace();			
		}		
		return null;
	}
	
	public String editar(Medico medico) {
		
		return "editarMedico?faces-redirect=true&id="+medico.getCodigo();
	}
	
	public void loadData() {
		
		
		Medico aux = gml.leer(Integer.parseInt(id));
		this.setCedula(aux.getCedula());
		this.setNombre(aux.getNombre());
		this.setApellido(aux.getApellido());
		this.setEmail(aux.getEmail());
		this.setClave(aux.getClave());
		this.setFechaNac(aux.getFechaNac());
	}
	
	public String editarMedico() {
		Medico medicoActualizado = new Medico();
		medicoActualizado.setCodigo(Integer.parseInt(this.getId()));
		medicoActualizado.setCedula(this.getCedula());
		medicoActualizado.setNombre(this.getNombre());
		medicoActualizado.setApellido(this.getApellido());
		medicoActualizado.setEmail(this.getEmail());
		medicoActualizado.setClave(this.getClave());
		medicoActualizado.setFechaNac(this.getFechaNac());
		this.gml.actualizar(medicoActualizado);
		return "crearMedico?faces-redirect=true";
	}
	
	
	
}
