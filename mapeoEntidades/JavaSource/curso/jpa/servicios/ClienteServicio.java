package curso.jpa.servicios;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cursos.jpa.entidades.Cliente;

@Stateless
public class ClienteServicio {
	// @Stateless es un SessionBean para ser manejado por el contenedor en un contexto
	
	@PersistenceContext
	private EntityManager em;
	
	public void insertar(Cliente cliente){
		
		em.persist(cliente);
		
	}
    public void modificar(Cliente cliente){
		
		em.merge(cliente);
		
	}
    
    public List<Cliente> recuperarTodos(){
	   
    	//Query query= em.createQuery("SELECT cl FROM Cliente cl");
    	Query query= em.createNamedQuery("recuperarTodos");
    	

        return query.getResultList();
	}
    
    public List<Cliente> buscarPorNombre(String cadena){
 	   
    	Query query= em.createQuery("SELECT cl FROM Cliente cl " +
    			"WHERE cl.nombre LIKE :paramCadena");
    	query.setParameter("paramCadena", cadena+"%");

        return query.getResultList();
	}
    
    public Cliente buscarClientePorId(int id){
  	   
    	Query query= em.createQuery("SELECT cl FROM Cliente cl " +
    			"WHERE cl.id = :id");
    	query.setParameter("id", id);

        return (Cliente)query.getSingleResult();
	}
    
    public List<Cliente> buscarClientePorRango(int id1, int id2){
   	   
//    	Query query= em.createQuery("SELECT cl FROM Cliente cl " +
//    			"WHERE cl.id BETWEEN :id1 and :id2");
//    	query.setParameter("id1", id1);
//    	query.setParameter("id2", id2);
    	
    	//Query query= em.createNativeQuery(arg0);  //SQL nativo
    	Query query= em.createNamedQuery("buscarPorRango");	 //sentencias creadas
    	query.setParameter("id1", id1);
    	query.setParameter("id2", id2);

        return query.getResultList();
	}

}
