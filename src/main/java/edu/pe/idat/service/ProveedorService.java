package edu.pe.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.idat.model.Proveedor;
import edu.pe.idat.model.sp.ProveedorSp;
import edu.pe.idat.repository.ProveedorRepository;
import edu.pe.idat.repository.ProveedorSpRepository;

@Service
public class ProveedorService {

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Autowired
    private ProveedorSpRepository proveedorSpRepository;

    public List<ProveedorSp> listarProveedor() {
        return proveedorSpRepository.listarProveedor();
    }

    public void registrarProveedor(Proveedor proveedor) {
        if (proveedor.getIdproveedor().equals("0")) {
            proveedorRepository.registrarProveedor(proveedor.getNombre(),
                    proveedor.getRuc(),
                    proveedor.getTelefono(),
                    proveedor.getDireccion(),
                    proveedor.getIsactive());
        } else {
            proveedorRepository.actualizarProveedor(proveedor.getIdproveedor(),
                    proveedor.getNombre(),
                    proveedor.getRuc(),
                    proveedor.getTelefono(),
                    proveedor.getDireccion(),
                    proveedor.getIsactive());
        }

    }

    public void eliminarProveedor(Proveedor proveedor) {
        proveedorRepository.deleteById(proveedor.getIdproveedor());
    }

}
