package cursojpa.facturacion.servicios;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import cursojpa.facturacion.entidades.Inventario;

//Examen 5
@Stateless
public class InventarioServicio {
	@PersistenceContext
	private EntityManager em;

	public void insertar(Inventario inventario) {
		em.persist(inventario);
	}
}
