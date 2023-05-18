package edu.pe.idat.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.pe.idat.model.Empleado;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, String> {

        @Transactional
        @Modifying
        @Query(value = "{call sp_MantRegistrarEmpleado(:nombreempleado, :apellidoempleado, :sexoempleado, :telefonoempleado,:isactive,:idcargoempleado)}", nativeQuery = true)
        void registrarEmpleado(
                        @Param("nombreempleado") String nombreempleado,
                        @Param("apellidoempleado") String apellidoempleado,
                        @Param("sexoempleado") String sexoempleado,
                        @Param("telefonoempleado") String telefonoempleado,
                        @Param("isactive") Integer isactive,
                        @Param("idcargoempleado") String idcargoempleado);

        @Transactional
        @Modifying
        @Query(value = "{call sp_MantActualizarEmpleado(:idempleado, :nombreempleado, :apellidoempleado, :sexoempleado, :telefonoempleado,:isactive,:idcargoempleado)}", nativeQuery = true)
        void actualizarEmpleado(
                        @Param("idempleado") String idempleado,
                        @Param("nombreempleado") String nombreempleado,
                        @Param("apellidoempleado") String apellidoempleado,
                        @Param("sexoempleado") String sexoempleado,
                        @Param("telefonoempleado") String telefonoempleado,
                        @Param("isactive") Integer isactive,
                        @Param("idcargoempleado") String idcargoempleado);

}
