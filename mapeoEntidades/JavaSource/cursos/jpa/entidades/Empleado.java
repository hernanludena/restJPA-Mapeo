package cursos.jpa.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "empleado")
public class Empleado {
	
	@Id
	@Column(name = "emp_id")
	private int id;
	
	@Column(name = "emp_nombre")
	private String nombre;
	
	@Column(name = "emp_apellido")
	private String apellido;
	
	@ManyToOne
	@JoinColumn(name = "emp_dep_id")
	private Departamento departamento;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public Departamento getDepartamento() {
		return departamento;
	}
	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", apellido="+ apellido+"]";
	}	
	
	

}
