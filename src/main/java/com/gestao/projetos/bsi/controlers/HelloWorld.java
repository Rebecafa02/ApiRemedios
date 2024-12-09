package com.gestao.projetos.bsi.controlers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloWorld {

	@GetMapping
	public String olaMundo() {
		return "Hello World";
	}
}
