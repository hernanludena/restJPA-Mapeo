package cursojpa.trx.entidades;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;




@Entity
@Table(name = "transaccion")
@NamedQuery(name="recuperarTodos",query="SELECT trx FROM Transaccion trx")
public class Transaccion {
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;

	@Column(name="fecha")
	private Date fecha;

	@Column(name="monto")
	private BigDecimal monto;

	@Column(name="tipo")
	private Integer tipo;
	
	//para el mapeo de la relación
	@ManyToOne
	@JoinColumn(name = "num_cuenta")	
	private Cuenta cuenta;  //FK	
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getMonto() {
		return monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	
	
	
	@Override
	public String toString() {
		return "Transaccion [id=" + id + ", fecha=" + fecha + ", monto="
				+ monto + ", tipo=" + tipo + ", cuenta=" + cuenta + "]";
	}




}