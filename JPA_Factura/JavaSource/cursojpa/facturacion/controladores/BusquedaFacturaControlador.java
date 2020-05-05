package cursojpa.facturacion.controladores;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import cursojpa.facturacion.entidades.Factura;
import cursojpa.facturacion.servicios.FacturaServicio;

@ManagedBean
@ViewScoped
public class BusquedaFacturaControlador {

	private String codFactura;
	
	@EJB
	private FacturaServicio facturaServicio;
	private Factura factura;
	
	
	public BusquedaFacturaControlador() {
		factura= new Factura();
	}
	
	public void buscarFactura(){
		factura= facturaServicio.buscarFactura(codFactura);
	}
	
	public void buscarFacturaJoin(){
		factura= facturaServicio.buscarFacturaJoin(codFactura);
	}

	//getters y setters
	public String getCodFactura() {
		return codFactura;
	}

	public void setCodFactura(String codFactura) {
		this.codFactura = codFactura;
	}

	public Factura getFactura() {
		return factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}
	public void eliminar(){
		facturaServicio.eliminar(factura);
		
	}
	
	
}
