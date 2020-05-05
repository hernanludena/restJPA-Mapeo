package cursos.jpa.entidades.menu;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cew_menu_rol")
@IdClass(value= MenuRolPk.class)  //indicamos la clave primaria compuesta
public class MenuRol implements Serializable{	
		
	
	//Relacion con tabla de rompimiento	
	@Id	
	private MenuCobis menuCobis;
	
	@Id  //el mapeo de relaciones para la clase con la clave compuesta. (MenuRolPk)	
	private Rol rol;
	
	@Column(name = "fecha_asignacion")
	private Date fecha_asignacion;
	
	public Date getFecha_asignacion() {
		return fecha_asignacion;
	}
	public void setFecha_asignacion(Date fecha_asignacion) {
		this.fecha_asignacion = fecha_asignacion;
	}	
	
	
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
	
	
	@Override
	public String toString() {
		return "Menu [menuCobis=" + menuCobis + ", rol=" + rol + ",fecha_asignacion="+ fecha_asignacion+"]";
	}
	
	

}
