package edu.pe.idat.AtencionControlller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.pe.idat.InterfaceService.ISSolicitud;

import edu.pe.idat.model.Solicitudes;

@Controller
@RequestMapping("/Solicitud")
public class SolicitudesController {

	@Autowired
	private ISSolicitud service;
	
	@GetMapping("/listar_solicitudes")
	public String listar(Model model) {
		model.addAttribute("solicitud", service.listar());
		return "/Atencion/GestionarSolicitudes";
	}
	
	@GetMapping("/ingreso")
	public String agregar(Model model) {
		model.addAttribute("solicitud", new Solicitudes());
		return "/Atencion/solicitudes";
	}
	
	@PostMapping("/save_solicitudes")
	public String save(@Validated Solicitudes s, Model model) {
		service.save(s);
		return "redirect:/Catalogo/homeinicio";
	}
	
	/*eliminar*/
	/* @GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Solicitudes>solicitud=service.listarId(id);
		model.addAttribute("solicitud", solicitud);
		return "";
	} 
	 
	 @GetMapping("/eliminar/{id}")
		public String delete(Model model, @PathVariable int id) {
			service.delete(id);
			return "redirect:/listar";
		}*/
	
}
