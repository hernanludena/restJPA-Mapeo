package cursojpa.facturacion.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cursojpa.facturacion.entidades.Menu;


@Stateless
public class MenuServicio {
	
	
	@PersistenceContext
	private EntityManager em;
	
	/***
	 * Buscar todos los menues que pertenecen a un usuario
	 * @param idUsuario Id del usuario
	 * @return Los menues del usuario
	 */
	public List<Menu> buscar(int idUsuario){
        
//        Query q = em.createQuery("select m from Menu m where m.id in" +
//                     "(select mr.menu from MenuRol mr where mr.rol in" +
//                     "(select ur.rol from UsuarioRol ur where ur.usuario in" +
//                     "(select u.id from Usuario u where u.id =:p1)))");
		Query q = em.createQuery("SELECT mr.menu FROM MenuRol mr , UsuarioRol ur where mr.rol.id=ur.rol.id AND ur.usuario.id=:p1"); 

       
        q.setParameter("p1", idUsuario);
        List<Menu> menus =q.getResultList();
        System.out.println(menus);
        return menus;        
 }
	
	//Examen 1
	public List<Menu> buscarPrincipales(int idUsuario){
//      Query q = em.createQuery("select m from Menu m where m.id in" + "(select mr.menu from MenuRol mr where mr.rol in" +
//      "(select ur.rol from UsuarioRol ur where ur.usuario in" + "(select u.id from Usuario u where u.id =:p1)))");
      //Examen 4 NameQuery
		Query q= em.createNamedQuery("buscarPrincipales");
      q.setParameter("p1", idUsuario);
      List<Menu> menus =q.getResultList();
      System.out.println(menus);
      return menus;       
	}
	
}
