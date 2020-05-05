package cursojpa.facturacion.servicios;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import cursojpa.facturacion.entidades.Cliente;
import cursojpa.facturacion.entidades.Factura;
import cursojpa.facturacion.entidades.Producto;
import cursojpa.facturacion.entidades.adicionales.ProductoItem;
import cursojpa.facturacion.utils.Constantes;

@Stateless
public class ProductoServicio {

	@PersistenceContext
	private EntityManager em;

	public Producto buscarPorId(String id) {
		return em.find(Producto.class, id);
	}

	public void insertar(Producto producto) {
		em.persist(producto);
	}
	
	public List<Producto> buscarProductos() {
		Query q = em.createQuery("select p from Producto p");
		return q.getResultList();
	}

	 //definimos un contructor para traer objetos lijeros, solo con los atributos q deseamos traer.	
	//Metodo para traer un objeto solo con ciertos atributos, sin obejtos asociados.	
	public List<Producto> buscarProductosLigero() {
		Query query= em.createQuery("SELECT new Producto(p.codigo,p.nombre) FROM Producto p");		
		return query.getResultList();  
	}

	// con objeto ProductoItem
	//Traer datos sobre un Objeto Nuevo definido  //creamos un objeto con los atributos que deseamos mapear.
	public ProductoItem buscarObjeto(String codigo) {
		TypedQuery<ProductoItem> query= em.createQuery("SELECT new cursojpa.facturacion.entidades.adicionales.ProductoItem(p.nombre,p.categoria) FROM Producto p where p.codigo = :paramCodigo",ProductoItem.class);
		query.setParameter("paramCodigo", codigo);
		return query.getSingleResult(); 
	}

	// con lista de objetos ProductoItem
	public List<ProductoItem> buscarListaObjetos(String nombre) {
		return null;  //getResultList
	}

	// sim mapear a un objeto sino a una Lista de Object
	public List<Object[]> buscarResultado() {  
		Query query= em.createQuery("SELECT p.codigo,p.nombre,p.precioVenta FROM Producto p");
		List<Object[]> list = query.getResultList();		
		
		for (Object[] object : list) {
			System.out.println(object[0]); 
			System.out.println(object[1]);
			System.out.println(object[2]);
		}
		
		return list;
	}
	
	//Examen 2
	/*2)	En ProductoServicio crear un método buscarVendidos
	Recibe: la cédula del cliente
	Retorna: la lista de Productos comprados por el cliente
	Funcionamiento: Hacer el query sobre la tabla detalle_factura.*/

	public List<Producto> buscarVendidos(String id){
		//Query q = em.createQuery("select fd.producto from FacturaDetalle fd where fd.factura.cliente.cedula =:paramId");
		//Examen 4: NameQuery
		Query q= em.createNamedQuery("buscarVendidos");
		q.setParameter("paramId", id);
		return q.getResultList();
		
	}
	
	
	//Examen 7
		public List<Producto> buscarTodosPorLotes(int desde) {
			Query q = em.createQuery("SELECT p FROM Producto p ORDER BY p.nombre");			
			q.setMaxResults(Constantes.filasProductos).setFirstResult(desde);
			return q.getResultList();
		}


}
