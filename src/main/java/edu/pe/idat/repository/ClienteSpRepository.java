package edu.pe.idat.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import edu.pe.idat.model.sp.ClienteSp;

public interface ClienteSpRepository  extends JpaRepository<ClienteSp, Long>{
	
	@Query(value = "{call sp_MantClienteLogin(:_corcli, :_concli)}", nativeQuery = true)
    List<ClienteSp> validarLogin(@Param("_corcli") String _corcli,
    												@Param("_concli") String _concli);
	
	@Query(value ="select buscCorCliente(:_corcli)",
			nativeQuery = true)
	String repiteCorreo(@Param("_corcli") String _corcli);
	
	@Query(value ="select buscDNICliente(:_dnicli)",
			nativeQuery = true)
	String repiteDNI(@Param("_dnicli") String _dnicli);
	
	@Transactional
    @Modifying
	@Query(value = "{call sp_MantActualizarConCli(:_idcli, :_concli)}", nativeQuery =true)
	void actualizarContraseña(
			@Param("_idcli") Integer _idcli,
			@Param("_concli") String _concli);
	
}
