package edu.pe.idat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.pe.idat.model.Cliente;
import edu.pe.idat.model.response.ResClienteResponse;
import edu.pe.idat.model.sp.ClienteSp;
import edu.pe.idat.service.ClienteService;
import edu.pe.idat.service.ProductoService;
import edu.pe.idat.service.ValoracionService;

@Controller
@RequestMapping("/Catalogo")
public class CatalogoController {

	// private final Logger log = (Logger)
	// LoggerFactory.getLogger(CatalogoController.class);

	@Autowired
	private	ValoracionService valoracionservice; 
	
	@Autowired
	private ProductoService productoservice;
	
	@Autowired
	private ClienteService clienteservice;

	public String correousuario, nomcli, apecli, dnicli, corcli, idcli, idvalor, calificacion;

	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("correous", this.correousuario);
		model.addAttribute("nomcli", this.nomcli);
		model.addAttribute("apecli", this.apecli);
		model.addAttribute("dnicli", this.dnicli);
		model.addAttribute("idc", this.idcli);
		model.addAttribute("saludo", "Bienvenido " + this.nomcli + this.apecli);
		model.addAttribute("listproducto", productoservice.listarProductos());
		model.addAttribute("idvalor",this.idvalor);
		model.addAttribute("calificacion",this.calificacion);	
		return "Catalogo/home";
	}

	@GetMapping("/homeinicio") /* Revisar */
	public String Invitado(Model model) {
		return "Catalogo/homeInvitado";
	}

	// Logeo
	@PostMapping("/iniciarsesion")
	public String iniciarsesion(@RequestParam String correo, @RequestParam String contra, Model model) {
		String direccion = "";

		try {
			List<ClienteSp> buscarcliente = clienteservice.buscUsuario(correo, contra);

			this.corcli = buscarcliente.get(0).getCorcli();
			String concli = buscarcliente.get(0).getConcli();
			this.nomcli = buscarcliente.get(0).getNomcli();
			this.apecli = buscarcliente.get(0).getApecli();
			this.dnicli = buscarcliente.get(0).getDnicli();
			this.idcli = buscarcliente.get(0).getIdcli().toString();
			this.idvalor = buscarcliente.get(0).getIdvalor().toString();
			this.calificacion = buscarcliente.get(0).getCalificacion();	

			if (correo.equalsIgnoreCase(corcli) && contra.equals(concli)) {
				this.correousuario = correo.toLowerCase();
				model.addAttribute("correous", correo.toLowerCase());
				model.addAttribute("nomcli", this.nomcli);
				model.addAttribute("apecli", this.apecli);
				model.addAttribute("dnicli", this.dnicli);
				model.addAttribute("idc", this.idcli);
				model.addAttribute("concli", contra);
				model.addAttribute("saludo", "Bienvenido: " + this.nomcli + " " + this.apecli);
				model.addAttribute("listproducto", productoservice.listarProductos());
				model.addAttribute("idvalor",this.idvalor);
				model.addAttribute("calificacion",this.calificacion); 
				direccion += "Catalogo/home";
			} else {
				direccion += "Catalogo/homeInvitado";
			}
		} catch (IndexOutOfBoundsException e) {
			direccion += "Catalogo/homeInvitado";
		}

		return direccion;
	}
	
	//Nuevo Cliente
	@PostMapping("/registrarCliente")
	@ResponseBody
	public ResClienteResponse registrarCliente(@RequestBody Cliente cliente) {
		String mensaje = "Cliente registrado correctamente";
		Boolean respuesta = true;

		try {
			clienteservice.registrarCliente(cliente);
			valoracionservice.registrarvaloracion();
			
		} catch (Exception ex) {
			mensaje = "Cliente no registrado";
			respuesta = false;
		}

		return new ResClienteResponse(respuesta, mensaje);
	}

	@GetMapping("/buscarCorreo")
	@ResponseBody
	public String busCor(String _correo) {
		return clienteservice.encontrarCorreo(_correo);
	}
	
	@GetMapping("/buscarDNI")
	@ResponseBody
	public String busDni(String _dni) {
		return clienteservice.encontrarDNI(_dni);
	}
	
	//Actualizar Contraseña Usuario
	@PostMapping("/ActualizarCli")
	public String actualizarCliente(@RequestParam Integer idcli, @RequestParam String concli,
			@RequestParam String compararcon, @RequestParam String nuevacon) {
		//System.out.format("%d %s %s %s",idcli,concli,compararcon,nuevacon);
		if(concli.equals(compararcon)) {
			clienteservice.actualizarContra(idcli, nuevacon);
		}else {
			return "redirect:/Catalogo/home";
		}
		
		return"/Catalogo/homeInvitado";
	}
	
}
