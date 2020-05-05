package cursos.jpa.controladores.menu;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import cursos.jpa.entidades.Menu;
import cursos.jpa.entidades.menu.MenuCobis;
import cursos.jpa.entidades.menu.Rol;
import cursos.jpa.servicios.menu.MenuCobisServicio;
import cursos.jpa.servicios.menu.MenuRolServicio;
import cursos.jpa.servicios.menu.RolServicio;



@ManagedBean
public class MenuRolControlador {

	private int idMenu;
	private int idRol;
	private int idRolBusqueda;

	@EJB
	private MenuCobisServicio menuServicio;

	@EJB
	private RolServicio rolServicio;

	@EJB
	private MenuRolServicio menuRolServicio;

	public void asignar() {
		MenuCobis menu = menuServicio.buscar(idMenu);  //objetos fuera de contexto, al tratar de insertar daran error
		Rol rol = rolServicio.buscar(idRol);           //debido a que no estan manejados por el EM
		menuRolServicio.asignar(menu, rol);           //para que sean manejos por el EM, la busqueda de estos objetos
		                                              //debe hacerse en la capa de Servicio.
	}

	public void buscar() {
		List<MenuCobis> list = menuRolServicio.buscar(idRol);
		System.out.println(list);
	}

	public int getIdMenu() {
		return idMenu;
	}

	public void setIdMenu(int idMenu) {
		this.idMenu = idMenu;
	}

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

	public int getIdRolBusqueda() {
		return idRolBusqueda;
	}

	public void setIdRolBusqueda(int idRolBusqueda) {
		this.idRolBusqueda = idRolBusqueda;
	}

}
