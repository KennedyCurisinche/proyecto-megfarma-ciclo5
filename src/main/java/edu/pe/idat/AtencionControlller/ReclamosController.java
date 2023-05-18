package edu.pe.idat.AtencionControlller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.pe.idat.InterfaceService.ISReclamos;
import edu.pe.idat.model.Reclamos;


@Controller
@RequestMapping("/Atencion")
public class ReclamosController {
	
	@Autowired
	private ISReclamos service;
	
	@GetMapping("/reclamos")
	public String listar(Model model) {
		List<Reclamos>reclamos=service.listar();
		model.addAttribute("reclamos", reclamos);
		return "Atencion/GestionarReclamos";
	}
	
	/*  en el formulario LReclamaciones  */
	@GetMapping("/LReclamaciones")
	public String agregar(Model model) {
		model.addAttribute("fecha", LocalDateTime.now());
		model.addAttribute("reclamos", new Reclamos());
		return "/Atencion/LReclamaciones";
	}
	
	@PostMapping("/guardar")
	public String save(@Validated Reclamos e, Model model) {
		service.save(e);
		return "redirect:/Catalogo/homeinicio";
	}
	
	 @GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Reclamos>reclamos=service.listarId(id);
		model.addAttribute("reclamos", reclamos);
		return "";
	} 
	
	@GetMapping("/eliminar/{id}")
	public String delete(Model model, @PathVariable int id) {
		service.delete(id);
		return "redirect:/listar";
	}
	
	
	
	
}
