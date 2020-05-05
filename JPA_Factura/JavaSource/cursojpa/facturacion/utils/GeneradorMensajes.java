package cursojpa.facturacion.utils;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public class GeneradorMensajes {

	
	private static void mostrar(String mensaje, Severity severidad){
		FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(severidad,mensaje,mensaje));		
	}
	public static void mostrarInfo(String mensaje){
		mostrar(mensaje,FacesMessage.SEVERITY_INFO);
	}
	public static void mostrarError(String mensaje){
		mostrar(mensaje,FacesMessage.SEVERITY_ERROR);
	}
	public static void mostrarWarning(String mensaje){
		mostrar(mensaje,FacesMessage.SEVERITY_WARN);
	}
}
