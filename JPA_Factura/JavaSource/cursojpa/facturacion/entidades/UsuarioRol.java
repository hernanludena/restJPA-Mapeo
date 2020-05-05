package cursojpa.facturacion.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Table(name = "usuario_rol")
@Entity
@IdClass(UsuarioRolPK.class)
public class UsuarioRol {

	//Clave compuesta
	@Id
	private Usuario usuario;

	@Id
	private Rol rol;

	@Column(name = "uro_activo")
	private Boolean activo;

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Boolean getActivo() {
		return activo;
	}

	public void setActivo(Boolean activo) {
		this.activo = activo;
	}

}
