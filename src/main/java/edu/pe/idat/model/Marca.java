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
@Table(name = "marca")
public class Marca {

    @Id
    private String idmarca;

    @Column(name = "nombremarca")
    private String nombremarca;
}
