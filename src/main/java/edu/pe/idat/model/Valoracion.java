package edu.pe.idat.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "valoracion")
public class Valoracion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="idvalor")
	private Integer idvalor;
	
	@Column(name = "calificacion")
	private String calificacion;
	
	@Column(name = "idcli")
	private Integer idcli;
	
}