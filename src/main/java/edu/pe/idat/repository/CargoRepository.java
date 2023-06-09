package edu.pe.idat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.pe.idat.model.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, String> {

}
