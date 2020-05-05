package cursos.jpa.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import curso.jpa.servicios.DepartamentoServicio;
import cursos.jpa.entidades.Cliente;
import cursos.jpa.entidades.Departamento;
import cursos.jpa.entidades.Empleado;


@ManagedBean
public class DepartamentoControlador {
    //@ManagedBean --permite comunicar los metodos con la pagina
	//@EJB ---Inyeccion de codigo
	@EJB
	private DepartamentoServicio servicioDepartamento;

	private Departamento departamento;

	public DepartamentoControlador() {
		departamento = new Departamento();
	}

	public void insertar() {
		servicioDepartamento.insertar(departamento);
	}
	
	public void insertarDepartamentoEmpleado(){		
		Departamento dep = new Departamento();
		//int idRandom = (int) Math.round((Math.random()*10)); 
		
		dep.setId(213); //id que no exista
		dep.setNombre("Contabilidad");
		
		List<Empleado> empleados = new ArrayList<Empleado>();
		Empleado empleado1 = new Empleado();
		empleado1.setNombre("Juan");  //el id por defecto es 0
		empleado1.setDepartamento(dep);
		empleado1.setId(14);
		
		Empleado empleado2 = new Empleado();
		empleado2.setId(15);
		empleado2.setNombre("Cadena");
		empleado2.setDepartamento(dep);   
		
		empleados.add(empleado1);
		empleados.add(empleado2);
		dep.setEmpleados(empleados);   //relacionar detalle con cabecera		
		
		servicioDepartamento.insertar(dep);
	}

	public void recuperar() {

		List<Departamento> departamento = servicioDepartamento.recuperarTodos();
		System.out.println(departamento);
	}
	
	public void buscarPorId(){
		//Departamento dep = servicioDepartamento.buscarDepartamentoPorId(1);
		Departamento dep = servicioDepartamento.buscarPorId(1);
		//System.out.println(dep);
		//System.out.println(dep.getEmpleados().size());
	}
			

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}
	
	public void actualizar(){		
		servicioDepartamento.modificar();
		
		
	}
	
	
}
