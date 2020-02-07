package Vista;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.annotation.ManagedProperty;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import Modelo.Cita;
import Modelo.Medico;
import Modelo.Paciente;
import Negocio.GestionCitaLocal;

@ManagedBean
@ViewScoped
public class GestionIndexMedicoBean {
	
	@Inject
	private GestionCitaLocal gcl;
	
	
	private List<Cita> citas;
	
	@PostConstruct
	public void init() {
		this.citas= new ArrayList<Cita>();
	}

	public GestionCitaLocal getGcl() {
		return gcl;
	}

	public void setGcl(GestionCitaLocal gcl) {
		this.gcl = gcl;
	}

	public List<Cita> getCitas() {
		return citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}
	
	public String agendarCita(Cita cita) {
		cita.setEstado("Agendada");
		this.gcl.actualizar(cita);
		return "PaginaListarCitasMedico?faces-redirect=true";
	}
	
	public String rechazarCita(Cita cita) {
		cita.setEstado("Rechazada");
		this.gcl.actualizar(cita);
		return "PaginaListarCitasMedico?faces-redirect=true";
	}
	
	public List<Cita> obtenerCitasPendientes(Medico medico){
		return this.gcl.obtenerCitasPendientes(medico);
	}
	
	public List<Cita> obtenerCitasAgendadas(Medico medico){
		return this.gcl.obtenerCitasAgendadas(medico);
	}

}
