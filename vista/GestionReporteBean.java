package vista;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import modelo.Caja;
import modelo.Reporte;
import negocio.GestionReporte;



@ManagedBean
@SessionScoped
public class GestionReporteBean {
	
	private Reporte reporte = new Reporte();
	
	@Inject
	private GestionReporte gp;
	
	private List<Reporte> reportes;
	
	@PostConstruct
	public void init() {
		reporte = new Reporte();
		reporte.addCaja(new Caja());
		
		reportes = gp.getReportes();
	
	}

	public Reporte getReporte() {
		return reporte;
	}

	public void setReporte(Reporte reporte) {
		this.reporte = reporte;
	}

	public List<Reporte> getReportes() {
		return reportes;
	}

	public void setReportes(List<Reporte> reportes) {
		this.reportes = reportes;
	}
	
	public String guardar() {
		System.out.println(reporte);
		gp.guardar(reporte);
		init();
		return null;
	}
	
	public String addCaja() {
		reporte.addCaja(new Caja());
		return null;
	}

}
