package com.example.carros.api.carros;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarrosRepository extends JpaRepository<Carro,Long>{
    List<Carro> findByTipo(String tipo, Pageable pageable);
}
