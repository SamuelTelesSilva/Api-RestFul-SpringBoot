package com.example.carros.api;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String get(){
        return "Hello Spring booot";
    }

    /**
     * Aqui estou usando o @RequestParam para passar parametros via URL, ex: @RequestParam("login");
     * como passar os parametros via URL usando o metodo GET (não é viavel passar senhas via URL):
     * vai na URL e digite no final ?parametro=conteudo&parametro=conteudo
     * exemplo: localhost:8080/login?login=samuel&senha=123
     * sempre que tiver mais parametros voce add o & no final.
     * @param login
     * @param senha
     * @return
     */
    @GetMapping("/login")
    public String login(@RequestParam("login")  String login, @RequestParam("senha") String senha){
        return "Login: " + login + ", Senha: " + senha;
    }

    

    

}
