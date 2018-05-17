package com.eleicao.model;

import java.io.Serializable;

public class Candidato implements Serializable{
    
    private final String nome;

    public Candidato(String nome) {
        this.nome = nome;
    }
   

    public String getNome() {
        return nome;
    }

    public boolean equals(Candidato obj) {
        return obj.getNome().equals(this.nome);
    }
    
    
}
