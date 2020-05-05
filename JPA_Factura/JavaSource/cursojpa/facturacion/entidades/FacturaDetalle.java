package cursojpa.facturacion.entidades;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="factura_detalle")
public class FacturaDetalle { //La carga Lazy es por defecto

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fd_codigo")
	private int codigo;

	@ManyToOne  //un producto puede estar en muchos detalles
	@JoinColumn(name = "fd_id_producto")
	private Producto producto;

	@Column(name = "fd_cantidad")
	private int cantidad;

	//TODO:Mapear Relacion con Factura
	@ManyToOne  //una factura puede tener muchos detalles
	@JoinColumn(name = "fd_id_factura")
	private Factura factura;		
	
	@Transient  //No se mapea contra la base
	private BigDecimal subTotal;
	
	
	
	

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}
	
	


}
