package cursos.jpa.controladores.menu;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import cursos.jpa.entidades.menu.Rol;
import cursos.jpa.servicios.menu.RolServicio;



@ManagedBean
public class RolControlador {

	private Rol rol;
	
	@EJB
	private RolServicio rolServicio;
	
	public RolControlador(){
		rol=new Rol();
	}
	
	public void insertar(){
		rolServicio.insertar(rol);
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
}
