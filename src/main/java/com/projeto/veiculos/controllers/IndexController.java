package com.projeto.veiculos.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.veiculos.models.Role;
import com.projeto.veiculos.models.Servico;
import com.projeto.veiculos.models.Usuario;
import com.projeto.veiculos.repositories.RoleRepository;
import com.projeto.veiculos.repositories.ServicoRepository;
import com.projeto.veiculos.repositories.UsuarioRepository;
import com.projeto.veiculos.repositories.VeiculoRepository;

@Controller
public class IndexController {
	
	@Autowired
	ServicoRepository servicoRp;
	
	@Autowired
	VeiculoRepository veiculoRp;
	
	@Autowired
	UsuarioRepository usuarioRp;
	
	@Autowired
	RoleRepository roleRp;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/dashboard")
	public ModelAndView dashboard() {
		ModelAndView mav = new ModelAndView("dashboard");
		
		List<Role> roles = new ArrayList<>(); // lista de regras (vazia)
		roles.add(roleRp.findByName("ROLE_MOTORISTA")); // adicionando regra de motorista na lista
		
		List<Usuario> usuarios = usuarioRp.findAll();
		List<Usuario> motoristas = new ArrayList<>(); // lista de motoristas (vazia)
		
		for (Usuario usuario : usuarios) {
				if (usuario.getRoles().get(0) == roles.get(0)) {
					motoristas.add(usuario); // adicionando usuarios do tipo motoristas na lista de motoristas
				}
		}
		
		
		mav.addObject("motoristas" ,motoristas);
		mav.addObject("veiculos", veiculoRp.findAll());
		List<Servico> servicos = servicoRp.findAll();
		mav.addObject("servicos", servicos);
		
		
		return mav;
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
    @RequestMapping("/acesso-negado")
    public String accessDenied() {
        return "/erros/acesso-negado";
    }

}
