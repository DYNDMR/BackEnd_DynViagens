package com.br.dyn.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
@RequestMapping("/")
public class UsuarioController {
	@GetMapping("/hello")
	public String hello() {
		System.out.println("funfou");
		return "hello";
	}
	

}
