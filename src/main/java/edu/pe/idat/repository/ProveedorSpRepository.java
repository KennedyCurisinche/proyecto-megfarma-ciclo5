package edu.pe.idat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.pe.idat.model.sp.ProveedorSp;

@Repository
public interface ProveedorSpRepository extends JpaRepository<ProveedorSp, String> {

    @Query(value = "{Call sp_MantListarProveedor()}", nativeQuery = true)
    List<ProveedorSp> listarProveedor();
}
