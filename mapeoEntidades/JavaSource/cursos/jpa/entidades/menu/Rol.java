package cursos.jpa.entidades.menu;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ad_rol")
public class Rol {
	
	@Id
	@Column(name = "ro_rol")
	private int rol;
	
	@Column(name = "ro_filial")
	private int filial;
	
	@Column(name = "ro_descripcion")
	private String descripcion;

	public int getRol() {
		return rol;
	}

	public void setRol(int rol) {
		this.rol = rol;
	}

	public int getFilial() {
		return filial;
	}

	public void setFilial(int filial) {
		this.filial = filial;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	@Override
	public String toString() {
		return "Rol [rol=" + rol + ", filial=" + filial + ", descripcion="+ descripcion+"]";
	}
	
}
