package com.bolsadeideas.springboot.web.app.controlers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params") 
public class EjemploParamsControler {

	@GetMapping("/string")
	//public String param(@RequestParam String paramTexto, Model model) {
	public String param(@RequestParam(name="paramTexto",required=false,defaultValue="valor por defecto") String paramTexto, Model model) {
		
		model.addAttribute("resultado","El texto mostrado es " + paramTexto);
		return "params/ver";
	}
	
	@GetMapping("/")
	//public String param(@RequestParam String paramTexto, Model model) {
	public String index() {
		
		return "params/index";
	}
	
	@GetMapping("/mix-params")
	//public String param(@RequestParam String paramTexto, Model model) {
	public String param(@RequestParam String saludo,Integer numero, Model model) {
		
		model.addAttribute("resultado","El saludo mostrado es: " + saludo + " el  numero es: " + numero);
		return "params/ver";
	}
	
	@GetMapping("/mix-params-request")
	//public String param(@RequestParam String paramTexto, Model model) {
	public String param(HttpServletRequest request, Model model) {
		
		Integer numero=null;
		
		String saludo=request.getParameter("saludo");
		try{
			numero=Integer.parseInt(request.getParameter("numero"));
		}catch(NumberFormatException e){
			numero=0;
		}
		
		model.addAttribute("resultado","El saludo mostrado es: " + saludo + " el  numero es: " + numero);
		return "params/ver";
	}
}


