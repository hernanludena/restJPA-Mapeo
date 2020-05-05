package cursos.jpa.entidades.menu;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import cursos.jpa.entidades.Menu;

@Entity
@Table(name = "cew_menu")
public class MenuCobis {
	
	@Id
	@Column(name = "me_id")
	private int id;	
	
	//@Column(name = "nombre")  //No es necesario colocar el column, mapea automaticamete, si los nombres on iguales
	private String nombre;
	
	//@Column(name = "visible")
	private boolean visible;
	
	//@Column(name = "url")
	private String url;
	
	@Transient    //para que no mapee contra la base.
	private int estado;   
	//si no existe esta columna dara error en la base.
	
	//private List<MenuRol> menuRol; Es aconsejable mapear en una direccion. No bidireccional
	
	
	//Relacion con tabla recursiva
	@ManyToOne
	@JoinColumn(name = "me_id_padre")
	private MenuCobis menuPadre;
	
	@OneToMany(mappedBy = "menuPadre")
	private List<MenuCobis> listMenuCobis;		
	
	
	
		
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
		
	
	public MenuCobis getMenuCobis() {
		return menuPadre;
	}
	public void setMenuCobis(MenuCobis menuCobis) {
		this.menuPadre = menuCobis;
	}
	public List<MenuCobis> getListMenuCobis() {
		return listMenuCobis;
	}
	public void setListMenuCobis(List<MenuCobis> listMenuCobis) {
		this.listMenuCobis = listMenuCobis;
	}
	
	
	public MenuCobis getMenuPadre() {
		return menuPadre;
	}
	public void setMenuPadre(MenuCobis menuPadre) {
		this.menuPadre = menuPadre;
	}
	
	
	public int getEstado() {
		return estado;
	}
	public void setEstado(int estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "MenuCobis [id=" + id + ", nombre=" + nombre + ", visible="+ visible+"]";
	}
	  
	  
	  

}
