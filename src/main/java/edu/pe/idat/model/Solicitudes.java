package edu.pe.idat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="solicitudes")
public class Solicitudes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column (name = "nombre")
	private String nombre;
	
	@Column (name = "apellido")
	private String apellido;
	
	@Column (name = "direccion")
	private String direccion;
	
	@Column (name = "tipo_documento")
	private String tipo_documento;
	
	@Column (name = "num_documento")
	private String num_documento;
	
	@Column (name = "correo")
	private String correo;
	
	@Column (name = "solicitud")
	private String solicitud;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTipo_documento() {
		return tipo_documento;
	}

	public void setTipo_documento(String tipo_documento) {
		this.tipo_documento = tipo_documento;
	}

	public String getNum_documento() {
		return num_documento;
	}

	public void setNum_documento(String num_documento) {
		this.num_documento = num_documento;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getSolicitud() {
		return solicitud;
	}

	public void setSolicitud(String solicitud) {
		this.solicitud = solicitud;
	}

	public Solicitudes(int id, String nombre, String apellido, String direccion, String tipo_documento,
			String num_documento, String correo, String solicitud) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.direccion = direccion;
		this.tipo_documento = tipo_documento;
		this.num_documento = num_documento;
		this.correo = correo;
		this.solicitud = solicitud;
	}

	public Solicitudes() {
		
	}
	
	
	
	
}
