package cursojpa.facturacion.controladores;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import cursojpa.facturacion.entidades.Menu;
import cursojpa.facturacion.entidades.Usuario;
import cursojpa.facturacion.servicios.MenuServicio;
import cursojpa.facturacion.servicios.UsuarioServicio;
import cursojpa.facturacion.utils.GeneradorMensajes;

@ManagedBean
public class UsuarioControlador {

	private Usuario usuario;
	private List<Menu> menues;  //agregar siempre get y set para sean visibles

	@EJB
	private UsuarioServicio usuarioServicio;

	@EJB
	private MenuServicio menuServicio;

	
	
	public List<Menu> getMenues() {
		return menues;
	}

	public void setMenues(List<Menu> menues) {
		this.menues = menues;
	}

	public UsuarioControlador() {
		usuario = new Usuario();

	}

	public void validar(){
        Usuario encontrado=usuarioServicio.buscar(usuario);

        if (encontrado == null) {
               System.out.println("No existe");
               GeneradorMensajes.mostrarWarning("No existe el usuario");
        } else {
               //imprimir la busqueda de menues
               menuServicio.buscar(encontrado.getId());
               try {
                     FacesContext.getCurrentInstance().getExternalContext()
                                   .redirect("facturacion.jsf");
               } catch (IOException e) {
                     e.printStackTrace();
               }
        }

 }
	//Examen 1
	public void buscarPrincipales(){
		menues = menuServicio.buscarPrincipales(usuario.getId());
		
	}


	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
