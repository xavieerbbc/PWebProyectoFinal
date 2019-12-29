package negocio;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import modelo.Caja;

@Remote
public interface GestionCajaRemote {
	public void guardarCaja(int codigo, Date date, String ingresos, String egresos);
	public List<Caja> getCajas();
	public List<Caja> getCajasPorNombre(String filtro);

}
