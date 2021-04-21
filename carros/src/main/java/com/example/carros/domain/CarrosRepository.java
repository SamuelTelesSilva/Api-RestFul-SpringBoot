package com.example.carros.domain;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrosRepository extends JpaRepository<Carro,Long>{
    List<Carro> findByTipo(String tipo);
}
