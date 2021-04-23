package com.example.carros.api.carros;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.carros.api.infra.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;


@Service
public class CarroService {

    @Autowired
    CarrosRepository carrosRepository;
    

    public List<CarroDTO> getCarros(Pageable pageable){
        return carrosRepository.findAll(pageable).stream().map(CarroDTO::create).collect(Collectors.toList());
    }

    public CarroDTO getCarrosById(Long id){
        Optional<Carro> carro = carrosRepository.findById(id);
        return carro.map(CarroDTO::create).orElseThrow(() -> new ObjectNotFoundException("Carro não encontrado"));
    }

    public List<CarroDTO> getCarrosByTipo(String tipo, Pageable pageable){
        return carrosRepository.findByTipo(tipo, pageable).stream().map(CarroDTO::create).collect(Collectors.toList());
    }

    public List<CarroDTO> search(String query) {
        return carrosRepository.findByNomeContaining(query).stream().map(CarroDTO::create).collect(Collectors.toList());
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
