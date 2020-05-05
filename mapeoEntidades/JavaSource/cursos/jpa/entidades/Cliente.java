package cursos.jpa.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "clientes")
//@NamedQuery(name="buscarPorRango",query="SELECT cl FROM Cliente cl WHERE cl.id BETWEEN :id1 and :id2")
@NamedQueries({
	@NamedQuery(name="buscarPorRango",query="SELECT cl FROM Cliente cl WHERE cl.id BETWEEN :id1 and :id2"),
	@NamedQuery(name="recuperarTodos",query="SELECT cl FROM Cliente cl")	
}
)
public class Cliente {
	
	@Id
	@Column(name = "cli_id")
	private int id;	
	
	@Column(name = "cli_cedula")
	private String cedula;
	
	@Column(name = "cli_nombre")
	private String nombre;
	
	@Column(name = "cli_apellido")
	private String apellido;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	@Override
	public String toString() {
		return "Cliente [id=" + id + ", cedula=" + cedula + ", nombre="
				+ nombre + ", apellido=" + apellido + "]";
	}
	
		

}
