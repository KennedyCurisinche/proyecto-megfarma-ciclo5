package edu.pe.idat.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.pe.idat.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	@Transactional
    @Modifying
    @Query(value = "{call sp_MantClienteRegistrar(:_nomcli, :_apecli, :_dnicli, :_fc_nac, :_corcli, :_concli)}", nativeQuery = true)
    void registrarProducto(
                    @Param("_nomcli") String _nomcli,
                    @Param("_apecli") String _apecli,
                    @Param("_dnicli") String _dnicli,
                    @Param("_fc_nac") String _fc_nac,
                    @Param("_corcli") String _corcli,
                    @Param("_concli") String _concli);
	
}
