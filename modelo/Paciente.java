package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Paciente {

	@Id
	@Column(name="pa_codigo")
	private int codigo;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "pa_historiales")
	private List<Historial> historiales;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "pa_reportes")
	private List<Reporte> reportes;
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	
	public List<Historial> getHistoriales() {
		return historiales;
	}
	public void setHistoriales(List<Historial> historiales) {
		this.historiales = historiales;
	}
	
	
	public List<Reporte> getReportes() {
		return reportes;
	}
	public void setReportes(List<Reporte> reportes) {
		this.reportes = reportes;
	}
	
	
	public void addHistorial(Historial historial) {
		if(historiales==null)
			historiales = new ArrayList<Historial>();
		historiales.add(historial);
	}
	
	public void addReporte(Reporte reporte) {
		if(reportes==null)
			reportes = new ArrayList<Reporte>();
		reportes.add(reporte);
	}
	@Override
	public String toString() {
		return "Paciente [codigo=" + codigo + ", historiales=" + historiales + ", reportes=" + reportes + "]";
	}
	
	
	
	
}
