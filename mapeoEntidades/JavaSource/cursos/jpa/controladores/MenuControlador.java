package cursos.jpa.controladores;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import curso.jpa.servicios.EmpleadoServicio;
import curso.jpa.servicios.MenuServicio;
import cursos.jpa.entidades.Menu;



@ManagedBean
public class MenuControlador {
	
	private Menu menu;
	
	private int idPadre;
	
	//TODO:REFERENCIAR AL SERVICIO CON INYECCION DE CODIGO
	
	@EJB
	private MenuServicio menuServicio;
	
	public MenuControlador(){
		menu=new Menu();
	}
	
	public void insertarRoot(){
		menuServicio.insertar(menu);

	}
	
	public void insertarMenu(){
		Menu menuPadre= new Menu();
		menuPadre.setId(idPadre);
		menu.setMenuPadre(menuPadre);
		menuServicio.insertar(menu);				
	}
	
	public void insertarMenu2(){
		Menu menuPadre = menuServicio.buscarPorId(idPadre);
		menu.setMenuPadre(menuPadre);
		menuServicio.insertar(menu);
	}
	
	
	public void buscarNivelRoot(){
		List<Menu> padres = menuServicio.recuperarTodos2();
		System.out.println(padres);
		
		Menu padre1 = padres.get(0);
		System.out.println(padre1.getMenuHijo().size());  //si se intenta traer una lista, error de LAZY; debe hacerlo desde el manager
	}
	

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public int getIdPadre() {
		return idPadre;
	}

	public void setIdPadre(int idPadre) {
		this.idPadre = idPadre;
	}
	
	
}
