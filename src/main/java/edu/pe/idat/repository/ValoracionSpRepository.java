package edu.pe.idat.repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import edu.pe.idat.model.sp.ValoracionSp;

public interface ValoracionSpRepository extends JpaRepository<ValoracionSp,Integer>{
	
	@Query(value = "{Call sp_MantListarValoracion()}",nativeQuery = true)
	List<ValoracionSp> listarValores();
	
}