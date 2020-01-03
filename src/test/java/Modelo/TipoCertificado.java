package Modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TipoCertificado {

	@Id
	private int codigo;
	private String nombre;
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "TipoCertificado [codigo=" + codigo + ", nombre=" + nombre + "]";
	}
}
