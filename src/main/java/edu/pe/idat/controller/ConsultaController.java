package edu.pe.idat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.pe.idat.service.DetalleOrdenService;

@Controller
@RequestMapping("/Consulta")
public class ConsultaController {

	@Autowired
	private DetalleOrdenService service;

	@GetMapping("/empleado")
	public String pedidos(Model model) {
		model.addAttribute("listaconsulta", service.listarorden());
		return "Consulta/listcomprobante";
	}
}
