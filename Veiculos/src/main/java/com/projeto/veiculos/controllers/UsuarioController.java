package com.projeto.veiculos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.veiculos.models.Usuario;
import com.projeto.veiculos.repositories.UsuarioRepository;

@Controller
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRp;
	
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
	

}
