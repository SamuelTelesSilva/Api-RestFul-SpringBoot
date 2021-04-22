package com.example.carros.domain.dto;

import com.example.carros.domain.Carro;

import org.modelmapper.ModelMapper;

import lombok.Data;

@Data
public class CarroDTO {
    private Long id;
    private String nome;
    private String tipo;

    public static CarroDTO create(Carro carro) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(carro, CarroDTO.class);
    }
    
}
