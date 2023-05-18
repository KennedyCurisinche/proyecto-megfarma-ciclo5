package edu.pe.idat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idcli")
	private Long idcli;
	@Column(name = "nomcli")
	private String nomcli;
	@Column(name = "apecli")
	private String apecli;
	@Column(name = "dnicli")
	private String dnicli;
	@Column(name = "fc_nac")
	private String fc_nac;
	@Column(name = "corcli")
	private String corcli;
	@Column(name = "concli")
	private String concli;
	
}
