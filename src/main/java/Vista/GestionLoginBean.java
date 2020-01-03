package Vista;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
//import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;

import Modelo.Administrador;
import Modelo.Medico;
import Modelo.Paciente;
import Negocio.GestionAdministradorLocal;
import Negocio.GestionMedicoLocal;
import Negocio.GestionPacienteLocal;
import Util.SessionUtils;

@ManagedBean
@SessionScoped
public class GestionLoginBean implements Serializable {
	
	private static final long serialVersionUID = 1490469485586527243L;
	
	@Inject
	private GestionPacienteLocal gpl;	
	@Inject
	private GestionMedicoLocal gml;
	@Inject
	private GestionAdministradorLocal gal;
	
	private String email;
	private String contrasena;
	private String user;
	private String nameUser;

	public String iniciarSesion() {
		
		Paciente paciente= this.validarLoginPaciente();
		Medico medico=this.validarLoginMedico();
		Administrador administrador=this.validarLoginAdministrador();
		
		if(paciente != null) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", this.email);
			this.nameUser=paciente.getNombre()+" "+paciente.getApellido();
			return "index2.xhtml";
		}else if(medico != null) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", this.email);
			this.nameUser=medico.getNombre()+" "+medico.getApellido();
			return "index.xhtml";
		}else if(administrador != null) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", this.email);
			this.nameUser=administrador.getNombre()+" "+administrador.getApellido();
			return "crearMedico.xhtml";
		}
		
		return null;
	}
	
	public String cerrarSesion() {
		HttpSession session = SessionUtils.getSession();
		System.out.println(session.toString());
		session.invalidate();
		return "login.xhtml";
	}
	
	public Paciente validarLoginPaciente() {
		List<Paciente> pacientes = new ArrayList<Paciente>();
		pacientes = this.gpl.getPacientes();
		for(Paciente p: pacientes) {
			if(p.getEmail().equals(this.getEmail()) && p.getClave().equals(this.getContrasena())) {
				return p;
			}
		}
		return null;
	}
	
	public Medico validarLoginMedico() {
		List<Medico> medicos =new ArrayList<Medico>();
		medicos= this.gml.getMedicos();
		for(Medico m: medicos) {
			if(m.getEmail().equals(this.getEmail()) && m.getClave().equals(this.getContrasena())) {
				return m;
			}
		}
		return null;
	}
	
	public Administrador validarLoginAdministrador() {
		List<Administrador> administradores= new ArrayList<Administrador>();
		administradores=this.gal.getAdministradores();
		for(Administrador a:administradores) {
			if(a.getEmail().equals(this.getEmail()) && a.getClave().equals(this.getContrasena())) {
				return a;
			}
		}
		return null;
	}
	
	
	public GestionPacienteLocal getGpl() {
		return gpl;
	}
	public void setGpl(GestionPacienteLocal gpl) {
		this.gpl = gpl;
	}
	
	public GestionMedicoLocal getGml() {
		return gml;
	}
	public void setGml(GestionMedicoLocal gml) {
		this.gml = gml;
	}
	public GestionAdministradorLocal getGal() {
		return gal;
	}
	public void setGal(GestionAdministradorLocal gal) {
		this.gal = gal;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContrasena() {
		return contrasena;
	}
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getNameUser() {
		return nameUser;
	}

	public void setNameUser(String nameUser) {
		this.nameUser = nameUser;
	}
	
}
