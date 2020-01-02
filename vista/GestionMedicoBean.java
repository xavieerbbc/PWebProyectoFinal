package vista;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import modelo.Caja;
import modelo.Medico;
import modelo.Reporte;
import negocio.GestionMedico;
import negocio.GestionMedicoLocal;
import negocio.GestionReporte;

@ManagedBean
@SessionScoped
public class GestionMedicoBean {
	
	private Medico medico = new Medico();
	@Inject
	private GestionMedico gp;
	//@Inject
	//private GestionMedicoLocal gm;
	
	private int codigo;
	private String area;
	
	
	private List<Medico> medicos;
	private List<Reporte> reportes;
	
	@PostConstruct
	public void init() {
		medico = new Medico();
		medico.addReporte(new Reporte());
		
		medicos = gp.getMedicos();
	
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public List<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}

	public String guardar() {
		System.out.println(medico);
		gp.guardar(medico);
		init();
		return null;
	}
	
	public String addReporte() {
		medico.addReporte(new Reporte());
		return null;
	}


	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public List<Reporte> getReportes() {
		return reportes;
	}

	public void setReportes(List<Reporte> reportes) {
		this.reportes = reportes;
	}

	public GestionMedico getGp() {
		return gp;
	}

	public void setGp(GestionMedico gp) {
		this.gp = gp;
	}

	

	
	

}
