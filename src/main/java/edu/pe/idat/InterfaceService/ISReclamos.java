package edu.pe.idat.InterfaceService;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import edu.pe.idat.model.Reclamos;

@Repository
public interface ISReclamos {
	public List<Reclamos>listar();
	public Optional<Reclamos>listarId(int id);
	public int save(Reclamos r);
	public void delete(int id);
}
