package edu.pe.idat.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.pe.idat.model.Orden;

@Repository
public interface OrdenRepository  extends JpaRepository<Orden,Long>{
	
	@Transactional
	@Modifying
	@Query(value ="{call sp_RegistrarCompraOrden(:_fechaorden,:_totalorden,:_fc_entrega,:_id_cli)}", 
			nativeQuery = true)
	void registrarOrden(@Param("_fechaorden") String fechaorden,
						@Param("_totalorden") Double totalorden,
						@Param("_fc_entrega")String fc_entrega,
						@Param("_id_cli") String id_cli);
	
	@Query(value ="select orden_ultimo()",
			nativeQuery = true)
	String ultimocodOrden();
}
