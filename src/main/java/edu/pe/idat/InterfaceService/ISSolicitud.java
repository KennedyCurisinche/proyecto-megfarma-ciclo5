package edu.pe.idat.InterfaceService;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import edu.pe.idat.model.Solicitudes;

@Repository
public interface ISSolicitud {
	public List<Solicitudes>listar();
	public Optional<Solicitudes>listarId(int id);
	public int save(Solicitudes s);
	public void delete(int id);
}
