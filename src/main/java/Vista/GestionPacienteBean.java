package Vista;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import Modelo.Medico;
import Modelo.Paciente;
import Modelo.Rol;
import Negocio.GestionPacienteLocal;

@ManagedBean
@ViewScoped
public class GestionPacienteBean {
	
	@Inject
	private GestionPacienteLocal gpl;
	
	private List<Paciente> pacientes;
	
	private String id;
	private String cedula;
	private String nombre;
	private String apellido;
	private String email;
	private String clave;
	private Date fechaNac;
	private String sexo;
	private String preguntaSecreta;
	private String validar;
	private String validar2;
	
	
	public String getValidar2() {
		return validar2;
	}

	public void setValidar2(String validar2) {
		this.validar2 = validar2;
	}

	@PostConstruct
	public void init() {
		this.pacientes=this.gpl.getPacientes();
	}
	
	public GestionPacienteLocal getGpl() {
		return gpl;
	}
	public void setGpl(GestionPacienteLocal gpl) {
		this.gpl = gpl;
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
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	
	public String getPreguntaSecreta() {
		return preguntaSecreta;
	}

	public void setPreguntaSecreta(String preguntaSecreta) {
		this.preguntaSecreta = preguntaSecreta;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}
	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String editar(Paciente paciente) {
		
		return "editarPaciente?faces-redirect=true&id="+paciente.getCodigo();
	}
	
	
	
	
	public String getValidar() {
		return validar;
	}

	public void setValidar(String validar) {
		this.validar = validar;
	}

	public void loadData() {
		Paciente aux = gpl.leer(Integer.parseInt(id));
		this.setCedula(aux.getCedula());
		this.setNombre(aux.getNombre());
		this.setApellido(aux.getApellido());
		this.setEmail(aux.getEmail());
		this.setClave(aux.getClave());
		this.setFechaNac(aux.getFechaNac());
		this.setSexo(aux.getSexo());
		this.setPreguntaSecreta(preguntaSecreta);
	}
	
	public String editarPaciente() {
		Paciente pacienteActualizado = new Paciente();
		pacienteActualizado.setCodigo(Integer.parseInt(this.getId()));
		pacienteActualizado.setCedula(this.getCedula());
		pacienteActualizado.setNombre(this.getNombre());
		pacienteActualizado.setApellido(this.getApellido());
		pacienteActualizado.setEmail(this.getEmail());
		pacienteActualizado.setClave(this.getClave());
		pacienteActualizado.setFechaNac(this.getFechaNac());
		pacienteActualizado.setSexo(this.getSexo());
		pacienteActualizado.setPreguntaSecreta(this.getPreguntaSecreta());
		this.gpl.actualizar(pacienteActualizado);
		return "crearMedico?faces-redirect=true";
	}
	
	public String eliminar(int codigo) {
		try {
			this.gpl.borrar(codigo);
			System.out.println("Registro eliminado");
			return "crearMedico?faces-redirect=true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error al eliminar");
			e.printStackTrace();			
		}		
		return null;
	}
	
	public void guardarPaciente() {
		
		Paciente paciente = new Paciente();
		paciente.setCodigo(this.gpl.getPacientes().size()+1);
		paciente.setCedula(this.getCedula());
		paciente.setNombre(this.getNombre());
		paciente.setApellido(this.getApellido());
		paciente.setEmail(this.getEmail());
		paciente.setClave(this.getClave());
		paciente.setFechaNac(this.getFechaNac());
		paciente.setSexo(this.getSexo());
		paciente.setRol(this.gpl.obtenerRol(3));
		paciente.setPreguntaSecreta(this.getPreguntaSecreta());
		if(paciente.validarCedula()==true){
			this.validar="";
			if(paciente.validarNombre()==true) {
				this.gpl.insertar(paciente);
				this.validar2="";
			}
			else{
				this.validar2="Nombre Incorrecto";
			}
		}
		else {
			this.validar="Cedula Incorrecta";
			System.out.println("No se registro");
		}
	}
	
	
	
}
