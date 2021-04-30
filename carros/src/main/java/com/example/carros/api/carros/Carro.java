package com.example.carros.api.carros;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Carro {

    /**
     * Um objeto pode ter muitos atributos, para retornar apenas os atributos que eu quero é utilizado o DTO
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String tipo;
    private String descricao;
    private String urlFoto;
    private String urlVideo;
    private String latitude;
    private String longitude;
    private String url_foto;

    
}
