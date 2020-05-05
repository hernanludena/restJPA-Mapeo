package cursojpa.facturacion.entidades;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.persistence.Table;

@Entity
@Table(name = "producto")  
//Examen 4
@NamedQuery(name="buscarVendidos",query="select fd.producto from FacturaDetalle fd where fd.factura.cliente.cedula =:paramId")
public class Producto {

	@Id
	@Column(name = "codigo")
	private String codigo;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "precio_venta")
	private BigDecimal precioVenta;

	@Column(name = "impuesto")
	private Boolean impuesto;

	@JoinColumn(name = "id_categoria")
	@ManyToOne  //un categoria tiene muchos productos
	private Categoria categoria;  //cuando mande a insertar un producto, se va a verificar esa categoria con un select para colocarlo dentro del percistence context
 	//Producto tiene una categoria.
		
	public Producto() {

	}

	public Producto(String codigo, String nombre) {  //contructor para traer objetos lijeros
		super();
		this.codigo = codigo;
		this.nombre = nombre;
	}

	public Producto(String nombre, Categoria categoria) {
		super();
		this.nombre = nombre;
		this.categoria = categoria;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(BigDecimal precioVenta) {
		this.precioVenta = precioVenta;
	}

	public Boolean getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(Boolean impuesto) {
		this.impuesto = impuesto;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
