package cursos.jpa.servicios.menu;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import cursos.jpa.entidades.menu.Rol;




@Stateless
public class RolServicio {

	@PersistenceContext
	private EntityManager em;
	
	public void insertar(Rol rol){
		em.persist(rol);
	}
	
	public Rol buscar(int id){
		return em.find(Rol.class, id);
	}
}
