package cursojpa.facturacion.entidades.adicionales;

import cursojpa.facturacion.entidades.Categoria;

/**
 * @author Administrador
 *
 */
public class ProductoItem {

	private String nombre;
	private Categoria categoria;

	public ProductoItem(String nombre, Categoria categoria) {
		super();
		this.nombre = nombre;
		this.categoria = categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "ProductoItem [nombre=" + nombre + ", categoria=" + categoria+ "]";
	}
	
}
