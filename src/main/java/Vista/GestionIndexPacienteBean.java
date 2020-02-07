package Vista;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import Modelo.Cita;
import Modelo.Medico;
import Modelo.Paciente;
import Negocio.GestionCitaLocal;
import Negocio.GestionMedicoLocal;
import Negocio.GestionPacienteLocal;

@ManagedBean
@ViewScoped
public class GestionIndexPacienteBean {
	

	@Inject
	private GestionMedicoLocal gml;
	
	@Inject
	private GestionCitaLocal gcl;
	
	@Inject
	private GestionPacienteLocal gpl;
	
	
	private Medico medico;
	private Date fecha;
	private String hora;
	
	private List<Medico> medicos;
	private List<Cita> citas;
	
	@PostConstruct
	public void init() {
		this.listarMedico();
		this.citas= new ArrayList<Cita>();
		
	}
	
	public List<Medico> getMedicos() {
		return medicos;
	}
	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}
	public GestionCitaLocal getGcl() {
		return gcl;
	}
	public void setGcl(GestionCitaLocal gcl) {
		this.gcl = gcl;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	
	
	
	public GestionMedicoLocal getGml() {
		return gml;
	}

	public void setGml(GestionMedicoLocal gml) {
		this.gml = gml;
	}

	public GestionPacienteLocal getGpl() {
		return gpl;
	}

	public void setGpl(GestionPacienteLocal gpl) {
		this.gpl = gpl;
	}

	
	
	public List<Cita> getCitas() {
		return citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}

	public void listarMedico() {
		this.medicos= this.gml.getMedicos();
	}
	
	
	
	public String guardarCita(String user) {
		System.out.println(user);
		Cita cita = new Cita();
		cita.setCodigo(this.gcl.getCitas().size()+1);
		cita.setPaciente(this.buscarPacientexEmail(user));
		cita.setMedico(this.getMedico());
		cita.setFecha(this.getFecha());
		cita.setHora(this.getHora());
		cita.setEstado("Pendiente");
		System.out.println(this.medico.toString());
		System.out.println(cita.toString());
		this.gcl.insertar(cita);
		return "index2?faces-redirect=true";
	}
	
	public Paciente buscarPacientexEmail(String user) {
		List<Paciente> pacientes = new ArrayList<Paciente>();
		pacientes = this.gpl.getPacientes();
		for(Paciente p: pacientes) {
			if(p.getEmail().equals(user)) {
				return p;
			}
		}
		return null;
	}
	
	public String eliminar(int codigo) {
		
		try {
			this.gcl.borrar(codigo);
			System.out.println("Cita eliminado");
			return "index2?faces-redirect=true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error al eliminar");
			e.printStackTrace();			
		}		
		return null;
	}
	
	public List<Cita> obtenerCitas(String email){
		System.out.println(email);
		List<Cita> aux= new ArrayList<Cita>();
		this.citas=this.gcl.getCitas();
		for(Cita ci: citas) {
			if(ci.getPaciente().getEmail().equals(email)) {
				aux.add(ci);
			}
		}
		return aux;
	}

}
