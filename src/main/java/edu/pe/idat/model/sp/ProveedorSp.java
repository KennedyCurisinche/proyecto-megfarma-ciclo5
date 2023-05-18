package edu.pe.idat.model.sp;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ProveedorSp {

    @Id
    private String idproveedor;

    private String nombreproveedor;

    private String rucproveedor;

    private String telefonoproveedor;

    private String direccionproveedor;

    private Integer isactive;

}
