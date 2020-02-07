package Modelo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Medicina {

	@Id
	private int codigo;
	
	private String nombre;
	private String descripcion;
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
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	@Override
	public String toString() {
		return "Medicina [codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}	
	
}
