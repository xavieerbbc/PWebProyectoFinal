package Servicios;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import Modelo.Administrador;
import Negocio.GestionAdministradorLocal;

@WebService
public class AdministradorServiceSoap {
	
	@Inject
	private GestionAdministradorLocal gal;
	
	
	@WebMethod
	public Respuesta crearAdministrador(Administrador admin) {
		Respuesta respuesta = new Respuesta();
		
		try {
			gal.insertar(admin);
			respuesta.setCodigo(2);
			respuesta.setMensaje("ADMIN OK");
		}catch(Exception e) {
			respuesta.setCodigo(999);
			respuesta.setMensaje("ERROR ADMIN");
		}	
		return respuesta;
	}
	
	@WebMethod
	public List<Administrador> listaAdministradores(){
		return this.gal.getAdministradores();
	}
	

}
