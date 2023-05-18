package edu.pe.idat.model.sp;

import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ValoracionSp {
	
	@Id
	private Integer idvalor;
	
	private Integer idcli;
	
	private String nomcli;
	
	private String apecli;

	private String corcli;
	
	private String dnicli;
	
	private String calificacion;
	
	}
