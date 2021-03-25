package com.projeto.veiculos.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.veiculos.models.Veiculo;
import com.projeto.veiculos.repositories.VeiculoRepository;

@Controller
public class VeiculoController {

	@Autowired
	VeiculoRepository veiculoRp;

	/*  */

	@GetMapping("/veiculos")
	public ModelAndView ListaVeiculos() {
		ModelAndView mav = new ModelAndView("veiculo/veiculo");
		Iterable<Veiculo> veiculos = veiculoRp.findAll();
		mav.addObject("veiculos", veiculos);
		return mav;
	}

	@GetMapping("/cadastroVeiculo")
	public ModelAndView cadastrarVeiculo() {
		ModelAndView mav = new ModelAndView("veiculo/cadastroVeiculo");
		mav.addObject("veiculo", new Veiculo());
		return mav;
	}

	/* */
	@PostMapping("/salvarveiculo")
	public ModelAndView salvarVeiculo(Veiculo veiculo) {
		veiculoRp.save(veiculo);
		ModelAndView mav = new ModelAndView("veiculo/veiculo");
		Iterable<Veiculo> veiculos = veiculoRp.findAll();
		mav.addObject("veiculos", veiculos);
		return mav;
	}
	
	@GetMapping("/editarveiculo/{idveiculo}")
	public ModelAndView editarVeiculo(@PathVariable("idveiculo") Long idveiculo) {
		ModelAndView mav = new ModelAndView("veiculo/cadastroVeiculo");
		Optional<Veiculo> veiculo = veiculoRp.findById(idveiculo);
		mav.addObject("veiculo", veiculo.get());
		return mav;
	}
	
	@GetMapping("/removerveiculo/{idveiculo}")
	public ModelAndView excluirVeiculo(@PathVariable("idveiculo") Long idveiculo) {
		veiculoRp.deleteById(idveiculo);
		ModelAndView mav = new ModelAndView("veiculo/veiculo");
		Iterable<Veiculo> veiculos = veiculoRp.findAll();
		mav.addObject("veiculos", veiculos);
		return mav;
	}

}
