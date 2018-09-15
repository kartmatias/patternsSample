package com.uece.br.decorator;

public class FrozenBase implements IFrozenItem{
    private String nome;
    private double preco;

    public FrozenBase(String nome, double preco){
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public double getPreco() {
        return this.preco;
    }

    @Override
    public String getNome() {
        return this.nome;
    }
}
