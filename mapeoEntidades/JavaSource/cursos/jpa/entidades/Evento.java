package cursos.jpa.entidades;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "eventos")
public class Evento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)  //No todas las bases soportan IDENTITY (no es estandar)
	@Column(name = "ev_id serial")
	private Integer id;  //por defaul null
	
	@Column(name = "ev_nombre")
	private String nombre;
	
	@Column(name = "ev_fecha")
	private Date fecha;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	@Override
	public String toString() {
		return "Evento [id=" + id + ", nombre=" + nombre + ", fecha="
				+ fecha + "]";
	}
}
