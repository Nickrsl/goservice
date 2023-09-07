package com.soulcode.goserviceapp.domain;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Table
@Entity
@Getter @Setter
public class Endereco implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(length = 100)
    private String logradouro;


    @Column(length = 10)
    private String numero;



    @Column(length = 10)
    private String cidade;


    @Column(length = 2)
    private String uf;




    public Endereco() {
    }

    public Endereco(String logradouro, String numero, String cidade, String uf) {
        this.logradouro = logradouro;
        this.numero = numero;
        this.cidade = cidade;
        this.uf = uf;
    }
}




