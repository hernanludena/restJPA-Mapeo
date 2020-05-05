package cursojpa.facturacion.entidades;

import java.math.BigDecimal;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "factura")
public class Factura {

	@Id
	@Column(name = "fac_codigo")
	private String codigo;

	@Column(name = "fac_fecha")
	private Date fecha;

	@Column(name = "fac_total")
	private BigDecimal total;

	//TODO:mapear relacion con cliente
	@ManyToOne  //un cliente puede tener muchas facturas.
	@JoinColumn(name = "fac_id_cliente")   //EAGER  //la carga Lazy siempre esta por default.
	private Cliente cliente;
	//cliente tiene una factura

	//Examen 5 - Eliminar en Cascade
	//TODO:mapear relacion con facturaDetalle
	@OneToMany(mappedBy = "factura",cascade={CascadeType.PERSIST,CascadeType.REMOVE}) //Cascade: persiste factura y factura_detalle	//LAZY
	private List<FacturaDetalle> detalles;	
	//una factura tiene una lista de detalles
	
	//Examen 7
	@Transient
	private BigDecimal totalIva;
	
	public Factura() {
		
	}

	public Factura(Cliente cliente) {
		super();
		this.cliente = cliente;
	}




	public BigDecimal getTotalIva() {
		return totalIva;
	}

	public void setTotalIva(BigDecimal totalIva) {
		this.totalIva = totalIva;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<FacturaDetalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<FacturaDetalle> detalles) {
		this.detalles = detalles;
	}

	@Override
	public String toString() {
		return "Factura [codigo=" + codigo + ", fecha=" + fecha + ", total="
				+ total + ", cliente=" + cliente + "]";
	}
	
	

}
