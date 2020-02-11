package Exception;

public class ExcepcionesRegistro extends Exception{

	private int codigo;
	private String mensaje;
	
	public ExcepcionesRegistro(int id, String arg0) {
		super(arg0);
	}

	
	public ExcepcionesRegistro(int id) {
		String arg0="";
		this.setCodigo(id);
		if(id==1) {
			this.setMensaje("Cedula existente");
		}else if(id==2){
			this.setMensaje("Longitud de cedula mal ingresada");
		}else if(id==3) {
			this.setMensaje("Erro de cedula");
		}else if(id==4) {
			this.setMensaje("Nombre y apellido mal ingresados");
		}else if(id==5) {
			this.setMensaje("Contraseñas incorrectas");
		}else if(id==6) {
			this.setMensaje(",");
		}else if(id==7) {
			this.setMensaje("Existen campos vacios");
		}else if(id==8) {
			this.setMensaje("Ingresar genero");
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
