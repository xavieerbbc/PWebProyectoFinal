package Vista;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import Modelo.Paciente;
import Negocio.GestionPacienteLocal;

@ManagedBean
@ViewScoped
public class GestionRecuperarBean {
	
	@Inject
	private GestionPacienteLocal gpl;
	
	private String email;
	private String contrasena;
	private String preguntaSecreta;
	private String claveRecuperada;
	
	
	public String getClaveRecuperada() {
		return claveRecuperada;
	}

	public void setClaveRecuperada(String claveRecuperada) {
		this.claveRecuperada = claveRecuperada;
	}

	public Paciente validarPaciente() {
		List<Paciente> pacientes = new ArrayList<Paciente>();
		pacientes = this.gpl.getPacientes();
		for(Paciente p: pacientes) {
			if(p.getEmail().equals(this.getEmail()) && p.getPreguntaSecreta().equals(this.getPreguntaSecreta())) {
				return p;
			}
		}
		return null;
	}
	
	public void recuperar() {
		Paciente paciente= this.validarPaciente();
		
		if(paciente != null) {
			
			System.out.println(paciente.getClave());
			this.claveRecuperada = paciente.getClave();
		
		}else{
			
			this.claveRecuperada = "Email y/o Pregunta Secreta incorrectas";
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	public GestionPacienteLocal getGpl() {
		return gpl;
	}
	public void setGpl(GestionPacienteLocal gpl) {
		this.gpl = gpl;
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
	public String getPreguntaSecreta() {
		return preguntaSecreta;
	}
	public void setPreguntaSecreta(String preguntaSecreta) {
		this.preguntaSecreta = preguntaSecreta;
	}
	
	

}
