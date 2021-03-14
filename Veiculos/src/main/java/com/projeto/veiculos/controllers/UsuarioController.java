package com.projeto.veiculos.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.veiculos.DTO.UsuarioDTO;
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
		ModelAndView mav = new ModelAndView("usuarios/cadastroUsuario");
		List<Role> roles = (List<Role>) roleRp.findAll();
		mav.addObject("roles", roles);
		return mav;
	}
	
	@PostMapping("/salvarUsuario")
	public ModelAndView salvarUsuario(UsuarioDTO usuariodto)  {
			ModelAndView mav = new ModelAndView("usuarios/usuario");
			Usuario usuario = new Usuario();
			// usuario.setId(usuariodto.getNome());
			usuario.setNome(usuariodto.getNome());
			usuario.setLogin(usuariodto.getLogin());
			usuario.setSenha(usuariodto.getSenha());
			usuario.setValidadeCNH(usuariodto.getValidadeCNH());
			usuario.setTipoCNH(usuariodto.getTipoCNH());
			ArrayList<Role> roles = new ArrayList<>();
			for (Long roleId : usuariodto.getRoles()) {
				if(roleId == null) continue;
				roles.add(roleRp.findById(roleId).get());
				
			}
			usuario.setRoles(roles);
			usuarioRp.save(usuario);
			Iterable<Usuario> usuarios = usuarioRp.findAll();
			mav.addObject("usuarios", usuarios);
			return mav;
		}

}
