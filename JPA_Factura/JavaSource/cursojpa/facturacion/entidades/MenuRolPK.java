package cursojpa.facturacion.entidades;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;



public class MenuRolPK implements Serializable{
	
	//TODO:Mapear clave compuesta y relaciones	
	@Id
	@ManyToOne
	@JoinColumn(name = "mro_id_menu")
	private Menu menu;
	
	//TODO:Mapear clave compuesta y relaciones
	@Id
	@ManyToOne
	@JoinColumn(name = "mro_id_rol")
	private Rol rol;

	public Menu getMenu() {
		return menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((menu == null) ? 0 : menu.hashCode());
		result = prime * result + ((rol == null) ? 0 : rol.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuRolPK other = (MenuRolPK) obj;
		if (menu == null) {
			if (other.menu != null)
				return false;
		} else if (!menu.equals(other.menu))
			return false;
		if (rol == null) {
			if (other.rol != null)
				return false;
		} else if (!rol.equals(other.rol))
			return false;
		return true;
	}
	
	
	//sobreescribir equals y hashCode
	
}
