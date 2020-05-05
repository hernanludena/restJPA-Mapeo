package cursojpa.facturacion.entidades;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;


@Entity
@Table(name = "menu_rol")
//TODO:Mapear la clave compuesta
//TODO:Crear la clase MenuRolPK para el mapeo
@IdClass(value= MenuRolPK.class)  //indicamos la clave primaria compuesta
public class MenuRol {

	//TODO:mapear la clave primaria y compuesta 
	@Id
	private Menu menu;

	//TODO:mapear la clave primaria y compuesta
	@Id
	private Rol rol;

	private Date fechaAsignacion;

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

	public Date getFechaAsignacion() {
		return fechaAsignacion;
	}

	public void setFechaAsignacion(Date fechaAsignacion) {
		this.fechaAsignacion = fechaAsignacion;
	}

}
