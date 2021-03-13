package com.projeto.veiculos.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.veiculos.models.Role;
import com.projeto.veiculos.models.Usuario;
import com.projeto.veiculos.repositories.RoleRepository;
import com.projeto.veiculos.repositories.UsuarioRepository;

@Controller
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRp;
	
	@Autowired
	RoleRepository roleRp;
	
	@GetMapping("/usuario")
	public ModelAndView ListaUsuarios() {
		ModelAndView mav = new ModelAndView("usuarios/usuario");
		Iterable<Usuario> usuarios = usuarioRp.findAll();
		mav.addObject("usuarios", usuarios);
		return mav;
	}
	
	/*  */
	@GetMapping("/motorista")
	public ModelAndView ListaMotorista() {
		ModelAndView mav = new ModelAndView("usuarios/motorista");
		Iterable<Usuario> usuarios = usuarioRp.findAll();
		mav.addObject("usuarios", usuarios);
		return mav;
	}
	
	@GetMapping("/cadastroUsuario")
	public ModelAndView cadastrarUsuario() {
		Usuario usuario = new Usuario();
		ModelAndView mav = new ModelAndView("usuarios/cadastroUsuario");
		mav.addObject("usuario", usuario);
		List<Role> roles = (List<Role>) roleRp.findAll();
		mav.addObject("roles", roles);
		return mav;
	}
	
	@PostMapping("/salvarUsuario")
	public ModelAndView salvarUsuario(Usuario usuario)  {
			ModelAndView mav = new ModelAndView("usuarios/usuario");
			usuarioRp.save(usuario);
			Iterable<Usuario> usuarios = usuarioRp.findAll();
			mav.addObject("usuarios", usuarios);
			return mav;
		}

}
