package edu.pe.idat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "proveedor")
public class Proveedor {

    @Id
    private String idproveedor;

    @Column(name = "nombreproveedor")
    private String nombre;

    @Column(name = "rucproveedor")
    private String ruc;

    @Column(name = "telefonoproveedor")
    private String telefono;

    @Column(name = "direccionproveedor")
    private String direccion;

    @Column(name = "isactive")
    private Integer isactive;
}
