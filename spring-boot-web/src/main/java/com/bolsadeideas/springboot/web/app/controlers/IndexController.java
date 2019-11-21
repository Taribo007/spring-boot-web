package com.bolsadeideas.springboot.web.app.controlers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;



@Controller
@RequestMapping("/app")
public class IndexController {
	
	@Value("${text.IndexController.index.titulo}")
	public String textoIndex;
	@Value("${text.IndexController.perfil.titulo}")
	public String textoPerfil;
	@Value("${text.IndexController.listar.titulo}")
	public String textoListar;
	
	@GetMapping(value= {"/index","/",""})
	//En estas dos sentencias decimmos lo mismo
	//@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index(Model model) {
		//model.addAttribute("titulo","El titulo");
		model.addAttribute("titulo",textoIndex);
		model.addAttribute("titulo2", "este es es titulo 2");
		return "index";
	}
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		Usuario usuario1=new Usuario();
		
		usuario1.setNombre("Andres");
		usuario1.setApellido("Gonzalez");
		usuario1.setEmail("taribo@gmail.com");
		
		//model.addAttribute("titulo","Perfil de un usuario: ".concat(usuario1.getNombre()));
		model.addAttribute("titulo",textoPerfil.concat(usuario1.getNombre()));
		
		model.addAttribute("usuario", usuario1);
		
		
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String listar(Model model) {
		/*List<Usuario> usuarios = new ArrayList<>();
		
		//agregamos eleentoa al array list
		usuarios.add(new Usuario("Nombre1", "Apellido1", "email1@email.com"));
		usuarios.add(new Usuario("Nombre2", "Apellido2", "email2@email.com"));
		usuarios.add(new Usuario("Nombre3", "Apellido3", "email3@email.com"));*/
		
		//Otra opcion, con la clase Arrays, y ele metodo asList
		//List<Usuario> usuarios = Arrays.asList(
		//		new Usuario("Nombre1", "Apellido1", "email1@email.com"),
		//		new Usuario("Nombre2", "Apellido2", "email2@email.com"),
		//		new Usuario("Nombre3", "Apellido3", "email3@email.com"),
		//		new Usuario("Nombre4", "Apellido4", "email4@email.com"));
		
		
		//model.addAttribute("titulo","Lista de usuarios");
		model.addAttribute("titulo",textoListar);
		//model.addAttribute("usuarios", usuarios);
		
		return "listar";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> PoblarUsuarios(){
		List<Usuario> usuarios = Arrays.asList(
				new Usuario("Nombre1", "Apellido1", "email1@email.com"),
				new Usuario("Nombre2", "Apellido2", "email2@email.com"),
				new Usuario("Nombre3", "Apellido3", "email3@email.com"),
				new Usuario("Nombre4", "Apellido4", "email4@email.com"));
		
		return usuarios;
	}
}
