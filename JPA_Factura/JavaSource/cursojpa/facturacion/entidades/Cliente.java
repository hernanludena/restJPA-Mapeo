package cursojpa.facturacion.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//TODO:mapear entidad completa

@Entity
//@Table(name = "cliente") nombre_implicito
public class Cliente {

	@Id
	//@Column(name = "cedula")
	private String cedula;

	//@Column(name = "nombre")
	private String nombre;

	//@Column(name = "apellido")
	private String apellido;

	//@Column(name = "telefono")
	private String telefono;

	//@Column(name = "direccion")
	private String direccion;

	public Cliente() {
		
	}

	public Cliente(String cedula) {
		super();
		this.cedula = cedula;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Cliente [cedula=" + cedula + ", nombre=" + nombre
				+ ", apellido=" + apellido + ", telefono=" + telefono
				+ ", direccion=" + direccion + "]";
	}
	

}
