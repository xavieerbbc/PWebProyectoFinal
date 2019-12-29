package negocio;

import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import datos.CajaDAO;
import datos.UsuarioDAO;
import modelo.Caja;
import modelo.Usuario;

@Stateless
public class GestionCaja  implements GestionCajaLocal, GestionCajaRemote { 
	
	@Inject
	private CajaDAO dao;
	
	
	public void guardarCaja(int codigo, Date fecha, String ingresos, String egresos){
		Caja c = new Caja();  
		c.setCodigo(codigo);
		c.setFecha(fecha);
		c.setIngresos(ingresos);
		c.setEgresos(egresos);
		
		System.out.println(c);
		dao.insert(c);
	}
	
	public List<Caja> getCajas(){
		
		return dao.getCajas();
	}
	
	public List<Caja> getCajasPorNombre(String filtro){
		
		return dao.getCajaXNombre(filtro);
	}
	

}
