package cursojpa.facturacion.controladores;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import cursojpa.facturacion.entidades.adicionales.ProductoItem;
import cursojpa.facturacion.servicios.ProductoServicio;

@ManagedBean
@ViewScoped
public class BuscarObjetoControlador {

	@EJB
	private ProductoServicio productoServicio;

	private ProductoItem productoItem;
	private String nombre;

	public void buscarObjeto() {
		productoItem = productoServicio.buscarObjeto(nombre);
		System.out.println("entro a consultar " + productoItem);
	}

	public void buscarListaObjetos() {
		List<ProductoItem> productos = productoServicio
				.buscarListaObjetos(nombre);
		System.out.println("entro a consultar " + productos);
	}

	public void buscarObjetos() {
		List<Object[]> productos = productoServicio.buscarResultado();
		System.out.println("entro a consultar atributos sin objeto "
				+ productos);
	}

	public ProductoItem getProductoItem() {
		return productoItem;
	}

	public void setProductoItem(ProductoItem productoItem) {
		this.productoItem = productoItem;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
