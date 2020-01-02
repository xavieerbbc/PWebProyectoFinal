package vista;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import modelo.Historial;
import negocio.GestionHistorialLocal;


@ManagedBean
public class GestionHistorialBean {
	
	@Inject
	private GestionHistorialLocal gl;
	
	
	/*Beans properties*/
	private int codigo;
	private String observaciones;
	
	private List<Historial> historiales;

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public List<Historial> getHistoriales() {
		return historiales;
	}

	public void setHistoriales(List<Historial> historiales) {
		this.historiales = historiales;
	}
	
	public String guardarHistorial() {
		
		System.out.println(codigo + "  " + observaciones);
		gl.guardarHistorial(codigo, observaciones); 
		
		historiales = gl.getHistoriales();
		
		return "listado-historiales";
	}

}
