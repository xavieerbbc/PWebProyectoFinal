package Vista;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import Modelo.Medico;
import Modelo.Paciente;
import Modelo.Historial;
import Negocio.GestionMedicoLocal;
import Negocio.GestionPacienteLocal;
import Negocio.GestionHistorialLocal;

@ManagedBean
@ViewScoped
public class GestionHistorialBean {
	
	@Inject
	private GestionHistorialLocal ghl;
	
	@Inject
	private GestionPacienteLocal gpl;
	
	
	@Inject
	private GestionMedicoLocal gmel;
	
	
	private String id;
	
	private Historial historial;
	private List<Historial> historiales;
	
	private List<Paciente> pacientes;
	
	
	@PostConstruct
	public void init() {
		this.historial =  new Historial();
		this.historiales = this.ghl.getHistoriales();
		this.pacientes = this.gpl.getPacientes();
		
	}
	





	public GestionHistorialLocal getGhl() {
		return ghl;
	}




	public void setGhl(GestionHistorialLocal ghl) {
		this.ghl = ghl;
	}




	public GestionPacienteLocal getGpl() {
		return gpl;
	}




	public void setGpl(GestionPacienteLocal gpl) {
		this.gpl = gpl;
	}




	public GestionMedicoLocal getGmel() {
		return gmel;
	}




	public void setGmel(GestionMedicoLocal gmel) {
		this.gmel = gmel;
	}




	public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}




	public Historial getHistorial() {
		return historial;
	}




	public void setHistorial(Historial historial) {
		this.historial = historial;
	}




	public List<Historial> getHistoriales() {
		return historiales;
	}




	public void setHistoriales(List<Historial> historiales) {
		this.historiales = historiales;
	}




	public List<Paciente> getPacientes() {
		return pacientes;
	}




	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}




	public String guardar(String email) {
		Date fecha = new Date();
		this.historial.setCodigo(this.ghl.getHistoriales().size()+1);
		this.historial.setMedico(this.gmel.buscarMedicoxEmail(email));
		this.historial.setFecha(fecha);
		System.out.println(historial.toString());
		this.ghl.insertar(historial);
		return "PaginaListarHistorialesMedico?faces-redirect=true";
	}
	
	
	
	
	public List<Historial> obtenerHistorialesMedico(Medico medico){
		return this.ghl.obteneHistorialesMedico(medico);
	}
	
	public String eliminar(int codigo) {
		
		try {
			this.ghl.borrar(codigo);
			System.out.println("Historial eliminado");
			return "PaginaListarHistorialesMedico?faces-redirect=true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error al eliminar");
			e.printStackTrace();			
		}		
		return null;
	}
	
	public String editarHistorial() {
		this.ghl.actualizar(this.historial);
		return "PaginaListarHistorialesMedico?faces-redirect=true";
	}
	
	public String editar(Historial h) {
		return "editarHistorialesMedico?faces-redirect=true&id="+h.getCodigo();
	}
	
	public void loadData() {
		System.out.println("load data " + id);
		if(id==null)
			return;
		this.historial = this.ghl.leer(Integer.parseInt(id));
	}
	
	

}
