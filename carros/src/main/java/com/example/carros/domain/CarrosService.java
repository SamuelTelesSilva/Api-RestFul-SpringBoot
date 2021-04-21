package com.example.carros.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


@Service
public class CarrosService {
    
    public List<Carro> getCarros(){
        List<Carro> carros = new ArrayList<>();

        carros.add(new Carro(1L, "Fusca"));
        carros.add(new Carro(2L, "BMW"));
        carros.add(new Carro(3L, "GOL"));
        carros.add(new Carro(4L, "CHEVETE"));

        return carros;
    } 

}
