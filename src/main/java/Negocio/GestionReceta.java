package Negocio;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import Datos.RecetaDAO;
import Modelo.Medico;
import Modelo.Receta;

@Stateless
public class GestionReceta implements GestionRecetaLocal {
	
	@Inject
	private RecetaDAO rdao;

	@Override
	public void insertar(Receta receta) {
		// TODO Auto-generated method stub
		this.rdao.insertar(receta);
	}

	@Override
	public void actualizar(Receta receta) {
		// TODO Auto-generated method stub
		this.rdao.actualizar(receta);
		
	}

	@Override
	public void borrar(int codigo) {
		// TODO Auto-generated method stub
		this.rdao.borrar(codigo);
		
	}

	@Override
	public Receta leer(int codigo) {
		// TODO Auto-generated method stub
		return this.rdao.leer(codigo);
	}

	@Override
	public List<Receta> getRecetas() {
		// TODO Auto-generated method stub
		return this.rdao.getRecetas();
	}

	@Override
	public List<Receta> obtenerRecetasMedico(Medico medico) {
		// TODO Auto-generated method stub
		return this.rdao.obtenerRecetasMedico(medico);
	}

}
