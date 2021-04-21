package com.example.carros.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CarroService {

    @Autowired
    CarrosRepository carrosRepository;
    

    public Iterable<Carro> getCarros(){
        return carrosRepository.findAll();
    }

    public Optional<Carro> getCarrosById(Long id){
        return carrosRepository.findById(id);
    }

    public Iterable<Carro> getCarrosByTipo(String tipo){
        return carrosRepository.findByTipo(tipo);
    }

    public Carro save(Carro carro) {
        return carrosRepository.save(carro);
    }

     

}
