package cursojpa.trx.entidades;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name = "cuenta")
public class Cuenta{

	@Id
	@Column(name = "numero")
	private String numero;

	@Column(name = "saldo")
	private BigDecimal saldo;

	//para el mapeo bi-direccional con Transaccion
	@OneToMany(mappedBy = "cuenta")//,cascade=CascadeType.PERSIST)
	private List<Transaccion> transacciones;
	
	
	public Cuenta(){
	}
	
	public Cuenta(String numero) {
		super();
		this.numero = numero;
	}	
	
	
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public List<Transaccion> getTransacciones() {
		return transacciones;
	}

	public void setTransacciones(List<Transaccion> transacciones) {
		this.transacciones = transacciones;
	}
	
	@Override
	public String toString() {
		return "Cuenta [numero=" + numero + ", saldo=" + saldo + "]";
	}
 //transacciones no se puede imprimir debido por el FetchType (revisar--ojo)


	
}