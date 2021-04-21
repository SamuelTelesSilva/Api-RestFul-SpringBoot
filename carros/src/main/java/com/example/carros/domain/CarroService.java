package com.example.carros.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CarroService {

    @Autowired
    CarrosRepository carrosRepository;
    

    public Iterable<Carro> getCarros(){
        return carrosRepository.findAll();
    }



    public List<Carro> getCarrosFake(){
        List<Carro> carros = new ArrayList<>();

        carros.add(new Carro(1L, "Fusca"));
        carros.add(new Carro(2L, "BMW"));
        carros.add(new Carro(3L, "GOL"));
        carros.add(new Carro(4L, "CHEVETE"));

        return carros;
    } 

}
