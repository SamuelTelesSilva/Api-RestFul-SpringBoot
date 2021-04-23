package com.example.carros.api.carros;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.carros.api.infra.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;


@Service
public class CarroService {

    @Autowired
    CarrosRepository carrosRepository;
    

    public List<CarroDTO> getCarros(){
        return carrosRepository.findAll().stream().map(CarroDTO::create).collect(Collectors.toList());
    }

    public CarroDTO getCarrosById(Long id){
        Optional<Carro> carro = carrosRepository.findById(id);
        return carro.map(CarroDTO::create).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
    }

    public List<CarroDTO> getCarrosByTipo(String tipo){
        return carrosRepository.findByTipo(tipo).stream().map(CarroDTO::create).collect(Collectors.toList());
    }

    public CarroDTO insert(Carro carro) {
        Assert.isNull(carro.getId(), "Não foi possivel inserir o registro");
        return CarroDTO.create(carrosRepository.save(carro));
    }

    public CarroDTO update(Carro carro, Long id) {
        Assert.notNull(id,"Não foi possível atualizar o registro");

        // Busca o carro no banco de dados
        Optional<Carro> optional = carrosRepository.findById(id);
        if(optional.isPresent()) {
            Carro db = optional.get();

            // Copiar as propriedades
            db.setNome(carro.getNome());
            db.setTipo(carro.getTipo());
            System.out.println("Carro id " + db.getId());

            // Atualiza o carro
            carrosRepository.save(db);

            return CarroDTO.create(db);
        } else {
            return null;
            //throw new RuntimeException("Não foi possível atualizar o registro");
        }
    }

    public void delete(Long id) {
        carrosRepository.deleteById(id);
    }

}