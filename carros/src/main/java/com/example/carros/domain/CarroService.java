package com.example.carros.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;


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

    public List<Carro> getCarrosByTipo(String tipo){
        return carrosRepository.findByTipo(tipo);
    }

    public Carro insert(Carro carro) {
        Assert.isNull(carro.getId(), "Não foi possivel inserir o registro");
        return carrosRepository.save(carro);
    }

    public Carro update(Carro carro, Long id){
        Assert.notNull(id, "Não foi possivel atualizar o registro");

        //Buscar o carro no bd
        Optional<Carro> optional = getCarrosById(id);
        if(optional.isPresent()){
            Carro db = optional.get();

            //copia as propriedades
            db.setNome(carro.getNome());
            db.setTipo(carro.getTipo());

            //Atualiza o registro
            carrosRepository.save(db);
            return db;
        }else{
            throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        Optional<Carro> carro = getCarrosById(id); 
        if(carro.isPresent()){
            carrosRepository.deleteById(id);
        }
    }



     

}
