package Negocio;

import java.util.List;

import javax.ejb.Local;

import Modelo.Medico;
import Modelo.Receta;

@Local
public interface GestionRecetaLocal {

	public void insertar(Receta receta);
	public void actualizar(Receta receta);
	public void borrar(int codigo);
	public Receta leer(int codigo);
	public List<Receta> getRecetas();
	public List<Receta> obtenerRecetasMedico(Medico medico);
}