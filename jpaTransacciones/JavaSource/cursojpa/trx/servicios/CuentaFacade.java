package cursojpa.trx.servicios;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import cursojpa.trx.entidades.Auditoria;
import cursojpa.trx.entidades.Cuenta;

@Stateless
public class CuentaFacade {
	
	//Transacciones manejadas por el contenedor
	//CMT -- Container

	@EJB
	private CuentaServicio cuentaServicio;

	@EJB
	private TransaccionServicio transaccionServicio;

	@EJB
	private AuditoriaServicio auditoriaServicio;

	
	//los metodos por defectos son Required, y siempre son transaccionales (las consultas no deberian crear trx)
	@TransactionAttribute(TransactionAttributeType.REQUIRED)//Todos los metodos, tienen un atributo de transaccion de tipo required
	public void depositar(String numeroCuenta, double monto) {  
		// Se debe configurar la transaccionalidad en el jboss  <datasource jta="true"
		//para que soporte el rollback, cuando falla una operacion
		Cuenta cuenta = cuentaServicio.buscarPorNumero(numeroCuenta);
		cuenta.setSaldo(cuenta.getSaldo().add(new BigDecimal(monto)));
		cuentaServicio.actualizar(cuenta);
		// tipo 0-deposito
		transaccionServicio.registrar(cuenta, new BigDecimal(monto), 0);
		System.out.println("test");
		//transaccionServicio.registrar(new Cuenta("11203654"), new BigDecimal(monto), 0);  //Cuenta que no existe
	
	}
	//Requerid: si el metodo es required y si el metodo ya inicio una transaccion, usa la misma trx; y si no hay la crea

	
	//cada metodo es considerado como una tran /begin tran - commi tran
	public void depositarConAuditoria(String numeroCuenta, double monto) {
		
		auditoriaServicio.insertar(new Auditoria("Ingresa a Depositar"));  //debe insertar siempre; ya que en el innsertar se crea una nueva transaccion
		Cuenta cuenta = cuentaServicio.buscarPorNumero(numeroCuenta);
		cuenta.setSaldo(cuenta.getSaldo().add(new BigDecimal(monto)));
		cuentaServicio.actualizar(cuenta);
		// tipo 0-deposito
		transaccionServicio.registrar(cuenta, new BigDecimal(monto), 0);
		transaccionServicio.registrar(new Cuenta("11203654"), new BigDecimal(monto), 0);
		
		//A pesar de que fallan las demas transacciones con rollback, la de trx de auditoria hace commit satisfactoriamente
		//debido a q es de tipo REQUIRES_NEW
	
	}

	public void retirar(String numeroCuenta, double monto) {
		Cuenta cuenta = cuentaServicio.buscarPorNumero(numeroCuenta);
		cuenta.setSaldo(cuenta.getSaldo().add(new BigDecimal(monto*-1)));
		cuentaServicio.actualizar(cuenta);
		//tipo 1-retiro
		transaccionServicio.registrar(cuenta, new BigDecimal(monto), 1);
	}

	public void transferir(String cuentaDesde, String cuentaHacia, double monto) throws Exception {
		//RETIRO
		Cuenta cuenta = cuentaServicio.buscarPorNumero(cuentaDesde);
		cuenta.setSaldo(cuenta.getSaldo().add(new BigDecimal(monto*-1)));
		cuentaServicio.actualizar(cuenta);
		//tipo 1-retiro
		transaccionServicio.registrar(cuenta, new BigDecimal(monto), 1);
		
		if (monto > 10){
			throw new Exception("Error");
		}	
		
		
		//DEPOSITO
		Cuenta cuentaD = cuentaServicio.buscarPorNumero(cuentaHacia);
		cuentaD.setSaldo(cuentaD.getSaldo().add(new BigDecimal(monto)));
		cuentaServicio.actualizar(cuentaD);
		//tipo 2-deposito
		transaccionServicio.registrar(cuentaD, new BigDecimal(monto), 1);
	}

	public void depositarConComprobacion(String numeroCuenta, double monto) {
		Cuenta cuenta = cuentaServicio.buscarPorNumero(numeroCuenta);
		cuenta.setSaldo(cuenta.getSaldo().add(new BigDecimal(monto)));
		cuentaServicio.actualizar(cuenta);
		List<Cuenta> list = cuentaServicio.buscarPorSaldo(100.0);  //es NOT_SUPPORTED
		list.get(0).getTransacciones().size();  //ERROR DE CARGA LAZY, porque buscarPorSaldo es NOT_SUPPORTED, es decir no abrio un trx, y por lo tanto esta fuera de la trx
		System.out.println(list);  //failed to lazily initialize a collection of role
	}

}
