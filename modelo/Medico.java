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
public class Medico {
	
	@Id
	@Column(name="me_codigo")
	private int codigo;
	
	@Column(name="me_area")
	private String area;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "me_reportes")
	private List<Reporte> reportes;
	
	
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
	public void addReporte(Reporte reporte) {
		if(reportes==null)
			reportes = new ArrayList<Reporte>();
		reportes.add(reporte);
	}
	@Override
	public String toString() {
		return "Medico [codigo=" + codigo + ", area=" + area + ", reportes=" + reportes + "]";
	}
	
	
	

}
