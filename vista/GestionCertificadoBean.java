package vista;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import modelo.Certificado;
import modelo.CitaMedica;
import modelo.Medico;
import modelo.Paciente;
import negocio.GestionCertificado;
import negocio.GestionCitaMedica;

@ManagedBean
@SessionScoped
public class GestionCertificadoBean {
	
private Certificado certificado=new Certificado();
	
	@Inject
	private GestionCertificado gp;
	private List<Certificado> certificados;
	
	@PostConstruct
	public void init() {
		certificado = new Certificado();
		certificado.addMedico(new Medico());
		
		certificados = gp.getCertificados();
	
	}

	public Certificado getCertificado() {
		return certificado;
	}

	public void setCertificado(Certificado certificado) {
		this.certificado = certificado;
	}

	public List<Certificado> getCertificados() {
		return certificados;
	}

	public void setCertificados(List<Certificado> certificados) {
		this.certificados = certificados;
	}
	
	public String guardar() {
		System.out.println(certificado);
		gp.guardar(certificado);
		init();
		return null;
	}
	
	public String addMedico() {
		certificado.addMedico(new Medico());
		return null;
	}
}
