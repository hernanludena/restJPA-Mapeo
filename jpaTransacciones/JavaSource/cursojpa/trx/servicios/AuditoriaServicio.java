package cursojpa.trx.servicios;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import cursojpa.trx.entidades.Auditoria;

@Stateless
public class AuditoriaServicio {

	@PersistenceContext
	private EntityManager em;

	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)  //Crea siempre una nueva transaccion.
	public void insertar(Auditoria a) {
		em.persist(a);
	}

}
