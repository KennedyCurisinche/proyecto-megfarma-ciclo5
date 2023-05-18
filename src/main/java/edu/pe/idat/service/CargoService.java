package edu.pe.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.idat.model.Cargo;
import edu.pe.idat.repository.CargoRepository;

@Service
public class CargoService {
    @Autowired
    private CargoRepository cargoRepository;

    public List<Cargo> listarCargo() {
        return cargoRepository.findAll();
    }
}
