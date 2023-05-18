package edu.pe.idat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.pe.idat.model.Empleado;
import edu.pe.idat.model.response.ResultadoResponse;
import edu.pe.idat.model.sp.EmpleadoSp;
import edu.pe.idat.service.EmpleadoService;
import edu.pe.idat.service.CargoService;

@Controller
@RequestMapping("/Empleado")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoservice;

    @Autowired
    private CargoService cargoservice;

    @GetMapping("/frmMantEmpleado")
    public String frmMantEmpleado(Model model) {
        model.addAttribute("listempleados", empleadoservice.listarEmpleado());
        model.addAttribute("listcargo", cargoservice.listarCargo());
        return "empleado/MantEmpleado";

    }

    @PostMapping("/registrarEmpleado")
    @ResponseBody
    public ResultadoResponse registrarEmpleado(@RequestBody Empleado empleado) {
        String mensaje = "Empleado registrado correctamente";
        Boolean respuesta = true;

        try {
            empleadoservice.registrarEmpleado(empleado);
        } catch (Exception ex) {
            mensaje = "Empleado no registrado";
            respuesta = false;
        }

        return new ResultadoResponse(respuesta, mensaje);
    }

    @DeleteMapping("/eliminarEmpleado")
    @ResponseBody
    public ResultadoResponse eliminarEmpleado(@RequestBody Empleado empleado) {
        String mensaje = "Empleado eliminado correctamente";
        Boolean respuesta = true;
        try {
            empleadoservice.eliminarEmpleado(empleado);
        } catch (Exception ex) {
            mensaje = "Empleado no eliminado";
            respuesta = false;
        }
        return new ResultadoResponse(respuesta, mensaje);
    }

    @GetMapping("/listarEmpleado")
    @ResponseBody
    public List<EmpleadoSp> listarEmpleados() {
        return empleadoservice.listarEmpleado();
    }

}
