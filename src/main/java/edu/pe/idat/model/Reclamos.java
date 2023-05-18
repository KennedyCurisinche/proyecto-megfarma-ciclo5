package edu.pe.idat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="reclamos")
public class Reclamos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column (name = "nombre")
	private String nombre;
	
	@Column (name = "apellido")
	private String apellido;
	
	@Column (name = "dni")
	private int dni;
	
	@Column (name = "num_fijo")
	private int num_fijo;
	
	@Column (name = "num_celular")
	private int num_celular;
	
	@Column (name = "correo")
	private String correo;
	
	@Column (name = "motivo")
	private String motivo;
	
	@Column (name = "reclamo")
	private String reclamo;

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

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public int getNum_fijo() {
		return num_fijo;
	}

	public void setNum_fijo(int num_fijo) {
		this.num_fijo = num_fijo;
	}

	public int getNum_celular() {
		return num_celular;
	}

	public void setNum_celular(int num_celular) {
		this.num_celular = num_celular;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getReclamo() {
		return reclamo;
	}

	public void setReclamo(String reclamo) {
		this.reclamo = reclamo;
	}

	public Reclamos(int id, String nombre, String apellido, int dni, int num_fijo, int num_celular, String correo,
			String motivo, String reclamo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.num_fijo = num_fijo;
		this.num_celular = num_celular;
		this.correo = correo;
		this.motivo = motivo;
		this.reclamo = reclamo;
	}

	public Reclamos() {
		
	}
	
	
	
}
