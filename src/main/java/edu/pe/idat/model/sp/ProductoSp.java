package edu.pe.idat.model.sp;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ProductoSp {

    @Id
    private String id_producto;

    private String imagen_producto;

    private String nombre_producto;

    private String prescripcion;

    private String presentacion;

    private Double precio;

    private Double precio_unitario;

    private Integer stock;

    private Integer is_active;

    private String id_categoria_producto;

    private String nombrecategoria;

    private String id_marca_producto;

    private String nombremarca;

}
