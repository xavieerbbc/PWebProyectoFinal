package negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.CertificadoDAO;
import datos.MedicoDAO;
import modelo.Certificado;
import modelo.Medico;

@Stateless
public class GestionCertificado {
	
	@Inject
	private CertificadoDAO dao;
	
	public void guardar(Certificado certificado) {
		if(dao.read(certificado.getCodigo())==null)
			dao.insert(certificado);
		else
			dao.update(certificado);	
		
	}
	
	public List<Certificado> getCertificados(){
		return dao.getCertificados();
	}
	
	public List<Certificado> getCertificdoPorNombre(String filtro){
		
		return dao.getCertificadoXNombre(filtro);
	}


}
