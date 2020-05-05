package curso.jpa.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cursos.jpa.entidades.Cliente;
import cursos.jpa.entidades.Departamento;

@Stateless
public class DepartamentoServicio {

	@PersistenceContext(unitName = "cursojpa") // elegir unidad de persistencia	
	private EntityManager em;

	public void insertar(Departamento departamento) {

		em.persist(departamento);

	}
	
	 public List<Departamento> recuperarTodos(){
		   
	    	Query query= em.createQuery("SELECT dep FROM Departamento dep");

	        return query.getResultList();
	}
	 
	 public Departamento buscarDepartamentoPorId(int id){ 	   
	    	
	        return em.find(Departamento.class, id);

	}
	 
	 public Departamento buscarPorId(int id){ 	   
		 //quitamos el EAGER
	    	Departamento dep = em.find(Departamento.class, id);
	    	System.out.println(dep);
	    	System.out.println(dep.getEmpleados().size());
	        return dep;

	}
	 
	 
	 public void modificar(){
		 Departamento dep = buscarPorId(1);
		 dep.setNombre("Fabrica");
		 
	 }

	 
	 
}
