package com.example.carros.domain;

import org.springframework.data.repository.CrudRepository;

public interface CarrosRepository extends CrudRepository<Carro,Long>{
    Iterable<Carro> findByTipo(String tipo);
}
