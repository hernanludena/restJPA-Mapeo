package cursos.jpa.controladores.menu;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import cursos.jpa.entidades.menu.MenuCobis;
import cursos.jpa.servicios.menu.MenuCobisServicio;


@ManagedBean
public class MenuControladorCobis {

	private MenuCobis menu;
	private int idPadre;
	
	@EJB
	private MenuCobisServicio menuServicio;
	
	public MenuControladorCobis(){
		menu=new MenuCobis();
	}
	
	public void insertarRoot(){
		//sin padre
		menu.setVisible(true);
		menuServicio.insertar(menu);
	}
	
	public void insertarMenu(){
		MenuCobis menuPadre = menuServicio.buscar(idPadre);
		menu.setMenuPadre(menuPadre);
		menu.setVisible(false);
		menuServicio.insertar(menu);
	}

	public MenuCobis getMenu() {
		return menu;
	}

	public void setMenu(MenuCobis menu) {
		this.menu = menu;
	}

	public int getIdPadre() {
		return idPadre;
	}

	public void setIdPadre(int idPadre) {
		this.idPadre = idPadre;
	}
	
	
}
