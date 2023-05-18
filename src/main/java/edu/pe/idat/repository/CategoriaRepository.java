package edu.pe.idat.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.pe.idat.model.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, String> {

}
