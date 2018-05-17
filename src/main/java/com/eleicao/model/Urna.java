package com.eleicao.model;

import java.io.Serializable;

public class Urna implements Serializable{
    
    private final String nome;

    public Urna(String nome) {
        this.nome = nome;
    }
   

    public String getNome() {
        return nome;
    }
    
    
}
