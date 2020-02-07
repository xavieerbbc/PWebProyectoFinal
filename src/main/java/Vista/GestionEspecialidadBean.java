package Vista;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import Modelo.Especialidad;
import Negocio.GestionEspecialidadLocal;

@ManagedBean
@ViewScoped
public class GestionEspecialidadBean {
	
	@Inject
	private GestionEspecialidadLocal gel;
	
	private List<Especialidad> especialidades;
	
	private String id;
	private String nombre;
	private String descripcion;
	
	@PostConstruct
	public void init() {
		this.especialidades=this.gel.getEspecialidades();
	}
	
	
	public GestionEspecialidadLocal getGel() {
		return gel;
	}


	public void setGel(GestionEspecialidadLocal gel) {
		this.gel = gel;
	}


	public List<Especialidad> getEspecialidades() {
		return especialidades;
	}


	public void setEspecialidades(List<Especialidad> especialidades) {
		this.especialidades = especialidades;
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
		Especialidad especialidad = new Especialidad();
		if(this.gel.getEspecialidades().size()==0) {
			especialidad.setCodigo(this.gel.getEspecialidades().size()+1);
		}else {
			especialidad.setCodigo(this.gel.getEspecialidades().get(this.gel.getEspecialidades().size()-1).getCodigo()+1);
		}
		especialidad.setNombre(this.getNombre());
		especialidad.setDescripcion(this.getDescripcion());
		System.out.println(especialidad.toString());
		this.gel.insertar(especialidad);
		return "PaginaListarEspecialidades?faces-redirect=true";
	}
	
	public String eliminar(int codigo) {
		
		try {
			this.gel.borrar(codigo);
			System.out.println("Especialidad eliminada");
			return "PaginaListarEspecialidades?faces-redirect=true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error al eliminar");
			e.printStackTrace();			
		}		
		return null;
	}
	
	public String editar(Especialidad especialidad) {
		return "PaginaEditarEspecialidad?faces-redirect=true&id="+especialidad.getCodigo();
	}
	
	public void loadData() {
		Especialidad especialidad=this.gel.leer(Integer.parseInt(id));
		this.setNombre(especialidad.getNombre());
		this.setDescripcion(especialidad.getDescripcion());
	}
	
	public String editarEspecialidad() {
		Especialidad actualizada=new Especialidad();
		actualizada.setCodigo(Integer.parseInt(this.getId()));
		actualizada.setNombre(this.getNombre());
		actualizada.setDescripcion(this.getDescripcion());
		this.gel.actualizar(actualizada);
		return "PaginaListarEspecialidades?faces-redirect=true";
	}

}
