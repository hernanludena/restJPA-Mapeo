package cursos.jpa.servicios.menu;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import cursos.jpa.entidades.menu.MenuCobis;



@Stateless
public class MenuCobisServicio {

	@PersistenceContext
	private EntityManager em;
	
	public void insertar(MenuCobis menu){
		em.persist(menu);
	}
	
	public MenuCobis buscar(int id){
		return em.find(MenuCobis.class, id);
	}
	
	
}
