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
@Table(name = "empleado")
public class Empleado {

    @Id
    private String idempleado;

    @Column(name = "nombreempleado")
    private String nombre;

    @Column(name = "apellidoempleado")
    private String apellido;

    @Column(name = "sexoempleado")
    private String sexo;

    @Column(name = "telefonoempleado")
    private String telefono;

    @Column(name = "isactive")
    private Integer isactive;

    @Column(name = "idcargoempleado")
    private String idcargo;

}
