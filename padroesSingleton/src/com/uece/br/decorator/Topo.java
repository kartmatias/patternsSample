package com.uece.br.decorator;

public class Topo extends Extra{


    public Topo(String nome, double preco, IFrozenItem frozen){
        super(nome, preco, frozen);
    }

    public double getPreco() {
        return this.preco+frozen.getPreco();
    }

    public String getNome() {
        return frozen.getNome()+" com topo de "+this.nome;
    }
}
