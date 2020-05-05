package cursos.jpa.servicios.menu;
 
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cursos.jpa.entidades.Menu;
import cursos.jpa.entidades.menu.MenuCobis;
import cursos.jpa.entidades.menu.MenuRol;
import cursos.jpa.entidades.menu.Rol;



@Stateless
public class MenuRolServicio {
	
	@PersistenceContext
	private EntityManager em;
	
	@EJB
	private MenuCobisServicio menuServicio;
	
	@EJB
	private RolServicio rolServicio;
	
	public void asignar(MenuCobis menu, Rol rol){
		
		MenuCobis menu1 = menuServicio.buscar(menu.getId());  //buscar los objetos que me llegan de la capa controlador y estan fuera de contexto
		Rol rol1 = rolServicio.buscar(rol.getRol());          //al consultar, los tengo dentro de mi contexto
		MenuRol menuRol = new MenuRol();
		menuRol.setMenuCobis(menu1);
		menuRol.setRol(rol1);
		menuRol.setFecha_asignacion(new Date());
		em.persist(menuRol);	 //solucion 1--buscar los objetos dentro del contexto del EM e insertar.		
		
		/*MenuRol menuRol = new MenuRol();
		menuRol.setMenuCobis(menu);
		menuRol.setRol(rol);
		menuRol.setFecha_asignacion(new Date());		
		em.merge(menuRol); 'solucion2-- no realizar ninguna busqueda, solo hago merge con los objetos q me llegan			
		*/
	}
	
	//buscar todos los menus que pertenezcan al id de rol que recibe como parametro.
	public List<MenuCobis> buscar(int idRol){
		Query query= em.createQuery("SELECT mr.menuCobis FROM MenuRol mr " +
    			"where  mr.rol.rol = :paramIdRol");   //Select id_rol from menu_rol equivalente en SQL
    	query.setParameter("paramIdRol",idRol);

        return query.getResultList();
	}
	
}
