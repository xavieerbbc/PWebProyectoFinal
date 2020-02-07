package Vista;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Stack;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import Modelo.Especialidad;
import Modelo.Medico;
import Modelo.Receta;
import Negocio.GestionEspecialidadLocal;
import Negocio.GestionMedicoLocal;
import Negocio.GestionRolLocal;

@ManagedBean
@ViewScoped
public class GestionMedicoBean {
	
	@Inject
	private GestionMedicoLocal gml;
	
	@Inject
	private GestionRolLocal grl;
	
	@Inject
	private GestionEspecialidadLocal gel;
	
	private String id;
	
	private List<Medico> medicos;
	private List<Especialidad> especialidades;
	private List<Especialidad> especialidadesEditar;
	
	private String cedula;
	private String nombre;
	private String apellido;
	private String email;
	private String clave;
	private Date fechaNac;
	private Especialidad especialidad;
	
	@PostConstruct
	public void init() {
		this.medicos = gml.getMedicos();
		this.especialidades = gel.getEspecialidades();
		this.especialidadesEditar=new ArrayList<Especialidad>();
	}
	public String getId() {
		return id;
	}




	public void setId(String id) {
		this.id = id;
	}




	public GestionRolLocal getGrl() {
		return grl;
	}


	public void setGrl(GestionRolLocal grl) {
		this.grl = grl;
	}


	public List<Medico> getMedicos() {
		return medicos;
	}


	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}


	public GestionMedicoLocal getGml() {
		return gml;
	}
	public void setGml(GestionMedicoLocal gml) {
		this.gml = gml;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public Date getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
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
	public Especialidad getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}
	public List<Especialidad> getEspecialidadesEditar() {
		return especialidadesEditar;
	}
	public void setEspecialidadesEditar(List<Especialidad> especialidadesEditar) {
		this.especialidadesEditar = especialidadesEditar;
	}
	public String guardarMedico() {
		Medico medico = new Medico();
		if(this.gml.getMedicos().size()==0) {
			medico.setCodigo(this.gml.getMedicos().size()+1);
		}else {
			medico.setCodigo(this.gml.getMedicos().get(this.gml.getMedicos().size()-1).getCodigo()+1);
		}
		medico.setCedula(this.getCedula());
		medico.setNombre(this.getNombre());
		medico.setApellido(this.getApellido());
		medico.setEmail(this.getEmail());
		medico.setClave(this.getClave());
		medico.setFechaNac(this.getFechaNac());
		medico.setRol(this.grl.leer(2));
		medico.setEspecialidad(this.getEspecialidad());
		this.gml.insertar(medico);
		return "PaginaListarMedicos?faces-redirect=true";
	}
	
	public String eliminar(int codigo) {
		
		try {
			this.gml.borrar(codigo);
			System.out.println("Registro eliminado");
			return "PaginaListarMedicos?faces-redirect=true";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Error al eliminar");
			e.printStackTrace();			
		}		
		return null;
	}
	
	public String editar(Medico medico) {
		
		return "PaginaEditarMedico?faces-redirect=true&id="+medico.getCodigo();
	}
	
	public String MedicoPorEspecialidad(Especialidad medico) {
		return "ListarEspecialidadMedico?faces-redirect=true&id="+medico.getCodigo();
	}
	
	public void loadMedico() {
		System.out.println("load data " + id);
		if(id==null)
			return;
		List<Medico> aux = gml.getMedicoPorEspecialidad(Integer.parseInt(id));
		this.medicos=aux;
		
	}
	
	public void loadData() {
		Medico aux = gml.leer(Integer.parseInt(id));
		this.setCedula(aux.getCedula());
		this.setNombre(aux.getNombre());
		this.setApellido(aux.getApellido());
		this.setEmail(aux.getEmail());
		this.setClave(aux.getClave());
		this.setFechaNac(aux.getFechaNac());
		List<Especialidad> secundaria=this.getEspecialidades();
		Especialidad indice=secundaria.get(aux.getEspecialidad().getCodigo()-1);
		secundaria.remove(indice.getCodigo()-1);
		this.especialidadesEditar.add(indice);
		for(int i=0;i<secundaria.size();i++) {
			this.especialidadesEditar.add(secundaria.get(i));
		}
		this.setEspecialidad(aux.getEspecialidad());
	}
	
	public String editarMedico() {
		Medico medicoActualizado = new Medico();
		medicoActualizado.setCodigo(Integer.parseInt(this.getId()));
		medicoActualizado.setCedula(this.getCedula());
		medicoActualizado.setNombre(this.getNombre());
		medicoActualizado.setApellido(this.getApellido());
		medicoActualizado.setEmail(this.getEmail());
		medicoActualizado.setClave(this.getClave());
		medicoActualizado.setFechaNac(this.getFechaNac());
		medicoActualizado.setEspecialidad(this.especialidad);
		System.out.println(medicoActualizado.toString());
		this.gml.actualizar(medicoActualizado);
		return "PaginaListarMedicos?faces-redirect=true";
	}
	
	
	
}
