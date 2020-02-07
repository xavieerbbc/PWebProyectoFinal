package Vista;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import Modelo.Medicina;
import Negocio.GestionMedicinaLocal;

@ManagedBean
@ViewScoped
public class GestionMedicinasBean {
	
	@Inject
	private GestionMedicinaLocal gml;
	
	private List<Medicina> medicinas;
	
	private String id;
	private String nombre;
	private String descripcion;
	
	@PostConstruct
	public void init() {
		this.medicinas=this.gml.getMedicinas();
	}
	
	
	public GestionMedicinaLocal getGml() {
		return gml;
	}
	public void setGml(GestionMedicinaLocal gml) {
		this.gml = gml;
	}
	public List<Medicina> getMedicinas() {
		return medicinas;
	}
	public void setMedicinas(List<Medicina> medicinas) {
		this.medicinas = medicinas;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}


	public String guardar() {
		Medicina medicina = new Medicina();
		if(this.gml.getMedicinas().size()==0) {
			medicina.setCodigo(this.gml.getMedicinas().size()+1);
		}else {
			medicina.setCodigo(this.gml.getMedicinas().get(this.gml.getMedicinas().size()-1).getCodigo()+1);
		}
		medicina.setNombre(this.getNombre());
		medicina.setDescripcion(this.getDescripcion());
		System.out.println(medicina.toString());
		this.gml.insertar(medicina);
		return "PaginaListarMedicamentos?faces-redirect=true";
	}
	
	public String eliminar(int codigo) {
		
		try {
			this.gml.borrar(codigo);
			System.out.println("Medicina eliminado");
			return "PaginaListarMedicamentos?faces-redirect=true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error al eliminar");
			e.printStackTrace();			
		}		
		return null;
	}
	
	public String editar(Medicina medicina) {
		return "PaginaEditarMedicamento?faces-redirect=true&id="+medicina.getCodigo();
	}
	
	public void loadData() {
		Medicina medicina=this.gml.leer(Integer.parseInt(id));
		this.setNombre(medicina.getNombre());
		this.setDescripcion(medicina.getDescripcion());
		
	}
	
	public String editarMedicina() {
		Medicina actualizada=new Medicina();
		actualizada.setCodigo(Integer.parseInt(this.getId()));
		actualizada.setNombre(this.getNombre());
		actualizada.setDescripcion(this.getDescripcion());
		this.gml.actualizar(actualizada);
		return "PaginaListarMedicamentos?faces-redirect=true";
	}

}
