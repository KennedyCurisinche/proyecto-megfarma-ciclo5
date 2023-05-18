package edu.pe.idat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.pe.idat.model.Cliente;
import edu.pe.idat.service.ClienteService;

@Controller
@RequestMapping("/Cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteSe;
	
	@GetMapping("/listar")
	public String ListarClientes(Model model) {
		List<Cliente>cliente=clienteSe.listar();
		model.addAttribute("listarCli", cliente);
		return"/cliente/LClientes";
	}

}
