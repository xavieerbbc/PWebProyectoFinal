package modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Caja {
	
	@Id
	@Column(name="caja_codigo")
	private int codigo;
	
	@Column(name="caja_fecha")
	private Date fecha;
	
	@Column(name="caja_ingresos")
	private String ingresos;
	
	@Column(name="caja_egresos")
	private String egresos;
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getIngresos() {
		return ingresos;
	}
	public void setIngresos(String ingresos) {
		this.ingresos = ingresos;
	}
	public String getEgresos() {
		return egresos;
	}
	public void setEgresos(String egresos) {
		this.egresos = egresos;
	}
	@Override
	public String toString() {
		return "Caja [codigo=" + codigo + ", fecha=" + fecha + ", ingresos=" + ingresos + ", egresos=" + egresos + "]";
	}

	
}
