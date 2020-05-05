package cursos.jpa.controladores;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;

import curso.jpa.servicios.EventoServicio;
import cursos.jpa.entidades.Evento;




@ManagedBean
public class EventoControlador {

	private Evento evento;
	
	public EventoControlador(){
		evento = new Evento();
	}
	
	
	@EJB
	private EventoServicio eventoServicio;
	
	public void insertar(){
		//evento.setId(9);  //Error: detached entity passed to persist - al intentar guardar un objeto con id autogenerado
		eventoServicio.insertar(evento);
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	
	
}
