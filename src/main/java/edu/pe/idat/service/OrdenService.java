package edu.pe.idat.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.idat.repository.OrdenRepository;

@Service
public class OrdenService {
	
	@Autowired
	private OrdenRepository repository;
	
	public void registrar(Double totalorden, String fc_entrega, String id_cli) {  
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		
        repository.registrarOrden((dtf.format(LocalDateTime.now())), totalorden, fc_entrega, id_cli);
	}
	
	public String ultima(){
		return repository.ultimocodOrden();
	}
}
