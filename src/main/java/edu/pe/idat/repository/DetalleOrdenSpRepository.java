package edu.pe.idat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.pe.idat.model.sp.DetalleOrdenSp;

public interface DetalleOrdenSpRepository extends JpaRepository<DetalleOrdenSp, Long>{
	
	@Query(value = "{Call sp_ListSPDetalleOrden()}", nativeQuery = true)
    List<DetalleOrdenSp> listarConsulta();
}
