package cursos.jpa.controladores;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import curso.jpa.servicios.ClienteServicio;
import cursos.jpa.entidades.Cliente;


@ManagedBean
public class ClienteControlador {
	private Cliente cliente;
	
	private List<Cliente> clientes;
	
	@EJB
	private ClienteServicio servicio;
	
	
	
	public ClienteControlador(){
		cliente=new Cliente();
	}
	
	public void insertar(){
	
		servicio.insertar(cliente);
		
	}
	
	public void modificar(){
		
		servicio.modificar(cliente);
		
	}
	
	public void buscarClientePorRango(){
		List<Cliente> clientes = servicio.buscarClientePorRango(1, 2);
		System.out.println(clientes);
	}
	
	public void consultarTodos(){
		List<Cliente> clientes = servicio.recuperarTodos();
		System.out.println(clientes);
	}
	
	public void buscarPorNombre(){
		List<Cliente> clientes = servicio.buscarPorNombre("w");
		System.out.println(clientes);
	}
	
	public void buscarClientePorId(){
		Cliente cliente = servicio.buscarClientePorId(1);
		System.out.println(cliente);
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
