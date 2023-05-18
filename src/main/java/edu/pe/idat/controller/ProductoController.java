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

import edu.pe.idat.model.Producto;
import edu.pe.idat.model.response.ResultadoResponse;
import edu.pe.idat.model.sp.ProductoSp;
import edu.pe.idat.service.CategoriaService;
import edu.pe.idat.service.MarcaService;
import edu.pe.idat.service.ProductoService;

@Controller
@RequestMapping("/Producto")
public class ProductoController {

    @Autowired
    private ProductoService productoservice;

    @Autowired
    private CategoriaService categoriaservice;

    @Autowired
    private MarcaService marcaservice;

    @GetMapping("/productos")
    public String listarProductos(Model model) {
        model.addAttribute("titulo", "Listar Productos");
        model.addAttribute("listproductos", productoservice.listarProductos());
        model.addAttribute("listcategoria", categoriaservice.listarCategoria());
        model.addAttribute("listmarca", marcaservice.listarMarca());
        return "producto/MantProducto";
    }

    @PostMapping("/registrarProducto")
    @ResponseBody
    public ResultadoResponse registrarEmpleado(@RequestBody Producto producto) {
        String mensaje = "Producto registrado correctamente";
        Boolean respuesta = true;

        try {
            productoservice.registrarProducto(producto);
        } catch (Exception ex) {
            mensaje = "Producto no registrado";
            respuesta = false;
        }

        return new ResultadoResponse(respuesta, mensaje);
    }

    @DeleteMapping("/eliminarProducto")
    @ResponseBody
    public ResultadoResponse eliminarProducto(@RequestBody Producto producto) {
        String mensaje = "Producto eliminado correctamente";
        Boolean respuesta = true;
        try {
            productoservice.eliminarProducto(producto);
        } catch (Exception ex) {
            mensaje = "Producto no eliminado";
            respuesta = false;
        }
        return new ResultadoResponse(respuesta, mensaje);
    }

    @GetMapping("/listarProducto")
    @ResponseBody
    public List<ProductoSp> listarproductos() {
        return productoservice.listarProductos();
    }

}
