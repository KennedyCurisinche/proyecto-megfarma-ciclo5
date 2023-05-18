package edu.pe.idat.model.sp;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ClienteSp {

	@Id
	private Long idcli;
	private String corcli;
	private String nomcli;
	private String apecli;
	private String dnicli;
	private String concli;
	private String idvalor;
	private String calificacion; 
}
