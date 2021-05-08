package com.projeto.veiculos.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.veiculos.models.Servico;
import com.projeto.veiculos.repositories.ServicoRepository;
import com.projeto.veiculos.repositories.UsuarioRepository;
import com.projeto.veiculos.repositories.VeiculoRepository;

@Controller
public class ServicoController {
	
	@Autowired
	ServicoRepository servicoRp;
	
	@Autowired
	VeiculoRepository veiculoRp;
	
	@Autowired
	UsuarioRepository usuarioRp;
	
	@GetMapping("/servico")
	public ModelAndView ListaServicos() {
		ModelAndView mav = new ModelAndView("servicos/servico");
		Iterable<Servico> servicos = servicoRp.findAll();
		mav.addObject("veiculos", veiculoRp.findAll());
		mav.addObject("usuarios", usuarioRp.findAll());
		mav.addObject("servicos", servicos);
		return mav;
	}
	
	@GetMapping("/cadastroServico")
	public ModelAndView cadastrarServico() {
		ModelAndView mav = new ModelAndView("servicos/cadastroServico");
		mav.addObject("servico", new Servico());
		mav.addObject("veiculos", veiculoRp.findAll());
		mav.addObject("usuarios", usuarioRp.findAll());
		return mav;
	}
	
	@PostMapping("/salvarServico")
	public ModelAndView salvarServico(Servico servico) {
		servicoRp.save(servico);
		ModelAndView mav = new ModelAndView("servicos/servico");
		Iterable<Servico> servicos = servicoRp.findAll();
		mav.addObject("veiculos", veiculoRp.findAll());
		mav.addObject("usuarios", usuarioRp.findAll());
		mav.addObject("servicos", servicos);
		return mav;
	}
	
	@GetMapping("/editarServico/{idservico}")
	public ModelAndView editarServico(@PathVariable("idservico") Long idservico) {
		ModelAndView mav = new ModelAndView("servicos/cadastroServico");
		Optional<Servico> servico = servicoRp.findById(idservico);
		mav.addObject("servico", servico.get());
		mav.addObject("veiculos", veiculoRp.findAll());
		mav.addObject("usuarios", usuarioRp.findAll());
		return mav;
	}
	
	@GetMapping("/removerServico/{idservico}")
	public ModelAndView excluirServico(@PathVariable("idservico") Long idservico) {
		servicoRp.deleteById(idservico);
		ModelAndView mav = new ModelAndView("servicos/servico");
		mav.addObject("veiculos", veiculoRp.findAll());
		mav.addObject("usuarios", usuarioRp.findAll());
		mav.addObject("servicos", servicoRp.findAll());
		return mav;
	}

}
