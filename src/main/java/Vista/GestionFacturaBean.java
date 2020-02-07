package Vista;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import Negocio.GestionMedicoLocal;
import Negocio.GestionPacienteLocal;

@ManagedBean
@ViewScoped
public class GestionFacturaBean {

	@Inject
	private GestionPacienteLocal gpl;
	
	@Inject
	private GestionMedicoLocal gmel;
}
