package cursojpa.facturacion.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name = "categoria"), no es obligatorio; ya que la tabla se llama igual (implicito)
public class Categoria {

	@Id
	//TODO: Mapear AutoGenerado
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@Column(name = "id")  implicito
	private Integer id;

	//@Column(name = "nombre") implicito
	private String nombre;

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

	@Override
	public String toString() {
		return "Categoria [id=" + id + ", nombre=" + nombre + "]";
	}
	
	
	

}
