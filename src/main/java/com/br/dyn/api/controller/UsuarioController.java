package com.br.dyn.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.br.dyn.api.model.Usuario;
import com.br.dyn.api.repository.UsuarioRepository;

@Controller
@ResponseBody
@RequestMapping("/")
public class UsuarioController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@GetMapping("/hello")
	public String hello() {
		System.out.println("funfou");
		return "hello";
	}
	
	@GetMapping("/listar")
	public List<Usuario> lista(){
		List<Usuario> user = usuarioRepository.findAll();
		return user;
		
	}
	@PostMapping("/cadastrar")
	public ResponseEntity<?> cadastrar(@RequestBody Usuario user){
		Optional<Usuario> usuario = usuarioRepository.findByEmail(user.getEmail());
		if (usuario.isPresent()) {
			System.out.println("Este e-mail já está cadastrado!");
			return ResponseEntity.badRequest().build();
			
		}else {
			usuarioRepository.save(user);
			System.out.println("e-mail pode ser cadastrado");
			return ResponseEntity.ok("Cadastrado!");
	
		}
		
	}
	 

}
