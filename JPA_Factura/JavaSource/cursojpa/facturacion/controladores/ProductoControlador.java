package cursojpa.facturacion.controladores;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.persistence.Query;

import cursojpa.facturacion.entidades.Categoria;
import cursojpa.facturacion.entidades.Cliente;
import cursojpa.facturacion.entidades.Producto;
import cursojpa.facturacion.servicios.CategoriaServicio;
import cursojpa.facturacion.servicios.ProductoServicio;
import cursojpa.facturacion.utils.Constantes;

@ManagedBean
@ViewScoped
public class ProductoControlador {

	private Producto producto;

	private int idCategoriaSeleccionada;
	private List<Categoria> categorias;

	@EJB
	private ProductoServicio productoServicio;

	@EJB
	private CategoriaServicio categoriaServicio;

	public ProductoControlador() {
		producto = new Producto();
	}

	@PostConstruct
	public void init() {
		categorias = categoriaServicio.recuperarTodos();
		System.out.println("Categorias: " + categorias.size());
	}

	public void insertar() {
		//cuando mande a insertar un producto, se va a verificar esa categoria con un select para colocarlo dentro del percistence context
		
		Categoria c = categoriaServicio.buscarPorId(idCategoriaSeleccionada);
		// traer la categoria por id
		
		producto.setCategoria(c);
		// setear la categoria encontrada al producto
		
		productoServicio.insertar(producto);
		// insertar el producto
			
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getIdCategoriaSeleccionada() {
		return idCategoriaSeleccionada;
	}

	public void setIdCategoriaSeleccionada(int idCategoriaSeleccionada) {
		this.idCategoriaSeleccionada = idCategoriaSeleccionada;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}	
	
	
	
	

}
