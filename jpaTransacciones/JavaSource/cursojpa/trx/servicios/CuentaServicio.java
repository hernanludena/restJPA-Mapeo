package cursojpa.trx.servicios;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import cursojpa.trx.entidades.Cuenta;

@Stateless
public class CuentaServicio {

	@PersistenceContext
	private EntityManager em;
	
	public Cuenta buscarPorNumero(String numeroCuenta) {
		return em.find(Cuenta.class, numeroCuenta);
	}

	public Cuenta actualizar(Cuenta cuenta) {
		return em.merge(cuenta);
	}

	/***
	 * Retorna las cuentas cuyo saldo es mayor al que recibe como parámetro
	 * @param saldo
	 * @return
	 */
	// si solo es consulta, no es necesario q cree una trx, de debe utilizar NOT_SUPPORTED
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	//@TransactionAttribute(TransactionAttributeType.SUPPORTS)  //forma parte de una trx si fuese necesario
	public List<Cuenta> buscarPorSaldo(Double saldo) {
		Query query= em.createQuery("SELECT cu FROM Cuenta cu " +
    			"WHERE cu.saldo > :paramSaldo");
    	query.setParameter("paramSaldo", new BigDecimal(Double.toString(saldo)));
    	System.out.println(Double.toString(saldo));

        return query.getResultList();        
		
	}

}
