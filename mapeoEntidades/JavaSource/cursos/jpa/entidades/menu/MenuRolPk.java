package cursos.jpa.entidades.menu;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


public class MenuRolPk implements Serializable{	
	//Clave primaria compuesta - debe implementar Serializable
	
	@Id
	@ManyToOne
	@JoinColumn(name = "mro_id_menu")
	private MenuCobis menuCobis;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "mro_id_rol")
	private Rol rol;
	
	
	public MenuCobis getMenuCobis() {
		return menuCobis;
	}
	public void setMenuCobis(MenuCobis menuCobis) {
		this.menuCobis = menuCobis;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	
	
}
