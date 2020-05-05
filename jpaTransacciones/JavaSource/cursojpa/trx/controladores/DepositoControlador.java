package cursojpa.trx.controladores;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import cursojpa.trx.entidades.Cuenta;
import cursojpa.trx.entidades.Transaccion;
import cursojpa.trx.servicios.CuentaFacade;
import cursojpa.trx.servicios.CuentaFacadeBMT;
import cursojpa.trx.servicios.CuentaServicio;
import cursojpa.trx.servicios.TransaccionServicio;

@ManagedBean
@ViewScoped
public class DepositoControlador {

	private String numeroCuenta;
	private double monto;	
	

	@EJB
	private CuentaFacade cuentaFacade;
	@EJB
	private TransaccionServicio transaccionServicio;

	@EJB
	private CuentaServicio cuentaServicio;
	
	@EJB
	private CuentaFacadeBMT cuentaFacadeBMT;

	public void depositarBMT() {
		cuentaFacadeBMT.depositar(numeroCuenta, monto);
	}
	
	public void depositar() {
		cuentaFacade.depositar(numeroCuenta, monto);
	}
	public void depositarConAuditoria() {
		cuentaFacade.depositarConAuditoria(numeroCuenta, monto);
	}
	
	public void depositarConComprobacion(){
		cuentaFacade.depositarConComprobacion("1212", 100.0);
	}
	
	public void registrar(){
		transaccionServicio.registrar(new Cuenta("1212"), new BigDecimal("100"), 1);
		//Se origina error debido a que el metodo que se invoca en transaccionServicio es MANDATORY, 
		//es decir necesita que se haya incializado una trx antes.
		//Transaction is required for invocation: org.jboss.invocation.InterceptorContext@16aac2cc
	}
	
	public void buscarPorSaldo(){
		List<Cuenta> list = cuentaServicio.buscarPorSaldo(100.0);
		System.out.println(list);  // si trato de acceder a la lista de Transacciones, saldra error de Carga Lazy, xq estoy fuera de contexto
		//debe de estar dentro del sessionManager y ademas dentro de la transaccion para que funcione la carga Lazy.
	}  //Carga Lazy: es cuando se carga un atributo lista de un objeto relacionado entre ellos. (Ej: Departamento-Empleado), y se requiere la lista de empleados.
	
	public void buscarTodos(){  
		List<Transaccion> list = transaccionServicio.buscarTodos();
		System.out.println(list);
		transaccionServicio.registrar(new Cuenta("1212"), new BigDecimal("100"), 1);
		//Transaction is required for invocation: org.jboss.invocation.InterceptorContext@48d1a83c
	}

	
	public void retirar(){
		cuentaFacade.retirar("12126", 100.0);
		
	}
	
	public void transferir(){
		
		try {
			cuentaFacade.transferir("1212", "1212126", 150.0);
		} catch (Exception e) {  //Cuando sea una exception controlada: New Exception, no hace rollback.
			// TODO Auto-generated catch block
			e.printStackTrace(); 
		}
		
		
	} //java.lang.NullPointerException;  //xq cuenta no existe;
	//todos los errores del sistema de tipo Runtime-->hace rollback
	//Cuando sea una exception controlada: throw new Exception("Error");, no hace rollback.


	public String getNumeroCuenta() {
		return numeroCuenta;
	}

	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}

	public double getMonto() {
		return monto;
	}

	public void setMonto(double monto) {
		this.monto = monto;
	}

}
