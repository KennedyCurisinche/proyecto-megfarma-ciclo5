package edu.pe.idat.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.idat.Interface.ReclamosInterface;
import edu.pe.idat.InterfaceService.ISReclamos;
import edu.pe.idat.model.Reclamos;


@Service
public class ReclamosService implements ISReclamos{
	@Autowired
	private ReclamosInterface data;

	@Override
	public List<Reclamos> listar() {
		return (List<Reclamos>)data.findAll();
	}

	@Override
	public Optional<Reclamos> listarId(int id) {
		return data.findById(id);
	}

	@Override
	public int save(Reclamos r) {
		int res=0;
		Reclamos reclamos=data.save(r);
		if(!reclamos.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);
		
	}
}
