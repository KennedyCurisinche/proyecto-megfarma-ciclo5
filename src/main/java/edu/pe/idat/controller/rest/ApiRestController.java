package edu.pe.idat.controller.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//@CrossOrigin(origins = "http://localhost:8095")
@RestController
@RequestMapping("/rest")
public class ApiRestController {
	
	@GetMapping(value ="/dni/{documento}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public Object verDni(@PathVariable("documento") String documento){
		Object dni = null;
		try {
			String url = "https://api.apis.net.pe/v1/dni?numero="+documento;
			RestTemplate rst = new RestTemplate();
			dni = rst.getForObject(url, Object.class);
		} catch (Exception e) {
			//
		}
		return dni;
	}
}
