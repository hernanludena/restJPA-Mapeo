package cursojpa.trx.servicios;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cursojpa.trx.entidades.Cuenta;
import cursojpa.trx.entidades.Transaccion;

@Stateless
public class TransaccionServicio {

	@PersistenceContext
	private EntityManager em;

	@TransactionAttribute(TransactionAttributeType.MANDATORY)  //al invocar al metodo,se va ejecutar siempre q se halla abierto una trx
	public void registrar(Cuenta cuenta, BigDecimal monto, int tipo) { //es obligatorio que se inicie una trx porque es MANDATORY, o marcara error.
		Transaccion trx = new Transaccion();
		trx.setCuenta(cuenta);
		trx.setFecha(new Date());
		trx.setMonto(monto);
		trx.setTipo(tipo);
		em.persist(trx);
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)  // NOT_SUPPORTED, para que no abra ninguna trx, cuando se invoca
	public List<Transaccion> buscarTodos() { //es aconsejable usar este tipo en las consultas.
     Query query= em.createNamedQuery("recuperarTodos");
        return query.getResultList();
		
	}

}
