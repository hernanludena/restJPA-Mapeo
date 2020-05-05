package cursojpa.facturacion.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "inventario")
public class Inventario {

	@Id
	@Column(name = "id_inventario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idInventario;

	@Column(name = "fecha_inventario")
	private Date fechaInventario;

	@Column(name = "cantidad_producto")
	private Integer cantidadProducto;

	@Column(name = "operacion_inventario")
	private Integer operacionInventario;

	@ManyToOne  //un producto puede tener muchos inventarios
	@JoinColumn(name = "id_producto")  //Examen 5
	private Producto productoInventario;

	public Integer getIdInventario() {
		return idInventario;
	}

	public void setIdInventario(Integer idInventario) {
		this.idInventario = idInventario;
	}

	public Date getFechaInventario() {
		return fechaInventario;
	}

	public void setFechaInventario(Date fechaInventario) {
		this.fechaInventario = fechaInventario;
	}

	public Integer getCantidadProducto() {
		return cantidadProducto;
	}

	public void setCantidadProducto(Integer cantidadProducto) {
		this.cantidadProducto = cantidadProducto;
	}

	public Integer getOperacionInventario() {
		return operacionInventario;
	}

	public void setOperacionInventario(Integer operacionInventario) {
		this.operacionInventario = operacionInventario;
	}

	public Producto getProductoInventario() {
		return productoInventario;
	}

	public void setProductoInventario(Producto productoInventario) {
		this.productoInventario = productoInventario;
	}

}
