package Negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import Datos.PacienteDAO;
import Datos.RolDAO;
import Exception.ExceptionDigitalMedical;
import Exception.MetodosVarios;
import Modelo.Paciente;
import Modelo.Rol;

@Stateless
public class GestionPaciente implements GestionPacienteLocal {

	@Inject
	private PacienteDAO pdao;
	@Inject
	private RolDAO rdao;
	@Inject
	private MetodosVarios mv;

	public void insertar2(Paciente paciente) throws ExceptionDigitalMedical {
		List<Paciente> p = pdao.buscar1Paciente(paciente.getCedula());
		if (p.isEmpty()) {
			if (paciente.getCedula().length() == 10) {
				if (mv.numerico(paciente.getCedula()) == true) {
					if (mv.soloLetras(paciente.getNombre()) == true & mv.soloLetras(paciente.getApellido()) == true) {
						if (mv.soloLetras(paciente.getPreguntaSecreta()) == true) {
							System.out.println("Hasta aqui llego");
							if(paciente.getApellido().length()>1 & paciente.getClave().length() >1 & paciente.getNombre().length()>1 & paciente.getEmail().length()>1 & paciente.getPreguntaSecreta().length()>1) {
								if(mv.soloLetras(paciente.getSexo())==true) {
									pdao.insertar(paciente);
								}else {
									throw new ExceptionDigitalMedical(8);
								}
							
							}else {
								throw new ExceptionDigitalMedical(7);
							}
							
						} else {
							throw new ExceptionDigitalMedical(6);
						}

					} else {
						throw new ExceptionDigitalMedical(4);
					}
				} else {
					throw new ExceptionDigitalMedical(3);
				}

			} else {
				throw new ExceptionDigitalMedical(2);
			}

		} else {
			throw new ExceptionDigitalMedical(1);
		}
	}

	@Override
	public void insertar(Paciente paciente) {
		// TODO Auto-generated method stub
		System.out.println(paciente.toString());
		pdao.insertar(paciente);
	}

	@Override
	public void actualizar(Paciente paciente) {
		// TODO Auto-generated method stub
		pdao.actualizar(paciente);

	}

	@Override
	public void borrar(int codigo) {
		pdao.borrar(codigo);

	}

	@Override
	public Paciente leer(int codigo) {
		// TODO Auto-generated method stub
		return pdao.leer(codigo);

	}

	@Override
	public List<Paciente> getPacientes() {
		// TODO Auto-generated method stub
		return pdao.getPacientes();
	}

	@Override
	public Rol obtenerRol(int codigo) {
		// TODO Auto-generated method stub
		return rdao.leer(codigo);
	}

}
