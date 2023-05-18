package edu.pe.idat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.pe.idat.model.sp.EmpleadoSp;

@Repository
public interface EmpleadoSpRepository extends JpaRepository<EmpleadoSp, String> {

    @Query(value = "{Call sp_MantListarEmpleado()}", nativeQuery = true)
    List<EmpleadoSp> listarEmpleado();

}
