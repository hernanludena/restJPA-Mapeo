package curso.jpa.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cursos.jpa.entidades.Cliente;
import cursos.jpa.entidades.Departamento;
import cursos.jpa.entidades.Menu;

@Stateless
public class MenuServicio {

	@PersistenceContext(unitName = "cursojpa") // elegir unidad de persistencia	
	private EntityManager em;

	public void insertar(Menu menu) {

		em.persist(menu);

	}	
	
	 public Menu buscarPorId(int id){ 	   
		
		 Menu menu = em.find(Menu.class, id);
	     System.out.println(menu);	    
	     return menu;

	}
	 
	 public List<Menu> recuperarTodos(){
		   
		 Query query= em.createQuery("SELECT m FROM Menu m " +
				 "WHERE m.menuPadre IS NULL");   //podemos recuperar el objeto que esta enlazado por la clave foranea.
	    			//"WHERE m.menuPadre = :id");
	    	//query.setParameter("id", null);	        

	        return query.getResultList();
		}
	 
	 
	 public List<Menu> recuperarTodos2(){
		   
		 Query query= em.createQuery("SELECT m FROM Menu m " +
				 "WHERE m.menuPadre IS NULL");	    	
		 
		 List<Menu> menus = query.getResultList();
		 for(Menu menu: menus){
			 menu.getMenuHijo().size();
		 }	        
	        

	        return menus;
		}
	 
	 
     
}
