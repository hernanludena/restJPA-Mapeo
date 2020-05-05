package cursojpa.facturacion.controladores;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import cursojpa.facturacion.entidades.Cliente;
import cursojpa.facturacion.entidades.Producto;
import cursojpa.facturacion.servicios.ProductoServicio;
import cursojpa.facturacion.utils.Constantes;

@ManagedBean
public class BusquedaProductoControlador {

	@EJB
	private ProductoServicio productoServicio;
//
	private List<Producto> productos;
	private List<Producto> productosLigero;
	//private List<ProductoVendido> productosVendidos;
	private List<Producto> productosCliente;
	private Cliente cliente;
	
	//Examen 7
	private int desde;

	public BusquedaProductoControlador() {
		productos = new ArrayList<Producto>();
		productosCliente = new ArrayList<Producto>();
		//productosVendidos = new ArrayList<ProductoVendido>();
		cliente =new Cliente();
	}	

	public void buscarTodos() {
		productos = productoServicio.buscarProductos();
		productosLigero = new ArrayList<Producto>();
	}

	public void buscarLigero() {
		productosLigero = productoServicio.buscarProductosLigero();
		productos = new ArrayList<Producto>();
	}	

	public List<Producto> getProductos() {
		return productos;
	}

	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}

	public List<Producto> getProductosLigero() {
		return productosLigero;
	}

	public void setProductosLigero(List<Producto> productosLigero) {
		this.productosLigero = productosLigero;
	}
	
	
	
	public ProductoServicio getProductoServicio() {
		return productoServicio;
	}

	public void setProductoServicio(ProductoServicio productoServicio) {
		this.productoServicio = productoServicio;
	}

	public List<Producto> getProductosCliente() {
		return productosCliente;
	}

	public void setProductosCliente(List<Producto> productosCliente) {
		this.productosCliente = productosCliente;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	//Examen 2  Productos Vendidos x cliente
	public void consultarProdPorCliente(){		
		productosCliente=productoServicio.buscarVendidos(cliente.getCedula());
		System.out.println("LISTA PRODCLIETES:" + productosCliente.size());
	}
	
	
	//Examen 7  //Lotes de 4 en 4
	public void buscarTodosPorLotes(){
		productos = productoServicio.buscarTodosPorLotes(desde);		
		desde-=Constantes.filasProductos;  //4
		if (desde <= 0){
			desde = 0;
		}
		
	}

}
