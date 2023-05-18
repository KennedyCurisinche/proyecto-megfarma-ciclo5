package edu.pe.idat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.pe.idat.model.Valoracion;
import edu.pe.idat.model.response.ResultadoResponse;
import edu.pe.idat.service.ValoracionService;

@Controller
@RequestMapping("Valoracion")
public class ValoracionController {
	
	@Autowired
	private ValoracionService service;
	
	@GetMapping("/listar")
	public String valores(Model model) {
			model.addAttribute("listvalores",service.listarvalores());
			return "Valoracion/ListCalificacion";
	}
	
	@PostMapping("/registrarvaloramiento")
    @ResponseBody
    public ResultadoResponse registrarValoramiento(@RequestBody Valoracion valores) {
        String mensaje = "Califiacion exitosa";
        Boolean respuesta = true;

        try {
            service.actualizarValoracion(valores);
        } catch (Exception ex) {
            mensaje = "Califiacion no registrado";
            respuesta = false;
        }

        return new ResultadoResponse(respuesta, mensaje);
    }
	
}
