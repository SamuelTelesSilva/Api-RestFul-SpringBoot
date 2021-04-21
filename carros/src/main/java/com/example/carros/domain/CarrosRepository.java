package com.example.carros.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CarrosRepository extends CrudRepository<Carro,Long>{
    List<Carro> findByTipo(String tipo);
}
