package cursojpa.facturacion.controladores;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import cursojpa.facturacion.entidades.Cliente;
import cursojpa.facturacion.entidades.Factura;
import cursojpa.facturacion.entidades.FacturaDetalle;
import cursojpa.facturacion.entidades.Inventario;
import cursojpa.facturacion.entidades.Producto;
import cursojpa.facturacion.servicios.ClienteServicio;
import cursojpa.facturacion.servicios.FacturaServicio;
import cursojpa.facturacion.servicios.InventarioServicio;
import cursojpa.facturacion.servicios.ProductoServicio;
import cursojpa.facturacion.utils.GeneradorMensajes;

@ManagedBean
@ViewScoped
public class FacturaControlador {


	private Cliente cliente;
	private String cadenaBusquedaCliente;
	private String cedulaBusquedaCliente;
	private List<Cliente> clientes;
	private String codigoBusquedaProducto;
	private Producto producto;
	private Factura factura;
	private int cantidad;
	private List<FacturaDetalle> detalles;
	
	//Examen 5
	private Inventario inventario;
	

	@EJB
	private ClienteServicio clienteServicio;

	@EJB
	private ProductoServicio productoServicio;

	@EJB
	private FacturaServicio facServicio;
	
	//Examen 5
	@EJB
	private InventarioServicio inventarioServicio;


	public FacturaControlador() {
		cliente = new Cliente();
		producto = new Producto();
		factura = new Factura();
		detalles = new ArrayList<FacturaDetalle>();
		factura.setFecha(new Date());
	}

	public void buscarClientePorCedula() {

		cliente = clienteServicio.buscarPorCedula(cedulaBusquedaCliente);
		if (cliente == null) {
			GeneradorMensajes.mostrarInfo("Cliente no encontrado");
		}
	}

	public void buscarClientePorApellido() {
		clientes = clienteServicio.buscarPorApellido(cadenaBusquedaCliente);
	}

	public void buscarProductoPorCodigo() {
		producto = productoServicio.buscarPorId(codigoBusquedaProducto);
	}


	public void guardarFactura() {
        factura.setCliente(cliente);
		// Agregar el cliente a la factura
		factura.setDetalles(detalles);
        // Agregar la lista de detalles a la factura
		facServicio.insertar(factura);
		// invocar al servicio que guarda la factura
	}

	public void agregarDetalle() {
		// nuevo detalle de producto
		FacturaDetalle detalle = new FacturaDetalle();
		// agregar producto
		detalle.setProducto(producto);
		// agregar cantidad
		detalle.setCantidad(cantidad);
		detalle.setFactura(factura);
		
		detalle.setSubTotal(producto.getPrecioVenta().multiply(new BigDecimal(cantidad)));
		// Agregar subtotal, eso luego para el transient
		
		//agregamos el detalle a la lista detalles
		detalles.add(detalle);
		// relacionar con factura - agregamos a la factura la lista de detalles		
		factura.setDetalles(detalles);		//para se guarde la lista de detalles, hay q agregar CASCADE en el objeto
				
		calcularTotal(detalle.getSubTotal());
		//invocar a calcularTotal y se setea en total de la factura
		
		//Examen 5 - Agregar al inventario
		inventario = new Inventario();
		inventario.setCantidadProducto(cantidad);
		inventario.setFechaInventario(new Date());
		//inventario.setIdInventario(idInventario) //Autoincrement
		inventario.setOperacionInventario(1);
		inventario.setProductoInventario(producto);
		inventarioServicio.insertar(inventario);
		
		//Examen 6
		factura.setTotalIva(new BigDecimal("12"));
		
	}

	public void calcularTotal(BigDecimal subTotal) {
		if (factura.getTotal() != null) {
			factura.setTotal(factura.getTotal().add(subTotal));
		} else {
			factura.setTotal(subTotal);
		}

	}
	
	public void buscarFactura(String codigo) {  //una solucion es colocar el FETCHTYPE a EAGER
		facServicio.buscarFactura(codigo);		
		
	}
	
	public void buscarFacturaJoin(String codigo) {  
		facServicio.buscarFacturaJoin(codigo);	
		
	}
	
	
	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getCadenaBusquedaCliente() {
		return cadenaBusquedaCliente;
	}

	public void setCadenaBusquedaCliente(String cadenaBusquedaCliente) {
		this.cadenaBusquedaCliente = cadenaBusquedaCliente;
	}

	public String getCedulaBusquedaCliente() {
		return cedulaBusquedaCliente;
	}

	public void setCedulaBusquedaCliente(String cedulaBusquedaCliente) {
		this.cedulaBusquedaCliente = cedulaBusquedaCliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public String getCodigoBusquedaProducto() {
		return codigoBusquedaProducto;
	}

	public void setCodigoBusquedaProducto(String codigoBusquedaProducto) {
		this.codigoBusquedaProducto = codigoBusquedaProducto;
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

	public List<FacturaDetalle> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<FacturaDetalle> detalles) {
		this.detalles = detalles;
	}

}
