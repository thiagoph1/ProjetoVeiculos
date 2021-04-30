package com.projeto.veiculos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard() {
		return "dashboard";
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
