package com.example.carros.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
     * Aqui estou usando o @PathVariable para passar parametros via URL, ex: @PathVariable("login");
     * como passar os parametros via URL usando o metodo GET (não é viavel passar senhas via URL):
     * vai na URL e digite no final /login/{login}/senha/{senha}
     * exemplo: http://localhost:8080/login/samuel/senha/124
     * @param login
     * @param senha
     * @return
     */
    @GetMapping("/login/{login}/senha/{senha}")
    public String login(@PathVariable("login")  String login, @PathVariable("senha") String senha){
        return "Login: " + login + ", Senha: " + senha;
    }

    //Exemplo pegando por id usando o @PathVariable
    @GetMapping("/carro/{id}")
    public String getCarroByid(@PathVariable("id") Long id){
        return "Carro " + id;
    }
    //Exemplo pegando por tipo usando o @PathVariable
    @GetMapping("/carro/tipo/{tipo}") 
    public String getCarroByTipo(@PathVariable("tipo") String tipo){
        return " Lista de Carros Carro " + "Tipo " + tipo;
    }

    

    

}
