package com.example.carros.api;

import java.util.List;

import com.example.carros.domain.Carro;
import com.example.carros.domain.CarrosService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Quando acessar a URL ele vai retornar a lista de carros, essa lista foi implementada
 *  na classe carrosservice e chamada no controller por um metodo que retorna uma List
 * video exemplo: https://www.udemy.com/course/springboot-essencial/learn/lecture/14472702#overview
 */

@RestController
@RequestMapping("/api/v1/carros")
public class CarroController {

    private CarrosService service =  new CarrosService();

    @GetMapping
    public List<Carro> get(){
        return service.getCarros();
    }

}
