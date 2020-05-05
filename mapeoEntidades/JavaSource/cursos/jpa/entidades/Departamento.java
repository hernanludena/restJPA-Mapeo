package cursos.jpa.entidades;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "departamento")
public class Departamento {
	
	@Id
	@Column(name = "dep_id")
	private int id;
	
	@Column(name = "dep_nombre")
	private String nombre;
	
	//@OneToMany(mappedBy = "departamento")//,fetch =FetchType.EAGER) //nombre del atributo en Empleado (private Departamento departamento;)
	@OneToMany(mappedBy = "departamento",cascade=CascadeType.PERSIST)  //para que percista en cascada en el metodo insertarDepartamentoEmpleado()
	private List<Empleado> empleados;
	
	
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
	public List<Empleado> getEmpleados() {
		return empleados;
	}
	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}
	
	@Override
	public String toString() {
		return "Departamento [id=" + id + ", nombre=" + nombre +"]";
	}	
	
	

}
