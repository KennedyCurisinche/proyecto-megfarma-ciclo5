package edu.pe.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.idat.model.Cliente;
import edu.pe.idat.model.sp.ClienteSp;
import edu.pe.idat.repository.ClienteRepository;
import edu.pe.idat.repository.ClienteSpRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	@Autowired
	private ClienteSpRepository repositorysp;
	
	//Nuevo usuario
	public void registrarCliente(Cliente c) {
		repository.registrarProducto(c.getNomcli(), c.getApecli(), c.getDnicli(), c.getFc_nac(), c.getCorcli(), c.getConcli());
	}
	
	//Logeo
	public List<ClienteSp> buscUsuario(String correo, String contra){
		return repositorysp.validarLogin(correo, contra);
	}
	
	//Buscar CORREO
	public String encontrarCorreo(String _corcli) {
		return repositorysp.repiteCorreo(_corcli);
	}
	
	//Buscar DNI
	public String encontrarDNI(String _dnicli) {
		return repositorysp.repiteDNI(_dnicli);
	}
	
	public void actualizarContra(Integer _idcli, String _concli) {
		repositorysp.actualizarContraseña(_idcli, _concli);
	}
	
	//Listar cliente
	public List<Cliente> listar(){
		return(List<Cliente>)repository.findAll();
	}
	
	
}
