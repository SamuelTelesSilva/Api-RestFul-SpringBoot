package com.example.carros.api.carros;

import org.modelmapper.ModelMapper;

import lombok.Data;

@Data
public class CarroDTO {
    private Long id;
    private String nome;
    private String tipo;
    private String url_foto;

    public static CarroDTO create(Carro carro) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(carro, CarroDTO.class);
    }
    
}
