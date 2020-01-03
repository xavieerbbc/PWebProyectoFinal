package Modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Direccion {

	@Id
	private int codigo;
	private String calle;
	private String tipo;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		return "Direccion [codigo=" + codigo + ", calle=" + calle + ", tipo=" + tipo + "]";
	}
	
	
}
