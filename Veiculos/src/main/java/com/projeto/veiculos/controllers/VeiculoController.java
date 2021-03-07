package com.projeto.veiculos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VeiculoController {
	
	@RequestMapping("/dashboard")
	public String dashboard() {
		return "dashboard";
	}

}
