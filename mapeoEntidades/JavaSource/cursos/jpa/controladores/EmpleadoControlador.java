package cursos.jpa.controladores;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import curso.jpa.servicios.EmpleadoServicio;
import cursos.jpa.entidades.Departamento;
import cursos.jpa.entidades.Empleado;



@ManagedBean
public class EmpleadoControlador {
	
	private Empleado empleado;
	
	
	private int idDepartamento;
	
	@EJB
	private EmpleadoServicio servicioEmpleado;
	
	
	
	public EmpleadoControlador(){
		empleado=new Empleado();
	}
	public void insertar(){		
		Departamento dep = new Departamento();
		dep.setId(2);
		empleado.setDepartamento(dep);
		servicioEmpleado.insertar(empleado);
	}	
	

	public void recuperar(){
		List<Empleado> empleado = servicioEmpleado.recuperarTodos();
		System.out.println(empleado);		
	}
	
	public Empleado getEmpleado() {
		return empleado;
	}

	public void setEmpleado(Empleado empleado) {
		this.empleado = empleado;
	}
	public int getIdDepartamento() {
		return idDepartamento;
	}
	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
	
}
