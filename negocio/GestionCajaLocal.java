package negocio;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import modelo.Caja;


@Local
public interface GestionCajaLocal {
	
	public void guardarCaja(int codigo, Date date, String ingresos, String egresos);
	public List<Caja> getCajas();
	public List<Caja> getCajasPorNombre(String filtro);

}
