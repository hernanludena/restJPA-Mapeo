package cursojpa.facturacion.controladores;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import cursojpa.facturacion.entidades.Cliente;
import cursojpa.facturacion.servicios.ClienteServicio;
import cursojpa.facturacion.utils.Constantes;

@ManagedBean
@ViewScoped
public class BuscarClienteControlador {

	@EJB
	private ClienteServicio clienteServicio;

	private List<Cliente> clientes;

	private int desde;

	public void anterior() {
		clientes = clienteServicio.buscarTodos(desde);
		desde-=Constantes.filas;  //numero de filas
		if (desde <= 0){
			desde = 0;
		}
		
	}

	public void siguiente() {
		clientes = clienteServicio.buscarTodos(desde);
		desde+=Constantes.filas;  //numero de filas
	}
	

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

}
