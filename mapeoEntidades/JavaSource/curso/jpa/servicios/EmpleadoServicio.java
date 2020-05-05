package curso.jpa.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cursos.jpa.entidades.Cliente;
import cursos.jpa.entidades.Departamento;
import cursos.jpa.entidades.Empleado;

@Stateless
public class EmpleadoServicio {

	@PersistenceContext(unitName = "cursojpa") // elegir unidad de persistencia	
	private EntityManager em;

	public void insertar(Empleado empleado) {

		em.persist(empleado);

	}
	
	 public List<Empleado> recuperarTodos(){
		   
	    	Query query= em.createQuery("SELECT emp FROM Empleado emp JOIN FETCH emp.departamento"); //podemos hacer join con el objeto enlazado por la clave foranea.
	    	// Si hibernate no harma el join, es aconsejable hacer nuestros propios JOIN.

	        return query.getResultList();
		}
	 
}
