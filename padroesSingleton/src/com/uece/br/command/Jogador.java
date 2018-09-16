package com.uece.br.command;

public class Jogador {
    private String nome;

    public Jogador(String nome){
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Jogador: "+this.nome;
    }
}
