package edu.pe.idat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "producto")
public class Producto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_producto")
	private Integer id_producto;

	@Column(name = "imagen_producto")
	private String imagenproducto;

	@Column(name = "nombre_producto")
	private String nombreproducto;

	@Column(name = "prescripcion")
	private String prescripcion;

	@Column(name = "presentacion")
	private String presentacion;

	@Column(name = "precio")
	private Double precio;

	@Column(name = "precio_unitario")
	private Double preciounitario;

	@Column(name = "stock")
	private Integer stock;

	@Column(name = "is_active")
	private Integer isactive;

	@Column(name = "id_categoria_producto")
	private String idcategoria;

	@Column(name = "id_marca_producto")
	private String idmarca;
}
