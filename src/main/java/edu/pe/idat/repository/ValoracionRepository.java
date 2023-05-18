package edu.pe.idat.repository;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import edu.pe.idat.model.Valoracion;

public interface ValoracionRepository extends JpaRepository<Valoracion,Integer>{
	
	@Transactional
	@Modifying
	@Query(value = "{call sp_MantRegistrarvaloracion()}",
		nativeQuery = true)
	void registrarValoracion();
	
	@Transactional
	@Modifying
	@Query(value = "{call sp_MantActualizarValoracion(:_idcli,:_calificacion)}",
		nativeQuery = true)
	void actualizarValoracion(@Param("_idcli") Integer idcli,
	@Param("_calificacion") String calificacion);
}