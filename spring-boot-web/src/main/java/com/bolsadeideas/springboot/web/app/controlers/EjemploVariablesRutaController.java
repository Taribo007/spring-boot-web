package com.bolsadeideas.springboot.web.app.controlers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemploVariablesRutaController {

	
	@GetMapping("/")
	public String index(Model model) {
		
		model.addAttribute("titulo", "Pasamos el titulo");
		return "variables/index";
	}
	
	
	@GetMapping("/string/{texto}")
	public String variables(@PathVariable String texto, Model model) {
		
		model.addAttribute("titulo", "Recibir parametros de ka ryta (@PathVariable)");
		model.addAttribute("resultado", "Con esta metodo pasamos una variable texto: " + texto);
		
		return "variables/ver";
	}
	
	@GetMapping("/string/{texto}/{numero}")
	public String variables(@PathVariable String texto, @PathVariable Integer numero, Model model) {
		
		model.addAttribute("titulo", "Recibir parametros de ka ryta (@PathVariable)");
		model.addAttribute("resultado", "Con esta metodo pasamos una variable texto y una numero: " + texto + " numero: " + numero);
		
		return "variables/ver";
	}
}
