package cursos.jpa.entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "menu")
public class Menu {
	
	//Tabla recursiva
	
	@Id
	@Column(name = "id")
	private int id;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "url")
	private String url;
	
	@Column(name = "nivel")
	private int nivel;	
	
	//--NO SE CREA ATRIBUTO PARA LA CLAVE FORANEA, SE DEBE CREAR UNA RELACION PARA INDICARLA.
	
	@ManyToOne
	@JoinColumn(name = "menu_padre")
	private Menu menuPadre;
	
	@OneToMany(mappedBy = "menuPadre") //nombre del atributo (private Menu menu_padre;)
	private List<Menu> menuHijo;
	
			
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Menu getMenuPadre() {
		return menuPadre;
	}
	public void setMenuPadre(Menu menuPadre) {
		this.menuPadre = menuPadre;
	}
	public List<Menu> getMenuHijo() {
		return menuHijo;
	}
	public void setMenuHijo(List<Menu> menuHijo) {
		this.menuHijo = menuHijo;
	}
	
	@Override
	public String toString() {
		return "Menu [id=" + id + ", nombre=" + nombre + ", nivel="+ nivel+", menuPadre="+ menuPadre+"]";
	}	

}
