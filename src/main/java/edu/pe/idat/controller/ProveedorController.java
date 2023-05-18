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

import edu.pe.idat.model.Proveedor;
import edu.pe.idat.model.response.ResultadoResponse;
import edu.pe.idat.model.sp.ProveedorSp;
import edu.pe.idat.service.ProveedorService;

@Controller
@RequestMapping("/Proveedor")
public class ProveedorController {

    @Autowired
    private ProveedorService proveedorservice;

    @GetMapping("/frmMantProveedor")
    public String frmMantProveedor(Model model) {
        model.addAttribute("listproveedores", proveedorservice.listarProveedor());

        return "proveedor/MantProveedor";
    }

    @PostMapping("/registrarProveedor")
    @ResponseBody
    public ResultadoResponse registrarProveedor(@RequestBody Proveedor proveedor) {
        String mensaje = "Proveedor registrado correctamente";
        Boolean respuesta = true;

        try {
            proveedorservice.registrarProveedor(proveedor);
        } catch (Exception ex) {
            mensaje = "Proveedor no registrado";
            respuesta = false;
        }

        return new ResultadoResponse(respuesta, mensaje);
    }

    @DeleteMapping("/eliminarProveedor")
    @ResponseBody
    public ResultadoResponse eliminarProveedor(@RequestBody Proveedor proveedor) {
        String mensaje = "Proveedor eliminado correctamente";
        Boolean respuesta = true;
        try {
            proveedorservice.eliminarProveedor(proveedor);
        } catch (Exception ex) {
            mensaje = "Proveedor no eliminado";
            respuesta = false;
        }
        return new ResultadoResponse(respuesta, mensaje);
    }

    @GetMapping("/listarProveedor")
    @ResponseBody
    public List<ProveedorSp> listarProveedores() {
        return proveedorservice.listarProveedor();
    }
}
