package curso.jpa.servicios;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import cursos.jpa.entidades.Evento;



@Stateless
public class EventoServicio {
	
	
	@PersistenceContext
	private EntityManager em;
	
	public void insertar(Evento evento){
		em.persist(evento);
	}

}
