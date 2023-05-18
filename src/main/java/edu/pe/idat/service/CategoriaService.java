package edu.pe.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.idat.model.Categoria;
import edu.pe.idat.repository.CategoriaRepository;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriarepository;

    public List<Categoria> listarCategoria() {
        return categoriarepository.findAll();
    }

}
