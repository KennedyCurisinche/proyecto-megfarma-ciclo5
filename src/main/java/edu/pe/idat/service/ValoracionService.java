package edu.pe.idat.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.pe.idat.model.Valoracion;
import edu.pe.idat.model.sp.ValoracionSp;
import edu.pe.idat.repository.ValoracionRepository;
import edu.pe.idat.repository.ValoracionSpRepository;

@Service
public class ValoracionService {
	
	@Autowired
	private ValoracionRepository repository;
	
	@Autowired
	private ValoracionSpRepository repositorysp;
	
	public void registrarvaloracion() {
			repository.registrarValoracion();
			
	}
	public void actualizarValoracion(Valoracion valoract) {
		repository.actualizarValoracion(
				valoract.getIdcli(),
				valoract.getCalificacion());
	}
	
			
	
	public List<ValoracionSp> listarvalores(){
	return repositorysp.listarValores();
	}
	
	
}
