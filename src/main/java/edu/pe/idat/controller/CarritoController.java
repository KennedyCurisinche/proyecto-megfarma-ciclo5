package edu.pe.idat.controller;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.pe.idat.model.DetalleOrden;
import edu.pe.idat.model.Orden;
import edu.pe.idat.model.Producto;
import edu.pe.idat.service.DetalleOrdenService;
import edu.pe.idat.service.OrdenService;
import edu.pe.idat.service.ProductoService;
import edu.pe.idat.service.others.email.Email;
import edu.pe.idat.service.others.email.EmailSenderService;

@Controller
@RequestMapping("/Detalles")
public class CarritoController {

	@Autowired
	private ProductoService productoservice;

	@Autowired
	private DetalleOrdenService detalleservice;

	@Autowired
	private OrdenService ordenservice;

	@Autowired
	private EmailSenderService mail;

	CatalogoController catalogo = new CatalogoController();
	
	// almacenar los detalles de la orden
	List<DetalleOrden> detalles = new ArrayList<>();

	// datos de la orden
	Orden orden = new Orden();

	Double sumaTotal = 0.0;

	DecimalFormatSymbols df = new DecimalFormatSymbols();
	String nomcli, apecli, dnicli, corcli, idcli;
	
	@GetMapping("/cart")
	public String carrito(Model model) {
		model.addAttribute("agregados", detalles);
		model.addAttribute("orden", orden);
		model.addAttribute("correous", this.corcli);
		model.addAttribute("envio", new Email());
		return "Catalogo/carrito";
	}

	@PostMapping("/carrito")
	public String addCarrito(@RequestParam Integer id, @RequestParam Integer cantidad, @RequestParam String nombres, @RequestParam String apellido, @RequestParam String dni, @RequestParam String correo, @RequestParam String idc, Model model) {
		DetalleOrden detallOrden = new DetalleOrden();
		Producto producto = new Producto();

		if (cantidad >= 1) {
			sumaTotal = 0.0;

			Optional<Producto> optionalProducto = productoservice.get(id);

			producto = optionalProducto.get();

			detallOrden.setCanpro(cantidad);
			detallOrden.setPrecpro(producto.getPreciounitario());
			detallOrden.setNompro(producto.getNombreproducto());

			df.setDecimalSeparator('.');

			DecimalFormat conver = new DecimalFormat("#.00", df);

			Double totales = Double.valueOf(conver.format(producto.getPreciounitario() * cantidad));
			detallOrden.setTotal(totales);

			detallOrden.setId_producto(producto.getId_producto());

			detalles.add(detallOrden);

			sumaTotal = Double.valueOf(conver.format(detalles.stream().mapToDouble(dt -> dt.getTotal()).sum()));

			orden.setTotalorden(sumaTotal);

			model.addAttribute("agregados", detalles);
			model.addAttribute("orden", orden);
			model.addAttribute("correous", correo);
			this.nomcli = nombres; 
			this.apecli = apellido;
			this.corcli = correo; 
			this.dnicli = dni;
			this.idcli= idc;
			
			return "Catalogo/carrito";

		} else {
			return "redirect:/Catalogo/home";
		}
	}

	// Ojo al eliminar esa id eliminas todo los productos que tenga esa id, es decir
	// si hay productos repetitivos
	// esos productos se eliminaran

	@GetMapping("/eliminarProducto/{id}")
	public String eliminarProducto(@PathVariable Integer id, Model model) {
		model.addAttribute("correous", this.corcli);
		List<DetalleOrden> ordenNuevo = new ArrayList<>();

		for (DetalleOrden nuevo : detalles) {
			if (nuevo.getId_producto() != id) {
				// Imprimo en consola para saber que ids estan en linea por el momento

				// System.out.format("ID: %d NOM: %s CAN: %d PCUN: %f T:%f IDP: %d IDO: %d \n",
				// nuevo.getIddetalleorden(),
				// nuevo.getNompro(), nuevo.getCanpro(), nuevo.getPrecpro(),
				// nuevo.getTotal(), nuevo.getId_producto(), nuevo.getId_compraorden());

				ordenNuevo.add(nuevo);
			}
		}

		detalles = ordenNuevo;

		// DecimalFormatSymbols df = new DecimalFormatSymbols();
		df.setDecimalSeparator('.');

		DecimalFormat conver = new DecimalFormat("#.00", df);

		sumaTotal = Double.valueOf(conver.format(detalles.stream().mapToDouble(dt -> dt.getTotal()).sum()));

		orden.setTotalorden(sumaTotal);

		model.addAttribute("agregados", detalles);
		model.addAttribute("orden", orden);

		return "Catalogo/carrito";
	}

	@PostMapping("/envioexitoso")
	public String enviacorreo(@ModelAttribute("envio") Email email, Model model) {

		registroExitoso(email.getRecojo());
		
		String ultima = ordenservice.ultima();
		
		//mail.sendEmail(email.getDni(), email.getCorreo(), email.getNombre(), ultima, email.getRuta());
		mail.sendEmail(this.dnicli, this.corcli, this.nomcli+' '+ this.apecli, ultima, email.getRuta());
		
		return "redirect:/Catalogo/home";
	}
	
	@PostMapping("/despacho")
	public String despacho(Model model) {
		model.addAttribute("agregados", detalles);
		model.addAttribute("orden", orden);
		model.addAttribute("correous", this.corcli);
		model.addAttribute("nombre", this.nomcli);
		model.addAttribute("apellido", this.apecli);
		return "Catalogo/despacho";
	}
	
	private void registroExitoso(String recojo) {
		ordenservice.registrar(sumaTotal, recojo, this.idcli);

		for (DetalleOrden detalleOrden : detalles) {

			detalleservice.registrardatalle(detalleOrden);

		}
	}
	
}

