package com.projeto.veiculos.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.veiculos.models.Role;
import com.projeto.veiculos.models.Usuario;
import com.projeto.veiculos.repositories.RoleRepository;
import com.projeto.veiculos.repositories.UsuarioRepository;

@Controller
public class MotoristaController {

	@Autowired
	UsuarioRepository usuarioRp;

	@Autowired
	RoleRepository roleRp;

	// Mapeia a lista de todos os usuários
	@GetMapping("/motoristas")
	public ModelAndView ListaUsuarios() {
		ModelAndView mav = new ModelAndView("usuarios/motorista");
		Iterable<Usuario> usuarios = usuarioRp.findAll();
		mav.addObject("usuarios", usuarios);
		return mav;
	}

	
	// Mapeia o formulário para cadastrar Motoristas
	@GetMapping("/gerente/cadastroMotorista")
	public ModelAndView cadastrarMotorista() {
		ModelAndView mav = new ModelAndView("usuarios/cadastroMotorista");
		return mav;
	}

	@PostMapping("/gerente/salvarMotorista")
	public ModelAndView salvarMotorista(Usuario usuario) {
		ModelAndView mav = new ModelAndView("usuarios/motorista");
		ArrayList<Role> roles = new ArrayList<>();
		roles.add(roleRp.findByName("ROLE_MOTORISTA"));
		usuario.setRoles(roles);
		usuarioRp.save(usuario);
		Iterable<Usuario> usuarios = usuarioRp.findAll();
		mav.addObject("usuarios", usuarios);
		return mav;
	}

	@GetMapping("/gerente/removerusuario/{idusuario}")
	public ModelAndView excluir(@PathVariable("idusuario") Long idusuario) {

		usuarioRp.deleteById(idusuario);

		ModelAndView mav = new ModelAndView("usuarios/usuario");
		List<Role> roles = (List<Role>) roleRp.findAll();
		Iterable<Usuario> usuarios = usuarioRp.findAll();
		mav.addObject("usuarios", usuarios);
		mav.addObject("roles", roles);

		return mav;
	}
}
