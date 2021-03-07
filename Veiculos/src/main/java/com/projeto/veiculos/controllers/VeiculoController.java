package com.projeto.veiculos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.veiculos.models.Veiculo;
import com.projeto.veiculos.repositories.VeiculoRepository;

@Controller
public class VeiculoController {
	
	@Autowired
	VeiculoRepository veiculoRp;
	
	/*  */
	
	@GetMapping("/veiculo")
	public ModelAndView ListaVeiculos() {
		ModelAndView mav = new ModelAndView("veiculo/veiculo");
		Iterable<Veiculo> veiculos = veiculoRp.findAll();
		mav.addObject("veiculos", veiculos);
		return mav;
	}
	
	@GetMapping("/cadastroVeiculo")
	public String cadastrarVeiculo() {
		return "veiculo/cadastroVeiculo";
	}
	
	/* */
	@PostMapping(value = "/salvarveiculo")
	public ModelAndView salvarVeiculo(Veiculo veiculo)  {
			ModelAndView andView = new ModelAndView("veiculo/cadastroVeiculo");
			veiculoRp.save(veiculo);
			return andView;
		}

}
