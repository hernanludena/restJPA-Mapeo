package cursojpa.facturacion.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cursojpa.facturacion.entidades.Categoria;

@Stateless
public class CategoriaServicio {

	@PersistenceContext  //Conjunto de objetos manejados (flush:todos los objetos manejados salen del contexto y quedan detach)
	private EntityManager em;

	public void insertar(Categoria categoria) {
		em.persist(categoria);  //Categoria queda dentro del peristenceContext hasta q se termine la trx, de ahi queda en estado detach.
		//insert
	}

	public void actualizar(Categoria categoria) {
		em.merge(categoria); //objeto en memoria
		//primero dispara Select, para atar el objeto Categoria en memoria dentro del percistenceContext
		//una vez que el objeto esta en el contexto, verifica si los dos objetos son diferentes y hace Update.
	}
	//si se hace merge de un objeto que no existe, se inserta automaticamente.

	public Categoria buscarPorId(int id) {
		return em.find(Categoria.class, id);
	}
	
	public void eliminar(Categoria categoria) {
		//em.remove(categoria);
		//Removing a detached instance cursojpa.facturacion.entidades.Categoria#1
		//el objeto llego del controlador, por lo tanto no esta dentro del percistenceContext, la solucion es buscarlo y luego eliminarlo
		
		Categoria c = buscarPorId(categoria.getId());
		em.remove(c);
	}
	
	

	public List<Categoria> recuperarTodos() {
		Query query = em.createQuery("SELECT c FROM Categoria c");
		return query.getResultList();
	}

}
