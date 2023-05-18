package edu.pe.idat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.pe.idat.model.Empleado;
import edu.pe.idat.model.sp.EmpleadoSp;
import edu.pe.idat.repository.EmpleadoRepository;
import edu.pe.idat.repository.EmpleadoSpRepository;

@Service
public class EmpleadoService {

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private EmpleadoSpRepository empleadoSpRepository;

    public List<EmpleadoSp> listarEmpleado() {
        return empleadoSpRepository.listarEmpleado();
    }

    public void registrarEmpleado(Empleado empleado) {
        if (empleado.getIdempleado().equals("0")) {
            empleadoRepository.registrarEmpleado(
                    empleado.getNombre(),
                    empleado.getApellido(),
                    empleado.getSexo(),
                    empleado.getTelefono(),
                    empleado.getIsactive(),
                    empleado.getIdcargo());
        } else {
            empleadoRepository.actualizarEmpleado(
                    empleado.getIdempleado(),
                    empleado.getNombre(),
                    empleado.getApellido(),
                    empleado.getSexo(),
                    empleado.getTelefono(),
                    empleado.getIsactive(),
                    empleado.getIdcargo());
        }
    }

    public void eliminarEmpleado(Empleado empleado) {
        empleadoRepository.deleteById(empleado.getIdempleado());
    }
}
