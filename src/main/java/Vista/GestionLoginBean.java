package Vista;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
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
	private Administrador admin;
	private Medico medico;
	private Paciente paciente;
	private String nuevaContrasena;
	private String repiteContrasena;

	public String iniciarSesion() {
		
		Paciente paciente= this.validarLoginPaciente();
		Medico medico=this.validarLoginMedico();
		Administrador administrador=this.validarLoginAdministrador();
		
		if(paciente != null) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", this.email);
			this.paciente=paciente;
			this.nameUser=this.paciente.getNombre()+" "+this.paciente.getApellido();
			return "paginaPrincipalPaciente.xhtml";
		}else if(medico != null) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", this.email);
			this.medico=medico;
			this.nameUser=medico.getNombre()+" "+medico.getApellido();
			return "PaginaPrincipalMedico.xhtml";
		}else if(administrador != null) {
			HttpSession session = SessionUtils.getSession();
			session.setAttribute("username", this.email);
			//comentario para hacer commit
			this.admin=administrador;
			this.nameUser=this.admin.getNombre()+" "+this.admin.getApellido();
			return "PaginaPrincipalAdministrador.xhtml";
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
	
	public String editarAdministrador() {
		this.gal.actualizar(this.admin);
		this.nameUser=this.admin.getNombre()+" "+this.admin.getApellido();
		return "PaginaPrincipalAdministrador.xhtml";
	}
	
	public String editarMedico() {
		this.gml.actualizar(this.medico);
		this.nameUser=medico.getNombre()+" "+medico.getApellido();
		return "PaginaPrincipalMedico.xhtml";
	}
	
	public String editarClaveAdministrador() {
		if(this.getNuevaContrasena().equals(this.getRepiteContrasena())) {
			this.admin.setClave(this.getNuevaContrasena());
			System.out.println(this.admin.toString());
			this.gal.actualizar(this.admin);
			this.cerrarSesion();
			return "login.xhtml";
		}else {
			System.out.println("Las contraseñas no son iguales");
			return "PaginaCambiarClave";
		}
	}
	
	public String editarClaveMedico() {
		if(this.getNuevaContrasena().equals(this.getRepiteContrasena())) {
			this.medico.setClave(this.getNuevaContrasena());
			System.out.println(this.medico.toString());
			this.gml.actualizar(this.medico);
			this.cerrarSesion();
			return "login.xhtml";
		}else {
			System.out.println("Las contraseñas no son iguales");
			return "PaginaCambiarClaveMedico";
		}
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

	public Administrador getAdmin() {
		return admin;
	}

	public void setAdmin(Administrador admin) {
		this.admin = admin;
	}

	public String getNuevaContrasena() {
		return nuevaContrasena;
	}

	public void setNuevaContrasena(String nuevaContrasena) {
		this.nuevaContrasena = nuevaContrasena;
	}

	public String getRepiteContrasena() {
		return repiteContrasena;
	}

	public void setRepiteContrasena(String repiteContrasena) {
		this.repiteContrasena = repiteContrasena;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	
}
