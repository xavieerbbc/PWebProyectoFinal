package vista;



import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import modelo.CitaMedica;
import modelo.Medico;
import modelo.Paciente;
import modelo.Reporte;
import negocio.GestionCitaMedica;

@ManagedBean
@SessionScoped
public class GestionCitaMedicaBean {
	
	private CitaMedica citaMedica=new CitaMedica();
	
	@Inject
	private GestionCitaMedica gp;
	private List<CitaMedica> citaMedicas;
	
	@PostConstruct
	public void init() {
		citaMedica = new CitaMedica();
		citaMedica.addPaciente(new Paciente());
		
		citaMedicas = gp.getCitasMedicas();
	
	}
	
	
	public CitaMedica getCitaMedica() {
		return citaMedica;
	}


	public void setCitaMedica(CitaMedica citaMedica) {
		this.citaMedica = citaMedica;
	}


	public List<CitaMedica> getCitaMedicas() {
		return citaMedicas;
	}


	public void setCitaMedicas(List<CitaMedica> citaMedicas) {
		this.citaMedicas = citaMedicas;
	}


	public String guardar() {
		System.out.println(citaMedica);
		gp.guardar(citaMedica);
		init();
		return null;
	}
	
	public String addPaciente() {
		citaMedica.addPaciente(new Paciente());
		return null;
	}

}
