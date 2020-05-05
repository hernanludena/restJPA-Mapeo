package cursojpa.facturacion.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cursojpa.facturacion.entidades.Cliente;
import cursojpa.facturacion.utils.Constantes;

@Stateless
public class ClienteServicio {

	@PersistenceContext
	private EntityManager em;

	/***
	 * Recupera todos los clientes cuyo Apellido comience con la cadena que
	 * recibe como parámetro.La búsqueda no hace distinción de mayúsculas y
	 * minúsculas
	 * 
	 * @param cadena
	 *            Cadena para búsqueda
	 * @return Lista de clientes que coincidan con el criterio de búsqueda
	 */
	public List<Cliente> buscarPorApellido(String cadena) {
		Query query= em.createQuery("SELECT cl FROM Cliente cl " +
    			"WHERE TRIM(UPPER(cl.apellido)) LIKE :paramCadena");
    	query.setParameter("paramCadena", cadena.toUpperCase().trim()+"%");

        return query.getResultList();
	}

	// puedo requerir que reciba solo el nombre y apellido del cliente

	public Cliente buscarPorCedula(String cedula) {
		return em.find(Cliente.class, cedula.trim());
		
//		Query query= em.createQuery("SELECT cl FROM Cliente cl " +
//    			"WHERE cl.cedula LIKE :+paramCedula");
//    	query.setParameter("paramCedula", cedula);
//
//        return (Cliente)query.getResultList();
	}

	// agregar firstResults y maxResults
	public List<Cliente> buscarTodos(int desde) {
		Query q = em.createQuery("SELECT c FROM Cliente c ORDER BY c.nombre");
		q.setMaxResults(Constantes.filas).setFirstResult(desde);
		return q.getResultList();
	}

}
