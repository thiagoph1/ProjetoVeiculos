package com.projeto.veiculos.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRp;

	@Autowired
	RoleRepository roleRp;

	// Mapeia a lista de todos os usuários
	@GetMapping("/usuarios")
	public ModelAndView ListaUsuarios() {
		ModelAndView mav = new ModelAndView("usuarios/usuario");
		Iterable<Usuario> usuarios = usuarioRp.findAll();
		mav.addObject("usuarios", usuarios);
		return mav;
	}

	// Mapeia o formulário para cadastrar Administradores
	@GetMapping("/cadastroAdmin")
	public ModelAndView cadastrarAdmin() {
		ModelAndView mav = new ModelAndView("usuarios/cadastroAdmin");
		mav.addObject("usuario", new Usuario());
		return mav;
	}
	
	// Mapeia o formulário para cadastrar Gerentes
	@GetMapping("/cadastroGerente")
	public ModelAndView cadastrarGerente() {
		ModelAndView mav = new ModelAndView("usuarios/cadastroGerente");
		mav.addObject("usuario", new Usuario());
		return mav;
	}
	
	// Mapeia o formulário para cadastrar Motoristas
	@GetMapping("/cadastroMotorista")
	public ModelAndView cadastrarMotorista() {
		ModelAndView mav = new ModelAndView("usuarios/cadastroMotorista");
		mav.addObject("usuario", new Usuario());
		return mav;
	}

	@PostMapping("/salvarAdmin")
	public ModelAndView salvarAdmin(Usuario usuario) {
		ModelAndView mav = new ModelAndView("usuarios/usuario");
		ArrayList<Role> roles = new ArrayList<>();
		roles.add(roleRp.findByName("ROLE_ADMIN"));
		usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
		usuario.setRoles(roles);
		usuarioRp.save(usuario);
		Iterable<Usuario> usuarios = usuarioRp.findAll();
		mav.addObject("usuarios", usuarios);
		return mav;
	}
	
	@PostMapping("/salvarGerente")
	public ModelAndView salvarGerente(Usuario usuario) {
		ModelAndView mav = new ModelAndView("usuarios/usuario");
		ArrayList<Role> roles = new ArrayList<>();
		roles.add(roleRp.findByName("ROLE_GERENTE"));
		usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
		usuario.setRoles(roles);
		usuarioRp.save(usuario);
		Iterable<Usuario> usuarios = usuarioRp.findAll();
		mav.addObject("usuarios", usuarios);
		return mav;
	}
	
	@PostMapping("/salvarMotorista")
	public ModelAndView salvarMotorista(Usuario usuario) {
		ModelAndView mav = new ModelAndView("usuarios/usuario");
		ArrayList<Role> roles = new ArrayList<>();
		roles.add(roleRp.findByName("ROLE_MOTORISTA"));
		usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
		usuario.setRoles(roles);
		usuarioRp.save(usuario);
		Iterable<Usuario> usuarios = usuarioRp.findAll();
		mav.addObject("usuarios", usuarios);
		return mav;
	}

	@GetMapping("/editarAdmin/{idusuario}")
	public ModelAndView editarAdmin(@PathVariable("idusuario") Long idusuario) {
		ModelAndView mav = new ModelAndView("usuarios/cadastroAdmin");
		Optional<Usuario> usuario = usuarioRp.findById(idusuario);
		mav.addObject("usuario", usuario.get());
		return mav;

	}
	
	@GetMapping("/editarGerente/{idusuario}")
	public ModelAndView editarGerente(@PathVariable("idusuario") Long idusuario) {
		ModelAndView mav = new ModelAndView("usuarios/cadastroGerente");
		Optional<Usuario> usuario = usuarioRp.findById(idusuario);
		mav.addObject("usuario", usuario.get());
		return mav;

	}
	
	@GetMapping("/editarMotorista/{idusuario}")
	public ModelAndView editarMotorista(@PathVariable("idusuario") Long idusuario) {
		ModelAndView mav = new ModelAndView("usuarios/cadastroMotorista");
		Optional<Usuario> usuario = usuarioRp.findById(idusuario);
		mav.addObject("usuario", usuario.get());
		return mav;

	}
	
	@GetMapping("/removerusuario/{idusuario}")
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
