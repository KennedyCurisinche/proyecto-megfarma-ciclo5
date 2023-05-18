package edu.pe.idat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.pe.idat.model.sp.ProductoSp;

@Repository
public interface ProductoSpRepository extends JpaRepository<ProductoSp, String> {
    @Query(value = "{Call sp_MantListarProducto()}", nativeQuery = true)
    List<ProductoSp> listarProducto();
}
