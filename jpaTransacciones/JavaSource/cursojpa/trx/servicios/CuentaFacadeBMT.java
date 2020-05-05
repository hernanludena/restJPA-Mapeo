package cursojpa.trx.servicios;

import java.math.BigDecimal;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import cursojpa.trx.entidades.Cuenta;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class CuentaFacadeBMT {
	//Transacciones manejadas por el Bean
	//BMT
		
	@Resource
	private EJBContext context;
	
	@PersistenceContext
	private EntityManager em;
	
	public void depositar (String numeroCuenta, double monto){
		UserTransaction utx = context.getUserTransaction();   //Nosotros iniciamos la trx
		try {
			utx.begin();
			
			Cuenta cuenta = em.find(Cuenta.class, numeroCuenta);
			cuenta.setSaldo(cuenta.getSaldo().add(new BigDecimal(monto)));
			em.merge(cuenta);
			
			utx.commit();
			
		} catch (NotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
