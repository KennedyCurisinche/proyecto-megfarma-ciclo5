package edu.pe.idat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import edu.pe.idat.model.Login;

@Controller
public class LoginController {
	
	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("titulo", "Login");
		model.addAttribute("login", new Login());
		return "login";
	}

	@PostMapping("/login")
	public String ingresoUsuario(@ModelAttribute("acceso") Login login, Model model) {
		//model.addAttribute("titulo", "Login");
		if (login.getUser().equals("megafarma123@gmail.com") && login.getPassword().equals("meFarma123")) {
			return "redirect:/Producto/productos";
		} else if(login.getUser().equals("user@gmail.com") && login.getPassword().equals("admin")){
			return "redirect:/Consulta/empleado";
		}else {
			return "login";
		}
	}

}
