package Modelo;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Paciente {

	@Id
	private int codigo;
	private String cedula;
	private String nombre;
	private String apellido;
	private String email;
	private String clave;
	private String preguntaSecreta;
	
	
	@OneToOne
	private Rol rol;
	
	@Temporal(TemporalType.DATE)
	private Date fechaNac;
	
	private String sexo;
	
	@OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
	@JoinColumn(name = "telefono", referencedColumnName = "codigo")
	private Set<Telefono> telefonos;
	
	@OneToMany(cascade = {CascadeType.ALL},fetch = FetchType.EAGER)
	@JoinColumn(name = "direccion", referencedColumnName = "codigo")
	private Set<Direccion> direcciones;
	
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	public Date getFechaNac() {
		return fechaNac;
	}
	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public Set<Telefono> getTelefonos() {
		return telefonos;
	}
	public void setTelefonos(Set<Telefono> telefonos) {
		this.telefonos = telefonos;
	}
	public Set<Direccion> getDirecciones() {
		return direcciones;
	}
	public void setDirecciones(Set<Direccion> direcciones) {
		this.direcciones = direcciones;
	}
	public String getPreguntaSecreta() {
		return preguntaSecreta;
	}
	public void setPreguntaSecreta(String preguntaSecreta) {
		this.preguntaSecreta = preguntaSecreta;
	}
	
	@Override
	public String toString() {
		return "Paciente [codigo=" + codigo + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", email=" + email + ", clave=" + clave + ", preguntaSecreta=" + preguntaSecreta + ", rol=" + rol
				+ ", fechaNac=" + fechaNac + ", sexo=" + sexo + ", telefonos=" + telefonos + ", direcciones="
				+ direcciones + "]";
	}
	
	public boolean validarCedula() {
		if(this.cedula.length()==10) {
			try {
				Integer.parseInt(this.cedula);
				return true;
			}
			catch(NumberFormatException ex){
				return false;
			}
		}
		else{;
			return false;
 		}
	}
	public boolean validarNombre() {
		for (int i = 0; i < this.nombre.length(); i++)
		{
			char caracter = this.nombre.toUpperCase().charAt(i);
			int valorASCII = (int)caracter;
			if (valorASCII != 165 && (valorASCII < 65 || valorASCII > 90))
				return false; //Se ha encontrado un caracter que no es letra
		}
		return true;
	}
	public boolean validarApellido() {
		for (int i = 0; i < this.apellido.length(); i++)
		{
			char caracter = this.apellido.toUpperCase().charAt(i);
			int valorASCII = (int)caracter;
			if (valorASCII != 165 && (valorASCII < 65 || valorASCII > 90))
				return false; //Se ha encontrado un caracter que no es letra
		}
		return true;
	}
	
	
	
	
	
	
	
	
}
