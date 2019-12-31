package modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Reporte {

	@Id
	@Column(name="re_codigo")
	private int codigo;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "re_caja")
	private List<Caja> cajas;
	
	@Column(name="re_libro")
	private String libroDiario;
	
	@Column(name="re_balances")
	private String balances;
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getLibroDiario() {
		return libroDiario;
	}
	public void setLibroDiario(String libroDiario) {
		this.libroDiario = libroDiario;
	}
	public String getBalances() {
		return balances;
	}
	public void setBalances(String balances) {
		this.balances = balances;
	}
	
	
	public List<Caja> getCajas() {
		return cajas;
	}
	public void setCajas(List<Caja> cajas) {
		this.cajas = cajas;
	}
	public void addCaja(Caja caja) {
		if(cajas==null)
			cajas = new ArrayList<Caja>();
		cajas.add(caja);
	}
	
	@Override
	public String toString() {
		return "Reportes [codigo=" + codigo + ", libroDiario=" + libroDiario + ", balances=" + balances + "]";
	}
	
	
}
