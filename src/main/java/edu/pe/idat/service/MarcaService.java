package edu.pe.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.idat.model.Marca;
import edu.pe.idat.repository.MarcaRepository;

@Service
public class MarcaService {
    @Autowired
    private MarcaRepository marcarepository;

    public List<Marca> listarMarca() {
        return marcarepository.findAll();
    }
}
