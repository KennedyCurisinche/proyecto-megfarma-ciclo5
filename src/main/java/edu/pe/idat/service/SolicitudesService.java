package edu.pe.idat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.idat.Interface.SolicitudInterface;
import edu.pe.idat.InterfaceService.ISSolicitud;
import edu.pe.idat.model.Solicitudes;


@Service
public class SolicitudesService implements ISSolicitud{
	
	@Autowired
	private SolicitudInterface data;

	@Override
	public List<Solicitudes> listar() {
		return (List<Solicitudes>)data.findAll();

	}

	@Override
	public Optional<Solicitudes> listarId(int id) {
		return data.findById(id);
	}

	@Override
	public int save(Solicitudes s) {
		int res=0;
		Solicitudes solicitudes=data.save(s);
		if(!solicitudes.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int id) {data.deleteById(id);// TODO Auto-generated method stub
		
	}  
}
