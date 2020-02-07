package Exception;

public class ExceptionDigitalMedical extends Exception{

	private int codigo;
	private String mensaje;
	
	public ExceptionDigitalMedical(int id, String arg0) {
		super(arg0);
	}

	
	public ExceptionDigitalMedical(int id) {
		String arg0="";
		this.setCodigo(id);
		if(id==1) {
			this.setMensaje("La cedula ya ha sido registrada");
		}else if(id==2){
			this.setMensaje("La cedula debe tener 10 digitos");
		}else if(id==3) {
			this.setMensaje("La cedula debe ser numerica");
		}else if(id==4) {
			this.setMensaje("El nombre y el apellido deben contener solo letras");
		}else if(id==5) {
			this.setMensaje("Las contraseñas deben ser iguales");
		}else if(id==6) {
			this.setMensaje("La pregunta secreta debe contener solo letras");
		}else if(id==7) {
			this.setMensaje("No puede dejar campos vacios");
		}else if(id==8) {
			this.setMensaje("El sexo no puede contener numeros");
		}
	}
	


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getMensaje() {
		return mensaje;
	}


	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	
}
