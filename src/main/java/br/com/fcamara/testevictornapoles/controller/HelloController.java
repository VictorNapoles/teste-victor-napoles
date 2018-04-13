package br.com.fcamara.testevictornapoles.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@RequestMapping("/")
    public String index() {
        return "Desafio Técnico Saraiva - Analista JAVA - Victor de Nápoles dos Santos";
    }
}
